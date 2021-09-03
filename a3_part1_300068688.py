# Course: IT1 1120 G
# Assignment number: 3
# Due Date: March 20th, 8:00 pm, 2020
# Amos, Jared
# Student number: 300068688

########################
# Question 1
########################
def coprime(x,y):
    '''Function called coprime that takes two arguments 'x' and 'y' which both must be
positive integers and returns true if x and y are coprimes and returns false
if they are not coprimes'''
    xlist = []
    ylist = []
    if x == 1 or y ==1:
        return True
    i = 0
    counter = 0
    for xdiv in range(1,x):
        if x%xdiv == 0:
            xlist.append(xdiv)
    for ydiv in range(1,y):
        if y%ydiv== 0:
            ylist.append(ydiv)
    if ylist > xlist:
        biglist = ylist
        smalist = xlist
    else:
        biglist = xlist
        smalist = ylist
    for check1 in range(0, len(biglist)):
        while i < len(smalist):
            if smalist[i] == biglist[check1]:
                counter += 1
            i += 1
        i = 0
    if counter == 1 and x%y != 0 and y%x != 0:
        return True
    else:
        return False

########################
# Question 2
########################

def all_coprime_pairs(L):
    '''function called all_coprime_pairs that takes as input a list called 'L' of
postive integers and this function returns a list of tuples containing all pairs of numbers
in the list 'L' that are coprimes and if there are no coprime pairs it returns a empty list
'''
    list1 = []
    tup1 = ()
    empt = ''
    i = 0
    b = 1
    while i < len(L):
        while b < len(L):
            if coprime(L[i],L[b]) == True:
                tup1 = (L[i],L[b])
                list1.append(tup1)
                
            b += 1
        i += 1
        b = i + 1
        
    return list1

########################
# Question 3
########################

def zero_out(a1,a2):
    '''function called zero_out that takes two lists of integers 'a1' and 'a2'and then
replaces any occurences of 'a2' in 'a1' with zeroes the sequence of elements in a2 may appear
anywhere in a1 but must appear consectively and in the same order, the function then returns
then list'''
    n = 0
    b = 0
    for ind in range(0, len(a1)):
        if a1[b:(len(a2)+n)] == a2:
            for test in range(b, (len(a2)+n)):
                a1[test] = 0
        b += 1
        n += 1
    return a1

########################
# Question 4
########################

def coin_flip(file_name):
    '''function called coin flip that takes a argument of the name of a file
then open and reads this file which contains a set of coin flips which are either
'H' or 'T' for each line in the file if heads is greater then 50% than it will print
win and prints outs the amount of heads there were in the line, the percentage of heads
and then 'you win' if heads is greater then 50%'''
    headC = 0
    tailC = 0
    percent = 0
    file_name=file_name.strip()
    list1=open(file_name).read().splitlines()
    for ind in range(0,len(list1)):
        list1[ind] = list1[ind].lower()
        headC = list1[ind].count('h')
        tailC = list1[ind].count('t')
        percent = (headC/(headC+tailC))*100
        percent = round(percent,1)
        if headC > tailC:
            win = 'You win!' + '\n'
        else:
            win = ''
        print(str(headC) + ' heads' + ' ' + '(' + str(percent) +'%' + ')'+ '\n' + win)

########################
# Question 5
########################

def run():
    '''function called run that takes no arguments and this function generates
a sequence of 20 random die tosses in a list and then prints the die values
and includes any runs in the 20 die tosses parentheses'''
    list1 = []
    rand = 0
    i = 0
    list2 = []
    tuplist = []
    import random
    for ind in range(0,20):
        rand = random.randrange(1,7)
        list1.append(rand)
    while i < 19:
        if list1[i] == list1[i+1]:
            while list1[i] == list1[i+1]:
                tuplist.append(list1[i])
                tuplist.append(list1[i+1])
                i += 1
            tuplist = tuple(tuplist)
            list2.append(tuplist)
            tuplist = []
        list2.append(list1[i])
        i += 1
    list2.append(list1[19])
    print(' '.join(str(x) for x in list2))

########################
# Question 6
########################

def craps():
    '''function called craps that takes no arguments and simulates a game of craps
and returns 1 if the player won and 0 if the player lost '''
    import random
    dice1 = random.randint(1,6)
    dice2 = random.randint(1,6)
    inVal = dice1 + dice2
    gamefin = False
    if dice1 + dice2 == 7 or dice1 + dice2 == 11:
        return 1
    elif dice1 + dice2 == 2 or dice1 + dice2 == 3 or dice1 + dice2 == 12:
        return 0
    dice1 = random.randint(1,6)
    dice2 = random.randint(1,6)
    while gamefin == False:
        if dice1 + dice2 == inVal:
            return 1
        elif dice1 + dice2 == 7:
            return 0
        dice1 = random.randint(1,6)
        dice2 = random.randint(1,6)

########################
# Question 7
########################

def testCraps(n):
    '''function called testCraps that takes a postive integer 'n' as a argument
and then simulates 'n' and then returns the fraction of games the player won'''
    i = 0
    wins = 0
    while i < n:
        wins = wins + craps()
        i += 1
    return round(wins/n, 3)

########################
# Question 8
########################

def is_all_even(list1):
    ''' function called is_all_even that takes a list of lists as a paramter and returns
 True if all the integer elements of the lists are even and false if it doesn't '''
    i = 0
    for row in range(0, len(list1)):
        while i < len(list1[row]):
            if list1[row][i]%2 != 0:
                return False
            i += 1
        i = 0

    return True

########################
# Question 9
########################
        
def range1(list1):
    '''function called range1 that takes one parameter which is a list of lists
called 'list1' and it then returns the range of values contained in the list of lists
, the range is the difference between the largest and smallest elements'''
    maxVal = 0
    minVal = min(list1[0])
    for row in range(0, len(list1)):
        if max(list1[row]) > maxVal:
            maxVal = max(list1[row])
        if min(list1[row]) < minVal:
            minVal = min(list1[row])
    return maxVal -  minVal + 1

        
    
    
            
                
        

    
             
        
    
        
            
