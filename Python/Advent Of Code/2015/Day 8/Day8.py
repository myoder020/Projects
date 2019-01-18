import re
with open('8.txt') as fh:
    fileContents = [i.strip() for i in fh.readlines()]

# bPattern = r'\\'
hexPattern = r'\\x..|\\\\|\\"'
res = {}
totalStringLiterals = 0
totalHexChars = 0
totalNStringLiterals = 0

for line in fileContents:
    totalStringLiterals += len(line)
    totalCnt = 0
    hexChars = 0
    nline = ""

    hexSearch = re.findall(hexPattern,line)

    for i in hexSearch:
        if i.startswith("\\x"):
            hexChars += 3
        else:
            hexChars += 1
        
    totalHexChars += (len(line) - hexChars - 2)
    totalCnt = len(line) - (len(line) - hexChars - 2)
    res[line] = totalCnt
    nline = line.replace('\\','\\\\')
    nline = '"'+nline.replace('\"','\\"')+'"'
    totalNStringLiterals += len(nline)
    print(line, nline)
    

print(totalStringLiterals-totalHexChars)
print(totalNStringLiterals-totalStringLiterals)