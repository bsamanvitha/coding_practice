# File name:    String, 4_removeDuplicates
# Author:       Samanvitha Basole
# Date created: 3/26/18 
# Python v:     2.7
# Problem:      https://practice.geeksforgeeks.org/problems/recursively-remove-all-adjacent-duplicates/0

input = "geeksforgeek"

def removeDuplicates(input):
    noDups = ""
    for each in range(0, len(input)):
        index = each
        while checkRepetition(input, index, index+1) == "":
            index += 1
            noDups += checkRepetition(input, index, index+1)
        noDups += input[each]
    print noDups

def checkRepetition(input, startIndex, endIndex):
    if input[startIndex] != input[endIndex]:
        return input[startIndex]
    else:
        return ""

removeDuplicates(input)
