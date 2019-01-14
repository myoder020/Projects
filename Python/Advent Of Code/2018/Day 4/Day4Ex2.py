from GuardShiftSched import GuardSched
fh = open('Day4Puzzle.txt')
fileContents = []

for x in fh:
    fileContents.append(x)

fh.close()

sortedContents = sorted(fileContents)

guardSched = GuardSched()

for x in sortedContents:
    guardSched.addRecToList(x)

guardSched.createSchedule()
guardSched.findSleepingMostSpecMin()