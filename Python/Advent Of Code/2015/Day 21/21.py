import re
from itertools import *
from collections import defaultdict
bHP = 100
bD = 8
bA = 2

weaponsList = [re.sub(r'\s+',' ',i.strip()) for i in open('Weapons.txt').readlines()]
armorList = [re.sub(r'\s+',' ',i.strip()) for i in open('Armor.txt').readlines()]
ringsList = [re.sub(r'\s+',' ',i.strip()) for i in open('Rings.txt').readlines()]

weapons = defaultdict()
armor = defaultdict()
rings = defaultdict()

for wep in weaponsList:
    attr = wep.split()
    weapons[attr[0]] = {
        'cost': int(attr[1]),
        'damage': int(attr[2]),
        'armor': int(attr[3])
    }

for arm in armorList:
    attr = arm.split()
    armor[attr[0]] = {
        'cost': int(attr[1]),
        'damage': int(attr[2]),
        'armor': int(attr[3])
    }

for ring in ringsList:
    attr = ring.split()
    rings[attr[0]+attr[1]] = {
        'cost': int(attr[2]),
        'damage': int(attr[3]),
        'armor': int(attr[4])
    }

p = []
for w, wattr in weapons.items():
    for a, aattr in armor.items():
        for r, rattr in rings.items():
            for r2, rattr2 in rings.items():
                if r != r2:
                    p.append((w,a,r,r2))

# print(p)
m = 0
myHP = 100
cost = 0

for i, pos in enumerate(p):
    # print(pos)
    myWep = weapons[pos[0]]['damage']+rings[pos[2]]['damage']+rings[pos[3]]['damage']
    myArm = armor[pos[1]]['armor']+rings[pos[2]]['armor']+rings[pos[3]]['armor']
    
    if (myWep+myArm) < (bD+bA):
        
        tmp = weapons[pos[0]]['cost']+rings[pos[2]]['cost']+armor[pos[1]]['cost']+rings[pos[3]]['cost']
        if tmp > cost:
            print(myWep, myArm)
            print(pos, tmp)
            cost = tmp

print(cost)