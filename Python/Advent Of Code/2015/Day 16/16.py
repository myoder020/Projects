import re

src = [i.strip() for i in open('Day16Input.txt').readlines()]
sues = [i.strip() for i in open('Day16.txt').readlines()]

sDict = {}
for line in src:
    line = line.replace(':','')
    iDesc, num = line.split()
    sDict[iDesc] = int(num)

pattern = r'.* (\d+): (\w+): (\d+),\s(\w+): (\d+),\s(\w+): (\d+)'

sueDict = {}
for line in sues:
    sue, cat1, val1, cat2, val2, cat3, val3 = re.search(pattern, line).groups()
    sueDict[sue] = {
        cat1: int(val1),
        cat2: int(val2),
        cat3: int(val3)
    }

results = []

for k,v in sueDict.items():
    match = 0
    for cat, val in v.items():
        if val == sDict[cat]:
            match += 1
    results.append((k,v,match))

print(max(results,key=lambda x:x[2]))

"""
In particular, the cats and trees readings indicates that there are greater than that many 
(due to the unpredictable nuclear decay of cat dander and tree pollen), 
while the pomeranians and goldfish readings indicate that there are fewer 
than that many (due to the modial interaction of magnetoreluctance).
"""

results2 = []
for k,v in sueDict.items():
    match = 0
    for cat, val in v.items():
        if (cat in 'cats' or cat in 'trees') and val > sDict[cat]:
            match += 1
        elif (cat in 'pomeranians' or cat in 'goldfish') and val < sDict[cat]:
            match += 1
        elif val == sDict[cat]:
            match += 1

    results2.append((k,v,match))

# print(max(results2,key=lambda x:x[2]))
for i in results2:
    if i[2] == 3:
        print(i)