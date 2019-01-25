import re
line = open('10.txt').readline()
for num in range(50):
    cnt = 1
    nstr = ''
    for i in range(1,len(line)):
        
        if line[i-1] == line[i]:
            cnt += 1
        else:
            nstr += str(cnt) + line[i-1]
            cnt = 1

        if i == len(line)-1:
            nstr += str(cnt) + line[i]
    line = nstr
    # print(nstr, num)    

# print(line)
print(len(nstr))


