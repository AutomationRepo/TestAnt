'''
Created on Apr 12, 2017
@author: Shweta
'''

from builtins import reversed, sorted, all
from collections import Counter
import itertools
from macpath import join
from itertools import permutations

'''
Reverse string using slice range with -1
'''
def reverseString(inputStr):
    if inputStr is None or len(inputStr) is 0:
        return None
    return inputStr[::-1]
    
'''
Reverse string using two pointers
'''
def reverseString_TwoPointer(inputStr):
    if inputStr is None or len(inputStr) is 0:
        return None
    inputList = list(inputStr)
    listSize = len(inputList)
    for i in range(0,int(listSize/2)):
        inputList[i],inputList[listSize-1-i] = inputList[listSize-1-i], inputList[i]        
    return ''.join(inputList)

'''
Reverse String using built in function reversed
'''
def reverseString_ByReversed(inputStr):
    if inputStr is None or len(inputStr) is 0:
        return None
    return ''.join(reversed(inputStr))

'''
Reverse part of the string using slice range
'''
def reversePartOfString(inputStr,start,end):
    if inputStr is None or len(inputStr) is 0:
        return None
    return inputStr[start:end][::-1]

'''
Reverse words order in string
'''
def reverseWordsOrderFromString(inputStr):
    if inputStr is None or len(inputStr) is 0:
        return None
    return  ' '.join(inputStr.split()[::-1]) 
    '''return inputStr[::-1]
    return ' '.join(reversed(inputStr.split())) '''

'''
Reverse words in string keeping same order
'''
def reverseWordsInString(InputStr):
    if InputStr is None or len(InputStr) is 0:
        return None
    return ' '.join((lambda x: [ch[::-1] for ch in x]) (InputStr.split()))
    ''' return ' '.join(ch[::-1] for ch in InputStr.split())'''

'''
Verify if given strings are anagram or not by using Counter method
'''
def verifyAnagramStrings(input1,input2):
    if (input1 is None and input2 is None):
        return True
    if (input1 is None or input2 is None) or (len(input1) != len(input2)):
        return False
    return Counter(input1) == Counter(input2)

'''
Verify if two strings are anagram by using sorting method
'''
def verifyAnagramStrings_sorting(input1,input2):
    if (input1 is None and input2 is None):
        return True
    if (input1 is None or input2 is None) or (len(input1) != len(input2)):
        return False
    return ''.join(sorted(input1)) == ''.join(sorted(input2))

'''
Find permutations of input from itertools.permutation
'''
def allPermutation_itertool(objInput):
    return  permutations(objInput) 
'''[''.join(word) for word in permutations(objInput)]'''

'''
'''
def allPermutation(objInput):
     _permute(list(objInput), 0)

def _permute(inputList,step=0):
    if step == len(inputList):
        print(''.join(inputList))
    
    for i in range(step,len(inputList)):
        inputCopy = [char for char in inputList]        
        inputCopy[step],inputCopy[i] = inputCopy[i],inputCopy[step]
        _permute(inputCopy, step+1)
        
def findAllPermutations(input,resList = []):
    inputList = list(input)
    if len(inputList) == 1:         
        return resList.append(inputList)
    
    firstChar = inputList[0]
    remaining = inputList[1:]
    findAllPermutations(remaining)
    return _permuteMerge(firstChar, resList)

def _permuteMerge(char,inList,res =[]):
    for item in inList:
        for i in range(0,len(item)):
            itemList = list(item)
            itemList.insert(i, char)
            res.append(''.join(itemList))
    return res
    









