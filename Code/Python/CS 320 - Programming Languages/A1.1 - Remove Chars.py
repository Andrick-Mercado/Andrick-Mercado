'''
 * This Program is to find FANBOYS and
 * remove them into easier to read
 * sentences, assuming correct grammar is used
 * Andrick Mercado
 * 2/15/2021
'''
import re

try:
    fileName = input("Enter the file name or directory: ")
    fileInfo = open(fileName, "r")
    phrases = fileInfo.readlines()
    for line in phrases:
        listOfLines = re.split(""",[ ]*for[ ]* |,[ ]*and[ ]* |
        ,[ ]*nor[ ]* |,[ ]*but[ ]* |,[ ]*or[ ]* |,[ ]*yet[ ]* |
        ,[ ]*so[ ]* |,for[ ]* |,and[ ]* |,nor[ ]* |,but[ ]* |
        ,or[ ]* |,yet[ ]* |,so[ ]* """, line) 
        for x in range(len(listOfLines)):
            print(x+1, "\b:", listOfLines[x].lstrip(),"\n")
except:
    print("The given file name or directory was not found") 