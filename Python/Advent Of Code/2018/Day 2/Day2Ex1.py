fileList = open("Day2List.txt");
numTwoOcc = 0;
numThreeOcc = 0;
for x in fileList:
    foundOccTwo = 0;
    foundOccThree = 0;
    for char in x:
        if x.count(char) == 2 and foundOccTwo == 0:
            # print(char, " has occurrence of 2 in string ", x);
            foundOccTwo = 1;
        
        if x.count(char) == 3 and foundOccThree == 0:
            # print(char, " has occurrence of 3 in string ", x);
            foundOccThree = 1;

    if foundOccTwo == 1:
        numTwoOcc = numTwoOcc + 1;
    if foundOccThree == 1:
        numThreeOcc = numThreeOcc + 1;

fileList.close();

print("Number of boxes with at least one char occuring twice in the same string: ", numTwoOcc);
print("Number of boxes with at least one char occuring three times in the same string: ", numThreeOcc);
print("Checksum is equal to: ", numTwoOcc*numThreeOcc);
