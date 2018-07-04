# File name:    coding_practice, 8_MoreStringOps
# Author:       Samanvitha Basole
# Date created: 7/4/18 
# Python v:     2.7


# check if palindrome or not

def isPalindrome(input):
    revInput = input[::-1]
    if input == revInput:
        return True
    return False

def isPalindrome2(input):
    inp_len = len(input)
    for i in range(0, len(input)/2):
        if input[i] != input[inp_len-i-1]:
            return False
    return True

