import copy
gridSrc = [i.strip() for i in open('Day18.txt').readlines()]
gridTarget = open('output.txt','w')
gridTarget.close()
numLines = len(gridSrc[0])
grid = {}

gridTarget = open('output.txt','a')
cnt = 0
for i in range(numLines):
    for j in range(numLines):
        grid[(i,j)] = gridSrc[i][j]
        grid[(0,0)] = '#'
        grid[(0,99)] = '#'
        grid[(99,0)] = '#'
        grid[(99,99)] = '#'
        gridTarget.write(grid[(i,j)])
        cnt += 1
        if cnt == numLines:
            gridTarget.write('\n')
            cnt = 0
    
gridTarget.write('\n')

ngrid = copy.deepcopy(grid)

for steps in range(numLines):
    for i in range(numLines):
        for j in range(numLines):
            turnOn = 0

            if (i == 0 and j == 99) or (i == 0 and j == 0) or (i == 99 and j == 99) or (i == 99 and j == 0):
                continue 

            if i > 0: #checking the left neighbor
                if grid[(i-1,j)] == '#':
                    turnOn += 1
            if i < numLines - 1: #checking the right neighbor
                if grid[(i+1,j)] == '#':
                    turnOn += 1
            if j < numLines - 1: #checking the bottom neighbor
                if grid[(i,j+1)] == '#':
                    turnOn += 1
            if j > 0: #checking the top neighbor
                if grid[(i,j-1)] == '#':
                    turnOn += 1
            if i > 0 and j > 0: #checking the top left neighbor
                if grid[(i-1,j-1)] == '#':
                    turnOn += 1
            if (i < numLines - 1) and j > 0: #checking the top right neighbor
                if grid[(i+1,j-1)] == '#':
                    turnOn += 1
            if i > 0 and (j < numLines - 1): #checking the bottom left neighbor
                if grid[(i-1,j+1)] == '#':
                    turnOn += 1
            if (i < numLines - 1) and (j < numLines - 1): #checking the bottom right neighbor
                if grid[(i+1,j+1)] == '#':
                    turnOn += 1
            
            if grid[(i,j)] == '.' and turnOn == 3:
                ngrid[(i,j)] = '#'
            elif grid[(i,j)] == '#' and not (turnOn == 3 or turnOn == 2):
                ngrid[(i,j)] = '.'

        if(i == numLines - 1):
            ngrid[(0,0)] = '#'
            ngrid[(0,99)] = '#'
            ngrid[(99,0)] = '#'
            ngrid[(99,99)] = '#'
            grid = copy.deepcopy(ngrid)
            cnt = 0
            for k,v in ngrid.items():
                gridTarget.write(v)
                cnt += 1
                if cnt == numLines:
                    gridTarget.write('\n')
                    cnt = 0
            gridTarget.write('\n')

gridTarget.close()

print(sum([1 for k,sublist in ngrid.items() for item in sublist if item == '#']))