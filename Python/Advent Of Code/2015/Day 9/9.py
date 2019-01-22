from collections import defaultdict
from itertools import permutations 
with open('9.txt') as fh:
    fileContents = [line.strip() for line in fh.readlines()]

paths = defaultdict(dict)
cities = set()
traveled = []

for i in fileContents:
    src, a, dest, b, dist = i.split()
    cities.add(src)
    cities.add(dest)    
    paths[src][dest] = int(dist)
    paths[dest][src] = int(dist)

for i in permutations(cities):
    print(list(zip(i, i[1:])))
    traveled.append((sum([paths[src][dest] for src, dest in zip(i, i[1:])]), i))

print(min(traveled))
print(max(traveled))

