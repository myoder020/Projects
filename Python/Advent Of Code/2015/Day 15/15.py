import re
from itertools import *
lines = [i.strip() for i in open('Day15.txt').readlines()]
ingredients = {}
pattern = r'(\w+): \w+\s([-|\d]+),\s\w+\s([-|\d]+),\s\w+\s([-|\d]+),\s\w+\s([-|\d]+),\s\w+\s([-|\d]+)'

for line in lines:
    sobj = re.search(pattern, line)
    ingredients[sobj[1]] = {
        'capacity': int(sobj[2]),
        'durability': int(sobj[3]),
        'flavor': int(sobj[4]),
        'texture': int(sobj[5]),
        'calories': int(sobj[6])
    }


def calc(l, nums):
    totalCap = 0
    totalDur = 0
    totalFlav = 0
    totalTex = 0
    totalCal = 0

    for i in range(len(nums)):
        totalCap += nums[i]*l[i]['capacity']
        totalDur += nums[i]*l[i]['durability']
        totalFlav += nums[i]*l[i]['flavor']
        totalTex += nums[i]*l[i]['texture']
        totalCal += nums[i]*l[i]['calories']

    totalCap = totalCap if totalCap > 0 else 0
    totalDur = totalDur if totalDur > 0 else 0
    totalFlav = totalFlav if totalFlav > 0 else 0
    totalTex = totalTex if totalTex > 0 else 0

    if totalCal == 500:
        return ((totalCap * totalDur * totalFlav * totalTex), nums)

    return ()

numI = len(ingredients)
oper = []
sums = []

for combo in combinations_with_replacement(range(101), numI):
    if sum(combo) == 100:    
        for k,v in ingredients.items():
            oper.append(v)

        for perm in permutations(combo):
            sums.append(calc(oper, perm))

        oper.clear()

print(max(sums))

