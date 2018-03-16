# File name:    String, 3_permutations
# Author:       Samanvitha Basole
# Date created: 3/16/18 
# Python v:     2.7
# Problem:      https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string/0
# Approach:

input = "ABC"
result = ""
resultLen = len(result)

def permutations(input, result, resultLen):
    if resultLen == len(input):
        print result
        return
    for i in range(0, len(input)):
        newResult = result + input[i]
        permutations(input, newResult, resultLen+1)

permutations(input, result, resultLen)
