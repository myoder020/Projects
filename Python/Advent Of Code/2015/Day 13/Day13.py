from itertools import permutations
from collections import defaultdict
lines = [i.strip().replace('.','') for i in open('Day13v2.txt').readlines()]

pSet = set()
happiness = defaultdict()

for i in lines:
    p1 = i.split()[0]
    num = i.split()[3]
    p2 = i.split()[-1]
    pSet.add(p1)
    if 'gain' in i:
        happiness[(p1,p2)] = int(num)
    else:
        happiness[(p1,p2)] = int('-'+num)

people = list(pSet)
numP = len(people)

print(numP)


possiblePartners = list(permutations(people))
lHappy = []

for i in range(len(possiblePartners)):
    cntHappy = 0
    for j in range(len(possiblePartners[i])):
        if j != len(possiblePartners[i]) - 1:
            cntHappy += happiness[(possiblePartners[i][j],possiblePartners[i][j+1])]
            cntHappy += happiness[(possiblePartners[i][j+1],possiblePartners[i][j])]
        else:
            cntHappy += happiness[(possiblePartners[i][j],possiblePartners[i][0])]
            cntHappy += happiness[(possiblePartners[i][0],possiblePartners[i][j])]
    lHappy.append((cntHappy, possiblePartners[i]))

print(max(lHappy))