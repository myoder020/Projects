from collections import defaultdict
import operator

with open('Day4Puzzle.txt') as fh:
    fileContents = fh.readlines()

fileContents = sorted(fileContents)
testDD = defaultdict(int)

for x in fileContents:
    spliceStr = x.split()
    date = spliceStr[0][1:]
    time = spliceStr[1].split(':')
    hour = int(time[0])
    minute = int(time[1][:-1])

    if 'Guard' in x:
        gid = spliceStr[3][1:]
    elif 'falls' in x:
        fellAsleepMin = minute
    elif 'wakes' in x:
        for i in range(fellAsleepMin, minute):
            testDD[(gid, i)] += 1

maxMinute = sorted(testDD.items(),key=operator.itemgetter(1),reverse=True)
k,v = maxMinute[0]
print(k[0], k[1], int(k[0]) * k[1])