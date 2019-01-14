f = open("numsToCalc.txt", "r");
num = 0;
freqList = [];
numList = [];
search = 0;
freqTwice = 0;
for x in f:
    # print(int(x));
    numList.append(int(x));

while search == 0:
    for x in numList:
        num += x;
        # print(num);
        if num == 0:
            freqTwice = 0;
            search = 1;
            print(num, " ", freqTwice, " ", x);
            break;

        if num in freqList:
            freqTwice = num;
            search = 1;
            print(num, " ", freqTwice, " ", x);
            break;

        freqList.append(num);

print("Frequency that appeared twice: ", freqTwice);
# print(freqList);
