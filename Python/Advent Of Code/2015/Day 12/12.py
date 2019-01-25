import re
from json import loads
pattern = r'(-[0-9]+|[0-9]+)'
line = open('12.txt').readline()

sobj = re.findall(pattern, line)
print(sum(int(num) for num in sobj))

l = loads(line)
# print(l[0])

def Flatten(j):
    if type(j) == int:
        return j
    if type(j) == list:
        return sum([Flatten(j) for j in j])
    if type(j) != dict:
        return 0
    if 'red' in j.values():
        return 0
    return Flatten(list(j.values()))

print(Flatten(l))

# for i in l:
#     print(i)