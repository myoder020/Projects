if __name__ == "__main__":
    from collections import defaultdict
    instructs = [(i.strip()).split() for i in open('Ins.txt').readlines()]
    pos = 0
    r = defaultdict(int)

    while True:
        if instructs[pos][0] != 'jmp':
            reg = instructs[pos][1].replace(',','')
        # print(instructs[pos])
        offset = 0        
        if len(instructs[pos]) > 2:
            if instructs[pos][0] == 'jie' and r[reg] % 2 == 0:
                offset = int(instructs[pos][2])
            elif instructs[pos][0] == 'jio' and r[reg] == 1:
                offset = int(instructs[pos][2])
        elif instructs[pos][0] == 'jmp':
            offset = int(instructs[pos][1])
        elif instructs[pos][0] == 'inc':
            r[reg] += 1
        elif instructs[pos][0] == 'tpl':
            r[reg] *= 3
        elif instructs[pos][0] == 'hlf':
            r[reg] = int(r[reg]/2)
        
        if offset == 0:
            pos += 1
        else:
            pos += offset
        
        if pos > len(instructs) - 1:
            break
        # print(reg, r[reg])

    print(r['b']) 

    #part 2
    r['a'] = 1
    r['b'] = 0
    pos = 0
    while True:
        if instructs[pos][0] != 'jmp':
            reg = instructs[pos][1].replace(',','')
        # print(instructs[pos])
        offset = 0        
        if len(instructs[pos]) > 2:
            if instructs[pos][0] == 'jie' and r[reg] % 2 == 0:
                offset = int(instructs[pos][2])
            elif instructs[pos][0] == 'jio' and r[reg] == 1:
                offset = int(instructs[pos][2])
        elif instructs[pos][0] == 'jmp':
            offset = int(instructs[pos][1])
        elif instructs[pos][0] == 'inc':
            r[reg] += 1
        elif instructs[pos][0] == 'tpl':
            r[reg] *= 3
        elif instructs[pos][0] == 'hlf':
            r[reg] = int(r[reg]/2)
        
        if offset == 0:
            pos += 1
        else:
            pos += offset
        
        if pos > len(instructs) - 1:
            break
        # print(reg, r[reg])

    print(r['b']) 
        