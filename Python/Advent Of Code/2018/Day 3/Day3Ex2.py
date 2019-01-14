import re

fh = open("Day3Puzzle.txt")
fabric = [[0 for i in range(1000)] for j in range(1000)]
numOfOverlap = 0
dictLists = []

for x in fh:
    sObj = re.search('#([0-9]+)\s@\s([0-9]+),([0-9]+):\s([0-9]+)x([0-9]+)', x)
    eid =  int(sObj.group(1))
    fLeft = int(sObj.group(2))
    fTop = int(sObj.group(3))
    width = int(sObj.group(4))
    height = int(sObj.group(5))
    i = fLeft
    hasOverlap = "N"
    while i < (fLeft + width):
        j = fTop
        while j < (fTop + height):
            if fabric[i][j] == "X":
                fabric[i][j] = "O"
                hasOverlap = "Y"
            elif fabric[i][j] == "O":
                fabric[i][j] = "O"
                hasOverlap = "Y"
            else:
                fabric[i][j] = "X"
            j += 1
        i += 1
    elfR = {
        "eid": eid,
        "fLeft": fLeft,
        "fTop": fTop,
        "width": width,
        "height": height,
        "hasOverlap": hasOverlap
    }
    dictLists.append(elfR)


for i in range(1000):
    for j in range(1000):
        if fabric[i][j] == "O":
            for x in dictLists:
                if (i >= x['fLeft'] and i <= (x['fLeft'] + x['width'])) and (j >= x['fTop'] and j <= (x['fTop'] + x['height'])):
                    x['hasOverlap'] = 'Y'


for x in dictLists:
    if x['hasOverlap'] == "N":
        print(x['eid'])

fh.close()