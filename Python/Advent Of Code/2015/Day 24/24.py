from itertools import permutations
packages = [int(i.strip()) for i in open('24.txt').readlines()]

gSize = sum(packages)/3
poss = []
for i in range(len(packages)):
    if i > 4 and i < len(packages) - 4:
        for perm in permutations(packages,i):
            if sum(perm) == gSize:
                poss.append(perm)
                # print(perm)

print(poss)