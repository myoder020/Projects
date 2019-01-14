import re
with open('5.txt') as fh:
    fileContents = fh.readlines()

badString = ['ab', 'cd', 'pq', 'xy']
vowels = ['a','e','i','o','u']
naughtyCnt = 0
nice = 0
pattern = r'(.)\1+'
pattern2 = r'(.).\1'
pattern3 = r'(.)(.).*\1\2'


# for line in fileContents:
#     naughty = False
#     vowelCnt = 0
#     line = line.strip()
#     for i in badString:
#         if i in line:
#             naughtyCnt += 1
#             naughty = True
#             break
#     if naughty:
#         continue
#     sObj = re.search(pattern, line)
#     if(sObj):
#         for i in vowels:
#             vowelCnt += line.count(i) 
#             # print(vowelCnt)
    
#     if(vowelCnt > 2):
#         nice += 1

# print(nice)

for line in fileContents:
    line = line.strip()
    sObj = re.search(pattern2, line)
    if(sObj):
        sObj2 = re.search(pattern3, line)
        if sObj2:
            nice += 1

print(nice)
