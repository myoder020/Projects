import re
with open('8.txt') as fh:
    fileContents = [i.strip() for i in fh.readlines()]

# bPattern = r'\\'
hexPattern = r'\\x..|\\\\|\\"'
res = {}

for line in fileContents:
    totalCnt = 0
    hexChars = 0
    # bSearch = re.search(bPattern,i)
    hexSearch = re.findall(hexPattern,line)

    # if bSearch:
    #     print(i)
    #     print(bSearch)

    for i in hexSearch:
        if i.startswith("\\x"):
            hexChars += 3
        else:
            hexChars += 1

    print(line, len(line), hexChars, (len(line) - hexChars - 2))
    totalCnt = len(line) - (len(line) - hexChars - 2)
    res[line] = totalCnt
    print(totalCnt)

total = 0

for k,v in res.items():
    total += v

print(total)