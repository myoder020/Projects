from collections import defaultdict
with open('6.txt') as fh:
    fileContents = [line.strip() for line in fh.readlines()]

start = ()
end = ()
lights = [[0 for i in range(1000)] for i in range(1000)]

#part 1
# for i in fileContents:
#     ins = i.split()
#     if ins[0] == 'turn':
#         start = [int(values) for values in ins[2].split(',')]
#         end = [int(values) for values in ins[4].split(',')]
#         action = ins[1]
#     else:
#         start = [int(values) for values in ins[1].split(',')]
#         end = [int(values) for values in ins[3].split(',')]
#         action = ins[0]
#     for i in range(start[0], end[0]+1):
#         for j in range(start[1], end[1]+1):
#             if action == 'on':
#                 lights[i][j] = 'on'
#             if action == 'off':
#                 lights[i][j] = 'off'
#             if action == 'toggle':
#                 if 'off' in lights[i][j] :
#                     lights[i][j] = 'on'
#                 elif 'on' in lights[i][j]:
#                     lights[i][j] = 'off'

# lightsOn = 0
# for k in lights:
#     for v in k:
#         if v == 'on':
#             lightsOn += 1


# print(lightsOn)

#part 2
for i in fileContents:
    ins = i.split()
    if ins[0] == 'turn':
        start = [int(values) for values in ins[2].split(',')]
        end = [int(values) for values in ins[4].split(',')]
        action = ins[1]
    else:
        start = [int(values) for values in ins[1].split(',')]
        end = [int(values) for values in ins[3].split(',')]
        action = ins[0]
    for i in range(start[0], end[0]+1):
        for j in range(start[1], end[1]+1):
            if action == 'on':
                lights[i][j] += 1
            if action == 'off':
                if lights[i][j] > 0:
                    lights[i][j] -= 1
            if action == 'toggle':
                lights[i][j] += 2

lightBright = 0
for k in lights:
    for v in k:
        lightBright += v

print(lightBright)