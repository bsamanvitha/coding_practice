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

# remove spaces from the sentence and prepend those spaces
def addSpacesToFront(input):
    newInp = input.replace(" ", "")
    spaces = len(input) - len(newInp)
    addSpaces = " " * spaces
    return addSpaces + newInp

print (addSpacesToFront("hello how are you bye"))

def checkHalves(input):
    from collections import Counter
    input1 = input[0:len(input)/2]
    if len(input) % 2 == 0:
        input2 = input[len(input)/2:]
    else:
        input2 = input[(len(input)+1) / 2:]
    if Counter(input1) == Counter(input2):
        return "Yes"
    return "No"

print (checkHalves("abba"))
print (checkHalves("abccbba"))

# print second repeated word
def secondRepeated(input):
    from collections import Counter
    counter = Counter(input)
    return counter.most_common(2)[1][0]

print (secondRepeated(('aaa', 'bbb', 'ccc', 'bbb', 'aaa', 'aaa')))