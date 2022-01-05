#!/usr/bin/python
# FileName: Subsampling.py
# Version 1.0 by Tao Ban, 2010.5.26
# This function extract all the contents, ie subject and first part from the .eml file
# and store it in a new file with the same name in the dst dir.

import csv
import email.parser
import functools
import os, sys, stat
import re
import glob
import shutil
from functools import reduce
from numpy import array
import numpy as np
import pandas as pd
from numpy.compat import long
from sklearn.feature_extraction.text import CountVectorizer
import operator


def read_file(filename):
    '''
    use email to process the email content
    :param filename: email path
    :return: email title and content
    '''
    with open(filename, encoding='latin-1') as fp:
        msg = email.message_from_file(fp)
        payload = msg.get_payload()
        if type(payload) == type(list()):
            payload = payload[0]
        if type(payload) != type(''):
            payload = str(payload)

        sub = msg.get('subject')
        sub = str(sub)
        regex = re.compile('[^a-zA-Z ]')
        sub = regex.sub('', sub)
        payload = regex.sub('', payload)
        remove = ['func', 'font', 'tr', 'td', 'type', 'integer', 'argsCARD', 'argsDEV', 'defaulttimerclass',
                  'argsCLASS', 'args', 'CLASS', 'SCLASS']
        for i in remove:
            regex = re.compile(r'\b(' + i + r')\b', flags=re.IGNORECASE)
            sub = regex.sub('', sub)
            payload = regex.sub('', payload)
        sub = re.sub(r'\b\w{10,40000}\b', '', sub)
        payload = re.sub(r'\b\w{10,40000}\b', '', payload)
        return sub + payload


def numericalSort(value):#for sorting files
    numbers = re.compile(r'(\d+)')
    parts = numbers.split(value)
    parts[1::2] = map(int, parts[1::2])
    return parts


###################################################################
# main function start here
# srcdir is the directory where the .eml are stored

print('Input training data directory: ')  # ask for source and dest dirs
srcdir = input()
if not os.path.exists(srcdir):
    print('The source directory %s does not exist, exit...' % (srcdir))
    sys.exit()
# dstdir is the directory where the content .eml are stored
print('Input testing directory: ')  # ask for source and dest dirs
dstdir = input()
if not os.path.exists(dstdir):
    print('The source directory %s does not exist, exit...' % (dstdir))
    sys.exit()

###################################################################

# srcdir = "./TR"
# dstdir = "./TT"

'''array of words contains the occurance count of words'''
files = sorted(glob.glob(srcdir + "/*.eml"), key=numericalSort)
array_of_words = []
for file in files:
    array_of_words.append(read_file(file))
vectorizer = CountVectorizer()
X = vectorizer.fit_transform(array_of_words)
word_list_columns = vectorizer.get_feature_names()
''' end if word counting'''

'''extract correct labels of the test data'''
array_of_is_spam = []
with open('spam-mail.tr.label') as csv_file:
    csv_reader = csv.reader(csv_file, delimiter=',')
    line_count = 0
    for row in csv_reader:
        if line_count == 0:
            line_count += 1
        else:
            array_of_is_spam.append(int(row[1]))
array_of_is_spam = 1 - array((array_of_is_spam))
    #flip 0 and 1's because profesor said they were wrong :/
''' end of extraction'''

'''sum of columns separated by spam or no spam'''
df = pd.DataFrame(X.toarray())

indices_spam = [i for i, x in enumerate(array_of_is_spam) if x == 1]
sum_of_each_col_spam = []
new_df_is_spam = df.iloc[indices_spam]
for i in range(len(new_df_is_spam.columns)):
    sum_of_each_col_spam.append(new_df_is_spam[i].sum())

indices_not_spam = [i for i, x in enumerate(array_of_is_spam) if x == 0]
sum_of_each_col_not_spam = []
new_df_not_spam = df.iloc[indices_not_spam]
for i in range(len(new_df_not_spam.columns)):
    sum_of_each_col_not_spam.append(new_df_not_spam[i].sum())
'''end of sum cols'''

'''probability of spam or no spam'''
dictionary_of_is_spam = {}
for i in array_of_is_spam:
    dictionary_of_is_spam[i] = dictionary_of_is_spam.get(i, 0) + 1
probability_of_spam = dictionary_of_is_spam[1] / len(array_of_is_spam)
probability_of_not_spam = dictionary_of_is_spam[0] / len(array_of_is_spam)
''' end of probabilty'''

'''TESTING FOR FOLDER TO EXTRACT INFO'''
files_TT = sorted(glob.glob(dstdir + "/*.eml"), key=numericalSort)
array_of_words_TT = []
for file in files_TT:
    array_of_words_TT.append(read_file(file))
vectorizer_TT = CountVectorizer()
X_TT = vectorizer_TT.fit_transform(array_of_words_TT)
word_list_columns_TT = vectorizer_TT.get_feature_names()
df_TT = pd.DataFrame(X_TT.toarray())
'''end of extraction'''

'''find indices of same words between both lists'''
hold_indices_same_words = []
for element in range(len(word_list_columns_TT)):
    offset = -1
    while True:
        try:
            offset = word_list_columns.index(word_list_columns_TT[element], offset + 1)
        except ValueError:
            break
        hold_indices_same_words.append(offset)
'''end of finding indices '''

'''calculate the probability of being either spam or not spam'''
calculated_probability_is_spam = [probability_of_spam]
calculated_probability_is_not_spam = [probability_of_not_spam]
naive_bayes_classifier_is_spam = []

for file_num in range(len(df_TT.index)):#iterate all files
    for word in range(len(hold_indices_same_words)):#traverse only the words that are the same
        if df_TT.iloc[file_num][word] != 0:  #if 0 means its not contained
            if sum_of_each_col_spam[hold_indices_same_words[word]] != 0:#if the total sum is 0 we dont run
                calculated_probability_is_spam.append(
                    (df_TT.iloc[file_num][word] ) / (long(sum_of_each_col_spam[hold_indices_same_words[word]])))
            if sum_of_each_col_not_spam[hold_indices_same_words[word]] != 0:#if the total sum is 0 we dont run
                calculated_probability_is_not_spam.append(
                    (df_TT.iloc[file_num][word] ) / (long(sum_of_each_col_not_spam[hold_indices_same_words[word]])))

    if (np.prod(calculated_probability_is_not_spam) >= np.prod(calculated_probability_is_spam)):
        print("File: ", files_TT[file_num], " is not spam")
        naive_bayes_classifier_is_spam.append(0)
    else:
        print("File: ", files_TT[file_num], " is spam")
        naive_bayes_classifier_is_spam.append(1)
    # at end of determing if spam
    calculated_probability_is_spam = [probability_of_spam]
    calculated_probability_is_not_spam = [probability_of_not_spam]
print(naive_bayes_classifier_is_spam)
'''end of calculation'''