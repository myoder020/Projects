import re
import itertools
pattern = r'(\w+).*fly.(\d+).*for.(\d+).*for.(\d+)'
lines = [i.strip() for i in open('Day 14.txt').readlines()]

rDeer = ''
dist = 0
length = 0
rest = 0
allRDeer = []
race = 2503

for i in lines:
    sobj = re.search(pattern,i)
    rDeer, dist, length, rest = sobj.groups()
    allRDeer.append(list((rDeer, dist, length, rest)))

def getDist(rD, raceLength):
    time = 0
    totalDist = 0
    done = False
    while time < raceLength and done == False:
        for i in range(int(rD[2])):
            totalDist += int(rD[1])
            time += 1
            if time == raceLength:
                done = True
                break
        for i in range(int(rD[3])):
            time += 1
            if time == raceLength:
                done = True
                break
    return [rD[0], totalDist]

times = []
# print(allRDeer)
for deer in allRDeer:
    times.append(getDist(deer, race))

# print(times)
# print(allRDeer)

rStats = {}
for i in allRDeer:
    # print(i[3])
    rStats[i[0]] = {
        "speed": int(i[1]),
        "length": int(i[2]),
        "restLength": int(i[3]),
        "ranFor": 0,
        "restFor": 0,
        "distTravelled": 0,
        "points": 0,
        "status": "Flying"
    }


for i in range(1, race+1):
    for k,v in rStats.items():
        if rStats[k]['status'] == 'Flying':
            # print(k, 'is flying')
            rStats[k]['distTravelled'] += rStats[k]['speed']
            rStats[k]['ranFor'] += 1
        
        if rStats[k]['ranFor'] == rStats[k]['length']:
            rStats[k]['ranFor'] = 0
            rStats[k]['status'] = 'Resting'
        elif rStats[k]['status'] == 'Resting':
            rStats[k]['restFor'] += 1

        if rStats[k]['restFor'] == rStats[k]['restLength']:
            rStats[k]['restFor'] = 0
            rStats[k]['status'] = 'Flying'
    winning = max(rStats.items(),key=lambda x:x[1]['distTravelled'])

    for k,v in rStats.items():
        if rStats[k]['distTravelled'] == winning[1]['distTravelled']:
            rStats[k]['points'] += 1
    

print(max(rStats.items(), key = lambda x: x[1]['points']))

# print(rStats)