# File name:    String, 1_parenthesesChecker
# Author:       Samanvitha Basole
# Date created: 3/14/18 
# Python v:     2.7
# Problem:      https://practice.geeksforgeeks.org/problems/parenthesis-checker/0
# Approach:
'''
Use a dictionary
Move through the input string and increment count for opening braces
Decrement count for closing braces
Dictionary should have all 0 values to be balanced
'''

counter = {'[': 0, '{': 0, '(': 0}
input1 = "[()]{}{[()()]()}"
input2 = "[(])"

def paren_checker(input):
    for i in input:
        if i == '[':
            counter['['] += 1
        if i == '(':
            counter['('] += 1
        if i == '{':
            counter['{'] += 1
        if i == ']':
            counter['['] -= 1
        if i == ')':
            counter['('] -= 1
        if i == '}':
            counter['{'] -= 1
    for val in counter.values():
        if val != 0:
            return "not balanced" + " " + input
    return "balanced" + " " + input
print paren_checker(input1)
print paren_checker(input2)