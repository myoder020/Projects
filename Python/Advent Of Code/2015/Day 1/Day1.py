import re

testS = open('1.txt').readline()
up = testS.count('(')
down = testS.count(')')

#part 1 ans
print(up - down)

basement = 0
cnt = 0

#part 2 begin
for i in range(1, len(testS)):
    if testS[i-1] == '(':
        cnt += 1
    else:
        cnt -= 1
    if cnt == -1:
        basement = i
        break;

print(basement)