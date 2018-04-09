# File name:    String, 5_romanNumToInt
# Author:       Samanvitha Basole
# Date created: 4/8/18 
# Python v:     2.7
# Problem:      https://practice.geeksforgeeks.org/problems/roman-number-to-integer/0

'''
I = 1
II = 2
III = 3
IV = 4 => 5-1
V = 5
VI = 5+1
VII = 5+2
VIII = 5+3
IX = 10-1
X = 10
X = 11
'''

def recursiveCall(input, previous, sum):
    romans = "IVXLCDM"
    nums = [1, 5, 10, 50, 100, 500, 1,000]
    if input == "":
        return sum
    else:
        sum += nums[romans.index(input[0])]
        if previous < input[0]:
            sum = sum - nums[romans.index(previous)]
        return recursiveCall(input[1:], input[0], sum)

def romanToInt(input):
    return recursiveCall(input, "", 0)

input = "IX"
print str(romanToInt(input))