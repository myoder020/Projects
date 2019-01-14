import re
import builtins
import operator
from collections import Counter

class GuardSched:

    def __init__(self):
        self.gRecs = []
        self.gid = -10
        self.isAwake = 'Y'
        self.prevGID = -10
        self.prevMin = 0
        self.prevDate = ""
        self.finalSched = []

    def addRecToList(self, sched):
        
        sObj = re.search('\[(.*)\] ([a-zA-Z]+)(\S*) (\S*)', sched)
        dateSObj = re.search('[0-9]+-([0-9]+-[0-9]+) ([0-9]+):([0-9]+)', sObj.group(1))
        date = dateSObj.group(1)
        hour = int(dateSObj.group(2))
        minute = int(dateSObj.group(3))
        if(sObj.group(2) == "Guard"):
            guardSObj = re.search('^\#([0-9]+)', sObj.group(4))
            self.gid = guardSObj.group(1)
        elif(sObj.group(2) == "falls"):
            self.isAwake = 'N'
        else:
            self.isAwake = 'Y'

        gRec = {
            "gid": self.gid,
            "date": date,
            "hour": hour,
            "minute": minute,
            "isAwake": self.isAwake
        }
        self.gRecs.append(gRec)
        
    def getRecs(self):
        return self.gRecs
    
    def createSchedule(self):
        # print("Date", " ", "ID", " ", "Minute")
        prevTemp = []
        temp = []
        minsAsleep = 0
        for x in self.gRecs:
            if x['hour'] == 0:
                if(self.prevGID != x['gid'] or self.prevDate != x['date']):
                    temp = ['.' for i in range(60)]
                    minArray = []
                    if(self.prevGID != -10):
                       self.finalSched.append({
                           'gid': self.prevGID,
                           'date': self.prevDate,
                           'sched': prevTemp,
                           'minsAsleep': minsAsleep
                       }) 
                       minsAsleep = 0

                if(x['gid'] == self.prevGID and x['isAwake'] == 'Y'):
                    # print(x['date'], self.prevGID, " ", self.prevMin, " ", x['minute'])
                    for i in range(self.prevMin, x['minute']):
                        temp[i] = '#'
                        minsAsleep += 1
                    prevTemp = temp
                
                self.prevGID = x['gid']
                self.prevMin = x['minute']
                self.prevDate = x['date']
        self.finalSched.append({
                           'gid': self.prevGID,
                           'date': self.prevDate,
                           'sched': temp,
                           'minsAsleep': minsAsleep
                       }) 
        
    def findSleepingMost(self):
        minSleep = Counter()
        mostCommonMin = Counter()
        minutesAsleep = []
        for guard in self.finalSched:
            minSleep[guard['gid']] += guard['minsAsleep']
        
        max = sorted(minSleep.items(), key=operator.itemgetter(1), reverse=True)
        guardMostSleepy = max[0][0]

        for i in self.finalSched:
            if i['gid'] == guardMostSleepy:
                for j in range(len(i['sched'])):
                    if i['sched'][j] == '#':
                        minutesAsleep.append(j)

        minuteSleptMost = Counter(minutesAsleep).most_common(1)[0][0]

        print(guardMostSleepy, " " , int(guardMostSleepy) * minuteSleptMost)

    def findSleepingMostSpecMin(self):
        minSleep = Counter()
        gSet = set()
        mostCommonMin = Counter()
        gMostComMin = -10
        maxOcc = -10
        guard = -10
        gArray = [0 for i in range(10000)]

        for guard in self.finalSched:
            gSet.add(guard['gid'])

        for g in gSet:
            gArray.__setitem__(int(g), [])

        for i in self.finalSched:
            for j in range(len(i['sched'])):
                if i['sched'][j] == '#':
                    gArray[int(i['gid'])].append(j)

        for i in range(len(gArray)):
            if type(gArray[i]) is list:
                tempMax = Counter(gArray[i]).most_common(1)[0][1]
                if tempMax > maxOcc:
                    maxOcc = tempMax
                    guard = i
                    gMostComMin = Counter(gArray[i]).most_common(1)[0][0]


        print("Guard: ", guard, "falls asleep on minute: ", gMostComMin, " this many times: ", maxOcc)
        print("Answer to puzzle is: ", guard * gMostComMin)  
                