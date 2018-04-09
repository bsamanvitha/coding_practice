# File name:    coding_practice, 7_removeDuplicates
# Author:       Samanvitha Basole
# Date created: 4/8/18 
# Python v:     2.7
# Problem:      https://practice.geeksforgeeks.org/problems/remove-duplicates/0

def removeDuplicates(input):
    result = ""
    for each in input:
        if each not in result:
            result += each
    return result

print removeDuplicates("geeksforgeeks")
print removeDuplicates("geeks for geeks")