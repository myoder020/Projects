from collections import defaultdict
import functools

with open('7.txt') as fh:
    fileContents = [line.strip() for line in fh.readlines()]

wires = defaultdict(str)
results = dict()

ignore = ['OR','AND','LSHIFT','RSHIFT','NOT']

for line in fileContents:
    ls, rs = line.split('->')
    wires[rs.strip()] = ls.strip().split()

@functools.lru_cache()
def calculate(name):
    try:
        return int(name)
    except ValueError:
        pass

    if name not in results:
        ops = wires[name]
        if len(ops) == 1:
            res = calculate(ops[0])
        else:
            op = ops[-2]
            if op == 'AND':
              res = calculate(ops[0]) & calculate(ops[2])
            elif op == 'OR':
              res = calculate(ops[0]) | calculate(ops[2])
            elif op == 'NOT':
              res = ~calculate(ops[1]) & 0xffff
            elif op == 'RSHIFT':
              res = calculate(ops[0]) >> calculate(ops[2])
            elif op == 'LSHIFT':
              res = calculate(ops[0]) << calculate(ops[2])
        results[name] = res
    return results[name]

print("Part 1", "a: ", calculate('a'))
print(calculate.cache_info())
calculate.cache_clear()
print(results)


results = {}
results['b'] = 956
print("Part 2", "a: ", calculate('a'))
print(results)

# 123 -> x
# 456 -> y
# x AND y -> d
# x OR y -> e
# x LSHIFT 2 -> f
# y RSHIFT 2 -> g
# NOT x -> h
# NOT y -> i