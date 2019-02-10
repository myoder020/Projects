from itertools import *
from collections import defaultdict
import numpy as np

numPresents = 34000000
# houses = np.zeros(numPresents,dtype=float)
npresents = np.full(numPresents,10)
npresents2 = np.full(numPresents,10)
divisors = []
cnt = 1
done = False
uB = 1000000

# for i in range(1, numPresents):
#     for visited in range(i, uB, i):
#         houses[visited] += i * 10

#     if houses[i] >= numPresents:
#         print(i, houses[i])
#         done = True
#         break 

# houses2 = np.zeros(numPresents,dtype=int)
# for i in range(1, numPresents):
#     cnt = 0
#     visited = 0
#     while cnt < 50:
#         visited += i
#         houses2[visited] += i * 11
#         cnt += 1

#     if houses2[i] >= numPresents:
#         print(i, houses2[i])
#         break 

for i in range(2, int(numPresents/10)):    
    npresents[i::i] += 10 * i
    if npresents[i] > numPresents:
        print(i, npresents[i])
        break

for i in range(2, int(numPresents/10)):    
    npresents2[i:(50*i)+1:i] += 11 * i
    if npresents2[i] > numPresents:
        print(i, npresents2[i])
        break
# print(npresents[1])
