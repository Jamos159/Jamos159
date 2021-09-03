# Course: IT1 1120 G
# Assignment number: 4
# Due Date: April 4th, 2020
# Amos, Jared
# Student number: 300068688

########################
# Question 1
########################

def overlap(set1, list1):
    '''takes in a set and a list as an argument and returns a set '''
    
    set2 = set({})
    if len(set1) >= len(list1):
        for i in set1:
            if i in list1:
                set2.add(i)
    else:
        for i in list1:
            if i in set1:
                set2.add(i)
    return set2

########################
# Question 2
########################

def digit_sum(n):
    ''' takes a integer as an argument and returns an integer'''
    stringi = str(n)
    if len(stringi) > 1:
        sum1 = 0
        i = 0
        while i < len(stringi):
            sum1 += int(stringi[i])
            i += 1
        return(sum1)
    else:
        return int(stringi)

def digital_root(n):
    ''' takes a integer as an argument and returns an integer using RECURSION'''
    answer = digit_sum(n)
    list1 = []
    if answer > 10:
        digital_root(answer)
    
    answer = digit_sum(answer)
    answer = digit_sum(answer) 
    return answer
    
        
        
        
