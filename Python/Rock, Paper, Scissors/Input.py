import random
from collections import defaultdict
acceptable = ['r','s','p']
lkp = defaultdict()
decision = defaultdict()
lkp['s'] = 'Scissors'
lkp['r'] = 'Rock'
lkp['p'] = 'Paper'
decision[('r','s')] = 'Rock beats Scissors'
decision[('p','r')] = 'Paper beats Rock'
decision[('s','p')] = 'Scissors beat paper'
tie = False

while True:
    player = input("rock (r), paper (p), or scissors (s)? ")
    if player in acceptable:
        print(player)
        break
    else:
        print('That was not an acceptable choice, Please enter r, p, or s')
        
computer = random.choice(['r','s','p'])
print(lkp[player], 'vs', lkp[computer])

if player == computer:
    print("It's a tie")
    tie = True

result = None

if tie == False:
    try:
        result = decision[(player, computer)]
    except KeyError:
        result = decision[(computer, player)]
    
print(result)

        
    

    



#r b s
#s b p
#p b r