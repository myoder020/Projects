fileContents = open("3.txt").readline()
board = [[0 for i in range(100)] for i in range(100)]
sBoard = [[0 for i in range(100)] for i in range(100)]
cnt = 1
santa = 1
roboSanta = 0
santaX = 0
santaY = 0
roboX = 0
roboY = 0
x = 0
y = 0
board[0][0] = 'x'
sBoard[0][0] = 'x'
santaTurn = True
roboTurn = False

def move(pos, b, c, x, y):
    # print(pos, b, c, x, y)
    if pos == '^':
        y += 1
        loc = (x,y)
        if b[x][y] != 'x':
            b[x][y] = 'x'
            c += 1

    if pos == 'v':
        y += -1
        loc = (x,y)
        if b[x][y] != 'x':
            b[x][y] = 'x'
            c += 1
            
    if pos == '>':
        x += 1
        loc = (x,y)
        if b[x][y] != 'x':
            b[x][y] = 'x'
            c += 1
            
    if pos == '<':
        x += -1
        loc = (x,y)
        if b[x][y] != 'x':
            b[x][y] = 'x'
            c += 1

    # print(pos, b, c, x, y)
    return b, c, x, y

for pos in fileContents:
    if santaTurn:
        sBoard, santa, santaX, santaY = move(pos, sBoard, santa, santaX, santaY)
        santaTurn = False
        roboTurn = True

    else:
        sBoard, roboSanta, roboX, roboY = move(pos, sBoard, roboSanta, roboX, roboY)
        santaTurn = True
        roboTurn = False

    board, cnt, x, y = move(pos, board, cnt, x, y)
    # print()

print(cnt)
print(santa)
print(roboSanta)
print(santa+roboSanta)