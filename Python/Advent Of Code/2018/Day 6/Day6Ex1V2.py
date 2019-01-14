from collections import defaultdict
coords = []

for coor in open("Day6Test.txt"):
    x,y = [int(c.strip()) for c in coor.split(', ')]
    coords.append((x,y))

data = [map(int, i.split(', ')) for i in open('Day6Test.txt').readlines()]

for i in data:
    print(list(i))

def d(p1, p2):
    x1,y1 = p1
    x2,y2 = p2
    return abs(x1-x2) + abs(y1-y2)

def closest(x,y):
    ds = [(d(p, (x,y)), p) for p in coords]
    ds.sort()
    if ds[0][0] < ds[1][0]:
        return ds[0][1]
    else:
        return (-1,-1)

