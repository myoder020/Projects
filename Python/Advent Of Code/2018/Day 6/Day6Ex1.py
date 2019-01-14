from collections import defaultdict
with open("Day6Test.txt") as fh:
    fileContents = fh.readlines()

coords = defaultdict()
board = [[-1] * 15 for i in range(15)]


for i in range(len(fileContents)):
    c = fileContents[i].split(',')
    x, y = int(c[0].strip()), int(c[1].strip())
    coords[i] = (x, y)

# print(board[7][14])

for i in range(len(coords)):
    for j in range(len(coords)):
        x1, y1 = coords[i][0], coords[i][1]
        x2, y2 = coords[j][0], coords[j][1]
        # print(x1, y1)
        board[x1][y1] = i
        result = abs(y2-y1)+abs(x2-x1)
        if result != 0: #if 0 then comparing the same coordinates
            # print("starting at coordinate:", i, "ending at coordinate:", j, result)
            pass

for i in range(len(board)):
    for j in range(len(board)):
        print(f'{board[i][j]:5}', end=' ')
    print()