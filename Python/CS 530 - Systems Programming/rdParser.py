'''
Single Programmer Affidavit
I the undersigned promise that the attached assignment is my own work. While I was
free to discuss ideas with others, the work contained is my own. I recognize that
should this not be the case, I will be subject to penalties as outlined in the course
syllabus.
Your Name Here: Andrick Mercado
'''
import re
from functools import *


class recDescent:
    def __init__(self, expr=""):
        self.expr = expr
        self.index = 0
        self.tokens = []

    def lex(self):
        self.tokens = re.findall("[-\(\)=]|[!<>]=|[<>]|\w+|[^ +]\W+", self.expr)
        self.tokens = list(filter((lambda x: len(x)),
                                  list(map((lambda x: x.strip().lower()), self.tokens))))

    def validate(self):
        self.lex()  # call lec and stores information in the token list
        self.formatTokens()  # changes instances according to the grammar rules

        if (self.checkInts()):  # checks if theres repeated ints
            return False

        if (self.E_Left()):  # expression is valid  true
            if (self.index == len(self.tokens)):  # if iterate through all good
                return True
            else:
                return False
        else:
            return False

    '''
        checkInts(self)
            Checks if there exists repetition of ints and exp's
    '''

    def checkInts(self):
        for i in range(len(self.tokens)):
            if (self.tokens[i] == "int" and i + 1 < len(self.tokens)):
                if (self.tokens[i + 1] == "int"):
                    return True
            if (self.tokens[i] == "exp" and i + 1 < len(self.tokens)):
                if (self.tokens[i + 1] == "exp"):
                    return True
            if (self.tokens[i] == "exp" and i + 1 < len(self.tokens)):
                if (self.tokens[i + 1] != "int"):
                    return True
        if (len(self.tokens) == 1):
            return True

        return False

    '''
        formatTokens(self)
            changes instances of pre defined instancese based on grammar rules made
            types int, op, exp
    '''

    def formatTokens(self):
        for x in range(len(self.tokens)):
            if self.tokens[x].isdigit():
                self.tokens[x] = "int"
            if self.tokens[x] == "and" or self.tokens[x] == "or" or self.tokens[x] == "nand" or self.tokens[
                x] == "xor" or self.tokens[x] == "xnor":
                self.tokens[x] = "op"
            if self.tokens[x] == "<" or self.tokens[x] == ">" or self.tokens[x] == "<=" or self.tokens[x] == ">=" or \
                    self.tokens[x] == "=" or self.tokens[x] == "!=" or self.tokens[x] == "not":
                self.tokens[x] = "exp"

    '''
        compareTokens(self, a)'
            comparess current token with a given comp_string which holds a string of comparison.
            if we have exceded the legal indexes we return false other wise we check if the compared 
            string is in the curren token list, false otherwise
    '''

    def compareTokens(self, comp_string):
        if (self.index >= len(self.tokens)):
            return False
        elif (self.tokens[self.index] == comp_string):
            self.index += 1
            return True
        else:
            return False

    '''
        E_Left(self)
            check if theres a T to the left if there is than we check if theres a E
            true and false accordingly
    '''

    def E_Left(self):
        if (self.T_Left()):
            if (self.E_Right()):
                return True
            else:
                return False
        else:
            return False

    '''
        E_Right()
            here we check if theres a "-" to the right and than call methods that check recursively
    '''

    def E_Right(self):
        if (self.compareTokens("-")):
            if (self.T_Left()):
                if (self.E_Right()):
                    return True
                else:
                    return False
            else:
                return False

        elif (self.compareTokens("int")):
            if (self.T_Right()):
                if (self.E_Right()):
                    return True
                else:
                    return False
            else:
                return False
        else:
            return True

    '''
        T_Left()
            checks of it holds a integer or parathemsis or a exp
    '''

    def T_Left(self):
        if (self.F()):
            if (self.T_Right()):
                return True
            else:
                return False
        else:
            return False

    '''
        T_Right(self)
            check if to the right is op and a expression 
            calls T_Right
    '''

    def T_Right(self):
        if (self.compareTokens("op")):
            if (self.F()):
                if (self.T_Right()):
                    return True
                else:
                    return False
            else:
                return False
        else:
            return True

    '''
        F(self)
            checks if theres parenthesis or int or exp. 
    '''

    def F(self):
        if (self.compareTokens("(")):
            if (self.E_Left()):
                if (self.compareTokens(")")):
                    return True
                else:
                    return False
            else:
                return False
        elif (self.compareTokens("int")):
            return True

        elif (self.compareTokens("exp")):
            return True

        else:
            return False