from collections import defaultdict
from Tree import Tree
import operator

sW = defaultdict((str))
data = [[s for s in line.split()] for line in open("Day7Test.txt")]

for i in data:
    sW[i[1]] += i[7] + " "

print(sW)

def getKey(item):
    return item[1]

sList = sorted(sW.items(), key=getKey)

s = set()
# t = Tree()

def checkForNode(r):
    for k,v in s:
        if(k == r):
            return v
        else:
            return None

l = []

for r, n in sList:
    eN = checkForNode(r)
    if eN is None:
        newN = Tree(r)
        s.add((r,newN))
        childNodes = [ch.strip() for ch in n.split()] 
        for childNode in childNodes:
            chE = checkForNode(childNode)
            if chE is None:
                nCN = Tree(childNode)
                s.add((childNode, nCN))
                newN.setChild(nCN)
            else:
                newN.setChild(chE)
        l.append(newN)

print(Tree(l))
# str('hello').s
