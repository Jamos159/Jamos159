# Course: IT1 1120 G
# Assignment number: 2
# Due Date: March 8th, 11:30 pm, 2020
# Amos, Jared
# Student number: 300068688

########################
# Question 1
########################

def print_factors(n):
    '''creates a function called print_factors that takes an integer value 'n' as a
parameter and then prints all the factors of 'n', the function also returns false if
it is divisible by 2 and returns true if it is divisble by 2, this done by using a forloop to
find the factors of 'n' then a while loop to create a string value equal to the factors
to print out'''
    factors = [0]
    factor2 = ''
    for i in range(1,n+1):
        if n%i == 0:
            factors = factors + [i]
    i = 0
    while i < len(factors):
        factor2 = factor2+ str(factors[i]) + ' '
        i += 1
        
    print('Factors of ' + str(n) + ' = ' + factor2 + '\n')
    if n%2 == 0:
        return True
    else:
        return False

########################
# Question 2
########################

def triangle(size):
    
    '''creates a function called triangle with one argument called
'size' whiich must be a integer value that creates a upside down triangle of numbers using
'size' to determine the triangle, 'size' will always be the middle value of each
line in the triangle, the first line of the triangle will range from 1 to (size*2)-1
and every time it goes to a new line it removes 1 number from each end of the line until it is just the value
'size' left'''
    
    sizestr = ''
    sizestart = size
    sizeend = size*2
    i = 1
    s = 0
    e = ' '
    while i <= sizeend :
        sizestr  =  sizestr + str(i)
        i = i +1
        if i == sizeend:
            print(e*s + sizestr[s:sizeend+1], end='\n')
            s = s+1
            sizeend = sizeend - 1
            i  = 1
            sizestr = ''

########################
# Question 3
########################
           
def approxPi(error):
    '''creates a function called approx pi that takes a float value as an argument which is called
'error' and then computes pi as accurate until the current sum of pi - prevoius sum of pi
is equal or less than the error, it then reutns this value of pi called 'CurrentSum' '''
    import math
    error = error*0.0051
    CurrentSum = 4.0
    PrevSum = 0
    n = 3.0
    p = 1.0
    while abs(CurrentSum - PrevSum) > error:
        CurrentSum = CurrentSum - 4/n + 4/(n+2)
        n = n + 4
        PrevSum = PrevSum - 4/p + 4/(p+2)
        if n == 11:
            p = 3
            PrevSum = 4 - 4/3 + 4/5
        
        p = p+4
        
    if abs(CurrentSum - PrevSum) < error:
        return print(CurrentSum)

########################
# Question 4
########################
        
def longest_name(n):
    '''creates a fucntion called longest name that takes a argument of type int called 'n'
and then will ask the user to input 'n' number of names, this function will then determine which name
is the longest and return and print the longest name, it also lets the user know if there was a tie for
longest name, if there is a tie the function will return and print the first longest name in the order
the user inputted it as and  indicate if there was atie underneath the printed statment '''
    print('Enter Number of names: ' + str(n))
    i = 1
    longname = ''
    name = ''
    list1 = []
    b = 0
    counter = 0
    
    while i <= n:
        name = name + str(i)
        name = input('Enter Name #' + str(i) + ': ')
        list1.append(name)
        name = ''
        i = i + 1
        longname = list1[0]
        
    while b < n:
        if len(longname) < len(list1[b]):
            longname = str(list1[b])
            b = 0
            i = 0
        b = b+1
        i = 0
        
    while i < n:
        tie = str(list1[i])
        if len(longname) == len(tie):
            counter = counter + 1
        if counter == 1:
            longname = longname + '\n' + '(There was a Tie!)'
            counter = counter + 1
        i = i + 1
        longname = longname.lower()
        longname = longname.capitalize()
    
        
    return print('The longest name is ' + longname)

########################
# Question 5
########################

def is_fib(list1):
    '''creates a function called is_fib that takes a argument of type list called 'list1'
it then if statments and while loops to determine if the list follows the fibnocci sequence
which is when the two previous numbers add up to the current number, it will then return true if it does follow the
fibnocci sequence and return false if it does not'''
    i = 0
    i2 = 0
    a = True
    max1 = max(list1) 
    length = len(list1)
    if max1 != list1[length-1]:
        return False
    if length < 3:
        return True 
    
    if length >= 3:
        while i < length-2:
            if list1[i] + list1[i+1] == list1[i+2]:
                a = True
            else:
                return False
            i += 1

    return a

########################
# Question 6
########################
def GCD(a,b):
    '''creates a function called GCD that takes two parameters of type int called 'a' and 'b'
the function then calculates and returns the greatest common denominator of the two integer values
of 'a' and 'b' this is done by if statments and while loops to determine the greatest common denominator'''
    i = 1
    if a == 0 or b == 0:
        return abs(a) + abs(b)
    if a>b:
        rem = a%b
        smal = b
        big = a
    else:
        rem = b%a
        smal = a
        big = b
    if rem == 0 and smal == b:
        return b
    elif rem == 0 and smal == a:
        return a
    gcd = a
    while i < b:
        gcd = smal%rem
        if gcd == 0:
            gcd = rem
            b = 0
        smal = rem
        rem = gcd
    return gcd

########################
# Question 8
########################

def encrypt_string():
    '''creates a function called encrypt_string that takes no arguments, this function will then have the user input the password
and see if it meets the requirements of being between 8-16 letters, 1 capital letter, 1 number and 1 special character
the function will then encrypt the string and return the ecrypted string, if the password does not meet the requirements the
function will then tell the user to try again and that their password does not meet the requirements, the function
encrypts the string using the 'ord' and 'chr' functions'''
    x = str(input('Enter your password:'))
    passlist = []
    i = 0
    lcl = 0
    ccl = 0
    num =0
    spec = 0
    metReq = False
    encStr = ''
    while i  < len(x):
        passlist.append(str(x[i]))
        i += 1
    if len(passlist) > 16 or len(passlist) < 8:
        return print('Try again, your password does not meet all requirements.')
    if '@' in passlist or '#' in passlist or '$' in passlist or '%' in passlist:
        spec = 1
    else:
        return print('Try again, your password does not meet all requirements.')
    i = 0
    while i < len(passlist):
        if ord(passlist[i]) > 64 and ord(passlist[i]) < 91:
            ccl += 1
        if ord(passlist[i]) > 47 and ord(passlist[i]) < 57:
            num += 1
        if ord(passlist[i]) > 96 and ord(passlist[i]) < 123:
            lcl += 1
        i += 1
    if ccl >= 1 and lcl >=1 and num >= 1:
        metReq = True
    else:
        return print('Try again, your password does not meet all requirements.')
    if metReq == True:
        i = 0
        while i < len(passlist):
            passlist[i] = chr(ord(passlist[i]) + 5)
            encStr += str(passlist[i])
            i += 1
        return encStr

########################
# Question 7
########################
        
def test_password():
    '''creates a function called test password that doesnt take any arguments to run, the function will then
have the user input their password and checks whether that password meets the requirements of being 8-16 characters long,
have 1 number, have 1 upper case letter and 1 special character, if the password meets all these requirements it will return a message
saying that the password meets requirements and if doesnt meet the requirements it returns a message saying it does not meet the requirements
'''
    x = str(input('Enter your password:'))
    passlist = []
    i = 0
    lcl = 0
    ccl = 0
    num =0
    spec = 0
    while i  < len(x):
        passlist.append(x[i])
        i += 1
    if len(passlist) > 16 or len(passlist) < 8:
        return print('Try again, your password does not meet all requirements.')
    if '@' in passlist or '#' in passlist or '$' in passlist or '%' in passlist:
        spec = 1
    else:
        return print('Try again, your password does not meet all requirements.')
    i = 0
    while i < len(passlist):
        if ord(passlist[i]) > 64 and ord(passlist[i]) < 91:
            ccl += 1
        if ord(passlist[i]) > 47 and ord(passlist[i]) < 57:
            num += 1
        if ord(passlist[i]) > 96 and ord(passlist[i]) < 123:
            lcl += 1
        i += 1
    if ccl >= 1 and lcl >=1 and num >= 1:
        return print('Great, your password meets all requirements')
    else:
        return print('Try again, your password does not meet all requirements.')

########################
# Question 9
########################

def decrypt_string():
    '''creates a function called decrpyt_string that doesn't take any arguments to run, the function will then ask the user to
input their password and will then decrypt that password to be what it was before it got encrypted and then return that password
this done by using the 'ord' and 'chr' function and while looops'''
    x = str(input('Enter your password:'))
    passlist = []
    dencStr = ''
    i = 0
    while i  < len(x):
        passlist.append(str(x[i]))
        i += 1
        
    i = 0
    while i < len(passlist):
            passlist[i] = chr(ord(passlist[i]) - 5)
            dencStr += str(passlist[i])
            i += 1
    return dencStr

    
    
        


            
        
            
     
        

            
        
        
            


