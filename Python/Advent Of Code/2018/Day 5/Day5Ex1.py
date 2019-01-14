with open('Day5Test.txt') as fh:
    fileContents = fh.readline()

prevChar = ''
EOS = False
currPos = 0
# print(fileContents)
# for i in range(len(fileContents)):
while not EOS:
    startOver = False
    if fileContents[currPos].lower() == prevChar.lower() and ((fileContents[currPos].isupper() and prevChar.islower()) or (fileContents[currPos].islower() and prevChar.isupper())):
        # print(currPos, fileContents[currPos], prevChar)
        newString = fileContents[:currPos-1] + fileContents[currPos+1:]
        fileContents = newString
        currPos = 0
        startOver = True
        prevChar = ''
    
    if(startOver == False):
        prevChar = fileContents[currPos]
        currPos += 1        
    
    if currPos == (len(fileContents) - 1):
        EOS = True

print(len(fileContents))