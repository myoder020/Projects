fh = open("Day2List.txt");
numOfMm = 0;
OrigS = "";
CompS = "";
indexOfMM = 0;
MMOccAt = 0;
fileList = [];

for x in fh:
    fileList.append(x);


for x in fileList:
    for y in fileList:
        # print(x, " ", y);
        for i in range(0, len(y) - 1):
            if y[i] != x[i]:
                numOfMm = numOfMm + 1;
                MMOccAt = i;
        # print(numOfMm);
        if numOfMm == 1:
            OrigS = x;
            CompS = y;
            indexOfMM = MMOccAt;
        numOfMm = 0;


print(OrigS, " ", CompS, " ", indexOfMM);
print(OrigS[:15] + OrigS[16:]);
fh.close();