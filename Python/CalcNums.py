f = open("numsToCalc.txt", "r");
num = 0;
for x in f:
    num += int(x);

print(num);