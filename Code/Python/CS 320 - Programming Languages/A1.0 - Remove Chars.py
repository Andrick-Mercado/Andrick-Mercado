'''
 * This Program is to find FANBOYS and
 * remove them into easier to read
 * sentences, assuming correct grammar is used
 * Andrick Mercado
 * 2/4/2021
'''
#prints as per the guidelines
def printPhrase ( str ):
    for x in range(len(str)):
        print(x+1, "\b:", str[x].lstrip(),"\n")
    return

#Starts after the first comma hence needs to be in the first index
def removeFanboys (str):
    for x in range(1, len(str)):
        if str[x].find(" for ") == 0:
            y = str[x].find(" for ")
            str[x] = str[x][y+5: len(str[x])]
        elif str[x].find(" and ") == 0:
            y = str[x].find(" and ")
            str[x] = str[x][y+5: len(str[x])]
        elif str[x].find(" nor ") == 0:
            y = str[x].find(" nor ")
            str[x] = str[x][y+5: len(str[x])]
        elif str[x].find(" but ") == 0:
            y = str[x].find(" but ")
            str[x] = str[x][y+5: len(str[x])]
        elif str[x].find(" or ") == 0:
            y = str[x].find(" or ")
            str[x] = str[x][y+4: len(str[x])]
        elif str[x].find(" yet ") == 0:
            y = str[x].find(" yet ")
            str[x] = str[x][y+5: len(str[x])]
        elif str[x].find(" so ") == 0:
            y = str[x].find(" so ")
            str[x] = str[x][y+4: len(str[x])]
    return str

#Removes other possible occurence of FANBOYS
def removeFanboys2 (str):
    for x in range(1, len(str)):
        if str[x].find("for ") == 0:
            y = str[x].find("for ")
            str[x] = str[x][y+4: len(str[x])]
        elif str[x].find("and ") == 0:
            y = str[x].find("and ")
            str[x] = str[x][y+4: len(str[x])]
        elif str[x].find("nor ") == 0:
            y = str[x].find("nor ")
            str[x] = str[x][y+4: len(str[x])]
        elif str[x].find("but ") == 0:
            y = str[x].find("but ")
            str[x] = str[x][y+4: len(str[x])]
        elif str[x].find("or ") == 0:
            y = str[x].find("or ")
            str[x] = str[x][y+3: len(str[x])]
        elif str[x].find("yet ") == 0:
            y = str[x].find("yet ")
            str[x] = str[x][y+4: len(str[x])]
        elif str[x].find("so ") == 0:
            y = str[x].find("so ")
            str[x] = str[x][y+3: len(str[x])]
    return str

# getting input
fileName = input("Enter the file directory: ") 
file1 = open(fileName ,"r")
phrase = " ".join([str(x) for x in file1.readlines(1)])   #list to string
file1.close()

# attempting to find FANBOYS
if ( phrase.find(", for ") != -1 or phrase.find(", and ") != -1 or phrase.find(", nor ") != -1 or
        phrase.find(", but ") != -1 or phrase.find(", or ") != -1 or phrase.find(", yet ") != -1 or
        phrase.find(", so ") != -1):
    wordArray = phrase.split(",")
    printPhrase(removeFanboys(wordArray))
elif ( phrase.find(",for ") != -1 or phrase.find(",and ") != -1 or phrase.find(",nor ") != -1 or
        phrase.find(",but ") != -1 or phrase.find(",or ") != -1 or phrase.find(",yet ") != -1 or
        phrase.find(",so ") != -1):
    wordArray = phrase.split(",")
    printPhrase(removeFanboys2(wordArray))

else:
    print("No FANBOYS found")
    print("1:", phrase, "\n")
