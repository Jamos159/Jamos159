#Family name:  Jared Amos 
# Student number:  300068688
# Course: IT1 1120G
# Assignment Number 1

########################
# Question 1
########################
''' creates a function called repeat that takes 3 arguments, the fist argument is a string type and
 and the second is a integer value 'n' and the third value is a string called 'delim' this function will
 take the string add delim to the end of the string and repeat that 'n' amount times '''
def repeat(string, n, delim):
    yoda = (string+delim)*n # creates a string 'yoda' and sets it equal to string+delim and repeats 'n' times
    print(str(yoda)) #prints 'yoda' 

########################
# Question 2
########################
''' creates a function called is_prime that takes one argument and check to see whether it is prime
 or not, if it is a prime the function return true if not it returns else'''
def is_prime(n):
    if n >= 2: # prime numbers are numbers that cant be divided unless its by 1 or it self so 'n' cannot be 1 or 2
        for i in range(2, n): #creates a for loop that starts at 2 and ends at 'n'
            if (n%i == 0): #checks to see whether n divides into i intergerally
                return n<0 #if it does return false becuase n is not a prime number then
                
        else:
            return n>0 #returns true because n is a prime
        
########################
# Question 3
########################
''' Creates a function points that takes 4 arguments which make up to coordinates x1,y1 x2,y2
 this function then computes the slope of the the line of these points and the distance between them
  and outputs a message a message'''

def points(x1,y1,x2,y2):
    distance = (((x2-x1)**2)+((y2-y1)**2))**(1/2) # finds the distance between these points by finding the hypotenuse of the triangle a^2 + b^2 = c^2
    if (x2-x1)!= 0 and (y2-y1)!=0: #checks to see if the slope is not 0 and if it is print a special message
        
        slope = (y2-y1)/(x2-x1) #computes slope
        print("The slope is " + str(slope) + " and the distance is " + str(distance)) #prints out slope and distance
    else:
        print("the slope is infinity and the distance is " + str(distance))# slope is infinity so it outprints just the distance 
    
########################
# Question 5
########################
''' creates a function reverse_int that takes one argument that is a integer and reverses
 this integer'''
def reverse_int(num):
    reverse1 = num%10 # gets you the number of the begining of the reversed integer
    reverse2 = (num%100)-reverse1 # gets you the number of the second number in the reversed inetger
    reverse1 = reverse1*100 # makes the number at the end now the begining 
    reverse3 = num//100 #gives you last number in the reversed integer 
    final = reverse1 + reverse2 + reverse3 # adds all the numbers together to get you the reversed int
    return final #function returns the reversed int
########################
# Question 6
########################
''' creates a function vowelCount that takes one argument which is a string
 and then prints out the number of vowels and what vowels are in the word'''
def vowelCount(string):
    print('a, e, i, o, and u appear, respectively, ' + str(string.count('a'))+ ', ' + str(string.count('e'))+ ', ' + str(string.count('i')) + ', ' + str(string.count('o')) + ', ' + str(string.count('u'))+ ' times')

########################
# Question 7
######################## 
''' creayes a function with 3 input paramteres that are strings and checks to see if all the same
 then returns true if they are and false if they are not'''
def allthesame(x,y,z):
    if x==y and x==z and z==y: #if statment that checks whther they are all the sale
        return x==y
    else:
        return 1<0
''' creates a function alldifferent that has 3 input paramteres that are all strings
and checks whether all the strings are different and returns true if they are and false
if they are not'''
def alldifferent(x,y,z):
    if x != y and y != z and x != z: #checks to see whether the strings x, y and z are all different
        return x!=y
    else:
        return 1<0
''' creates a function called sorted that takes 3 input paramteres and checks to see whether
 they are in sorted order and returns true if they are and false if they are not'''
def sorted(x,y,z):
    if z>y and z>x and y>x: #checks whther they are sorted
        return z>y
    else:
        return 1<0
    
########################
# Question 8
########################
''' creates a function called leap that takes on input value that is an integer
, this function then computes whether that number was a leap year and
returns true if it was and false if it isnt'''
def leap(year):
    if year%4==0 and year%100 != 0 or year%400==0: #checks whether the year was a leap year
        return year>0
    else:
        return year<0

########################
# Question 9
########################
''' creates a function called letter2number tthat takes a string input  that is a letter grade and converts them
 to a number grade'''
def letter2number(letter):
    if letter== 'A' or'A-' or 'A+': #checks to see if it was an A, A+ or A-
        if letter == 'A': #assigns the corresponding number value to the letter and prints it 
            print(str(4))
        elif letter == 'A+':
            print(str(4+0.3))
        elif letter== 'A-':
            print(str(4-0.3))
    if letter == 'B' or 'B-' or 'B+': #checks to see if it was an B, B+ or B-
        if letter == 'B': #assigns the corresponding number value to the letter and prints it
            print(str(3.0))
        elif letter == 'B+':
            print(str(3+0.3))
        elif letter == 'B-':
            print(str(3-0.3))
    if letter == 'C' or 'C-' or 'C+': #checks to see if it was an C, C+ or C-
        if letter== 'C': #assigns the corresponding number value to the letter and prints it
            print(str(2.0))
        elif letter== 'C+':
            print(str(2+0.3))
        elif letter== 'C-':
            print(str(2-0.3))
    if letter == 'D' or 'D-' or 'D+': #checks to see if it was an D, D+ or D-
        if letter == 'D': #assigns the corresponding number value to the letter and prints it
            print(str(1))
        elif letter=='D+':
            print(str(1+0.3))
        elif letter=='D-':
            print(str(1-0.3))
    if letter == 'F':
        print(str(0))

########################
# Question 10
########################
''' creates a function called is_Palindrome that takes one input that is a string
and determines if that string is the exact same when reversed and returns true if it is
and false if it is not '''
def is_Palindrome(string):
    reverse = string[::-1] #reverses the string 
    if reverse == string:
        return reverse == string
    else:
        return reverse == string

########################
# Question 12
########################
''' creates a function called rps that is a game of rock, paper, scissors and takes two input paramteres that are strings
 that are either 'S' 'P' 'R' and returns a -1 if player 1 wins and a 1 if player two wins and a zero if its a tie'''
def rps(player1, player2): 
    if player1 == 'R' and player2 == 'S' or player1 == 'P' and player2 == 'R' or player1 == 'S' and player2 == 'P':
        return -1
    elif player2 == 'R' and player1 == 'S' or player2 == 'P' and player1 == 'R' or player2 == 'S' and player1 == 'P':
        return 1
    else:
        return 0

########################
# Question 14
########################
''' creates a function called count_even_digits that takes two arguments and returns the amount of even numbers in the first
paramater and the second paramtere is the amount of digits in the first one '''
def count_even_digits(int1, int2):
    even = str(int1)
    even = int(even.count('0')) + int(even.count('2')) + int(even.count('4')) + int(even.count('6')) + int(even.count('8')) #uses the count operator to see the amount of even numbers
    print(str(even))

########################
# Question 13
########################
''' creates a function called alogical that takes one parameter n which must be a integer and counts how many times that integer must be
divided by 2 to be less than or equal to 1 '''
def alogical(n):
    counter = 0
    while n > 1 or n==1: # while loop is used to count the amount of times needed to divide by 2 
        n = n/2
        counter = counter + 1
    print(str(counter))

########################
# Question 11
########################
''' creates a function called is_nneg_float that takes one argument which is a integer and checks to see whether this integer
 is a non negetive float and does this by checking if its more than a digit and has a decimal and returns true if it is a
 non negative float and returns flalse if it is not '''
def is_nneg_float(s):
    if s.count('.')==1 and s.count('e')==0 or len(s)>=1 and s.count('e')==0: #checks to see that it is a float or has atleast more than one digit
        if float(s)>0:
            return float(s)>0
        else:
            return float(s)>0
    else:
        return 0>1

########################
# Question 4
########################
''' creates a function called month_apart that takes 4 arguments and which are integers then checks to see whether these dates
 are are atleast a month apart and returns true if they are and false if they are not '''

def month_apart(m1,d1,m2,d2):
    if m1==m2: #cannot be a month apart apart if they share the same month
        return m1 != m2
    if abs(m1-m2)>1: # checks to see if the dates have diffrence of more than 1 month than they are for sure a month apart
        return m1>0
    if m1>m2: # checks to see whether they are a month apart with respect to the days of each date 
        return (d1-d2) >= 0
    else:
        return (d2-d1) >= 0
    
    
    

    
    
    
        
    
        
        
        
        

    
    
    
        
            

    
