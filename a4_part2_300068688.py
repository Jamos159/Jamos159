# Course: IT1 1120 G
# Assignment number: 4
# Due Date: April 4th, 2020
# Amos, Jared
# Student number: 300068688

import math

########################
# Question 1
########################

class Rectangle:
    '''creates a Class rectangle that has 4 arguments all of type of int and 'w' and 'h'
must be postive numbers'''
    def __init__(self,x,y,w,h):
        '''function that automatically runs when a new instance of the class is created '''
        self.x = x
        self.y = y
        try:
            test = math.sqrt(w) + math.sqrt(h)
            self.w = w
            self.h = h
        except ValueError:
            raise ValueError('width and height must both be postive numbers')

    def height(self):
        '''takes in the instance being called as an argument and returns a int '''
        return self.h

    def width(self):
        '''takes in the instance being called as an argument and returns a int '''
        return self.w

    def X(self):
        '''takes in the instance being called as an argument and returns a int '''
        return self.x

    def Y(self):
        '''takes in the instance being called as an argument and returns a int '''
        return self.y

    def __str__(self):
        '''takes in the instance being called as an argument and returns a string '''
        return 'Rectangle[x={},y={},width={},height={}]'.format(self.x,self.y,self.w,self.h)
    

########################
# Question 2
########################

    def contains(self,x,y):
        '''takes in the instance being called as an argument and two integer values
and returns True or False'''
        righlen = self.x  + self.w
        height1 =  self.y - self.h
        if ((x >= self.x and x <= righlen) and  (y <=  self.y and y >= height1)):
            return True
        else:
            return False


########################
# Question 3
########################

    def union(self,rect):
        '''takes in the instance being called as an argument and another instance of
 the class rectangle and returns a new instance of class rectangle '''
        if self.x < rect.x:
            x = self.x
        else:
            x = rect.x
        if self.y > rect.y:
            y = self.y
        else:
            y = rect.y
        if self.x + self.w > rect.x + rect.w:
            w = abs((self.x + self.w) - x)
        else:
            w = abs((rect.x + rect.w) - x)

        if self.y - self.h < rect.y - rect.h:
            h = abs(y -  (self.y -self.h))
        else:
            h = abs(y - (rect.y - rect.h)) 

        return Rectangle(x,y,w,h).__str__()


########################
# Question 4
########################

    def intersection(self,rect):
        '''takes in the instance being called as an argument and another instance of
 the class rectangle and returns a new instance of class rectangle '''
        bot1right = (self.x + self.w, self.y - self.h)
        bot2right = (rect.x + rect.w, rect.y - rect.h)

        x1 = max(self.x,rect.x)
        y1 = min(self.y, rect.y)
        
        x2 = min(bot1right[0],bot2right[0])
        y2 = max(bot1right[1],bot2right[1])

        if ( x1 > x2 or y2 > y1):
            w = 0
            h = 0
            return Rectangle(0,0,w,h).__str__()

        x = x1
        y = y1
        w = abs(x1 - x2)
        h = abs(y1 - y2)

        return  Rectangle(x,y,w,h).__str__()


########################
# Question 5
########################

    def __eq__(self,rect):
        '''takes in the instance being called as an argument and another instance of
 the class rectangle and returns a boolean '''
        if self.x == rect.x and self.y == rect.y and self.w == rect.w and self.h == rect.h:
            return True
        else:
            return False
        
        
                    

        
            

        
        
        
            
            
        
            
