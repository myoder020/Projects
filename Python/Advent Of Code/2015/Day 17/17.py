from itertools import *
liters = [int(i.strip()) for i in open('Day17.txt').readlines()]

print(liters)
combos = []
for i in range(len(liters)):
    for combo in combinations(liters, i):
        if sum(combo) == 150:
            combos.append(combo)

mLength = len(min(combos,key=lambda x:len(x)))

cnt = 0
for i in combos:
    if len(i) == mLength:
        cnt += 1

print(cnt)