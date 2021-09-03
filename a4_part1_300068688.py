# Course: IT1 1120 G
# Assignment number: 4
# Due Date: April 4th, 2020
# Amos, Jared
# Student number: 300068688

########################
# Question a
########################
def largest_34(a):
    '''fuunction takes in one argument that is of type list and returns a integer which is the sum of the
3rd and 4th largest values in the list'''
    a.sort()
    sum_3_4 = a[len(a)-3] + a[len(a)-4]
    return sum_3_4

########################
# Question b
########################

def largest_third(a):
    '''function takes in one argument that is of type list and returns an integer '''
    a.sort()
    maxsum = 0
    sum1 = len(a)//3 
    for ind in range(len(a)-sum1,len(a)):
        maxsum += a[ind]
    return maxsum

########################
# Question c
########################

def third_at_least(a):
    '''function takes in a list has an argument and then returns a integer or none '''
    a.sort()
    counter = 0
    occur = (len(a)//3) + 1
    i = 0
    while i < len(a):
        if i + 1 < len(a) and a[i] == a[i+1]:
            counter += 1
            i += 1
        elif counter >= occur-1:
            return a[i]
        else:
            i += 1
            counter = 0

########################
# Question d
########################

def sum_tri(a,x):
    '''function takes in a list and a integer as an argument and returns True or False, returns True if 'x' can be computed using any 3 values in the list and false otherwise '''
    a.sort()
    if len(a) >= 3:
        for i in range(0, len(a) -2):
            beg = i + 1
            end = len(a)-1
            while(beg<end):
                c1 = a[i] + a[i] + a[i]
                c2 = a[i] + a[i] + a[beg]
                c3 = a[i] + a[beg] + a[beg]
                c4 = a[beg] + a[beg] + a[beg]
                c5 = a[i]  + a[i] + a[end]
                c6 = a[i] + a[end] + a[end]
                c7 = a[end] + a[end] + a[end]
                c8 = a[end] + a[beg] + a[beg]
                c9 = a[end] + a[end] + a[beg]
                if (a[i] + a[beg] + a[end] == x) or (c1 == x) or (c2 == x) or (c3 == x)or (c4 == x) or (c5 == x)or (c6 == x)or (c7 == x)or (c8 == x)or (c9 == x):
                    return True
                elif a[i] + a[beg] + a[end] < x:
                    beg += 1
                else:
                    end -= 1
    else:
        if a[0] + a[0] + a[0] == x or a[0] + a[0] + a[1] == x or a[1] + a[1] + a[0]== x or a[1] + a[1] + a[1] == x:
            return True 
    return False 

