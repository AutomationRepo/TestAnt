'''
Created on Apr 12, 2017

@author: Shweta
'''
from Coding.Strings import reverseString, reverseString_TwoPointer,  reverseString_ByReversed, reverseString, reversePartOfString,reverseWordsOrderFromString,reverseWordsInString,\
    verifyAnagramStrings,verifyAnagramStrings_sorting,allPermutation,\
    findAllPermutations
from collections import Counter

res = findAllPermutations("abc")
print(res)
'''
gen = (x**2 for x in range(1,5))
lst = [x**2 for x in range(1,5)]
for i in gen:
   print(i)
print(lst)

res =Counter("Shweta")
res['S'] += 1

matrix = [[1 if i==j else 0 for j in range(4)] for i in range(4)]
matrix1 = lambda : [[matrix[i][j] for j in range(len(matrix[1]))] for i in range(len(matrix))]
print(matrix)
print(matrix1())

 c = collections.Counter(a=2,b=3,c=1)
print(c.get('b'))
   
print(verifyAnagramStrings("Shweta","atewSh"))
print(verifyAnagramStrings_sorting("Sheeta","Shteta"))   

print(reverseString("Shweta"))
print(reverseString_TwoPointer("Shweta"))
print(reverseString_ByReversed("Shweta"))
print(reversePartOfString("Shweta",1,3))
print(reverseWordsOrderFromString( "I am Shweta"))
print(reverseWordsInString( "I am Shweta"))
'''
