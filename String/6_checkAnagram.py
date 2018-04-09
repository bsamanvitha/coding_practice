# File name:    String, 6_checkAnagram
# Author:       Samanvitha Basole
# Date created: 4/8/18 
# Python v:     2.7
# Problem:      https://practice.geeksforgeeks.org/problems/anagram/0

'''
Since order doesn't matter,
create a dictionary
add the letter and corresponding letter counts
for the second word, decrement letters
if not empty, return false
'''

def checkAnagram(input1, input2):
    lettCount = {}
    for each in input1:
        if each in lettCount:
            lettCount[each] += 1
        else:
            lettCount[each] = 1
    for x in input2:
        if x in lettCount:
            lettCount[x] -= 1
        else:
            lettCount[x] = 1
    for key, val in lettCount.items():
        if val != 0:
            return False
    return True


print checkAnagram("geeksforgeeks", "forgeeksgeeks")

print checkAnagram("allergy", "allergic")
