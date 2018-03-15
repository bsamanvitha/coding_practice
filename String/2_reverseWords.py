# File name:    coding_practice, 2_reverseWords
# Author:       Samanvitha Basole
# Date created: 3/15/18 
# Python v:     2.7
# Problem:      https://practice.geeksforgeeks.org/problems/reverse-words-in-a-given-string/0
# Approach:
'''
Reverse a sentence
Reverse each word in that sentence
'''

def reverseString(input):
    if len(input) <= 1:
        return input
    else:
        return reverseString(input[1:]) + input[0]

def reverseWords(input):
    for i in range(0, len(input)):
        if input[i] == '.':
            reverseString(input[:i])
    return input

input = "i.like.this.program.very.much"
print reverseString(input)
print reverseWords(reverseString(input))