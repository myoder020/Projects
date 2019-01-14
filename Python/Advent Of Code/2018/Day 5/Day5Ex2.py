import re
with open('Day5.txt') as fh:
    fileContents = fh.readline()

origContents = str(fileContents)

for i in range(97,123):
    fileContents = origContents
    charPattern = chr(i)+'|'+chr(i).upper()
    fileContents = re.sub(charPattern,'',fileContents)
    prevChar = ''
    EOS = False
    currPos = 0
    cnt = 0
    prevLen = 0
    while not EOS:
        startOver = False
        for j in range(97,123):
            pattern = chr(j)+chr(j).upper()+'|'+chr(j).upper()+chr(j)
            fileContents = re.sub(pattern,'', fileContents)   
            cnt += 1
            
        if prevLen == len(fileContents):
            print(len(fileContents))
            EOS = True
            
        prevLen = len(fileContents)

    