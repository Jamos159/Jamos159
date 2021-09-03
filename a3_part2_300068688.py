# Course: IT1 1120 G
# Assignment number: 3
# Due Date: March 20th, 8:00 pm, 2020
# Amos, Jared
# Student number: 300068688

########################
# Question 1
########################
def CoupColl():
    '''function called coupColl that doesnt take any arguments the function will then
then simulate randomley picking cards from a deck of 52 cards and then will tell the
user the number of picks needed to get four cards, one from each suit and then will
display the four cards that were picked of each suit'''
    import random 

    Hearts = []
    Spades = []
    Diamonds = []
    Clubs = []
    picklist = []
    Facecard = ['Jack', 'Queen', 'King', 'Ace']

    for ind in range(1,14):
        Hearts.append(ind)
        Spades.append(ind)
        Diamonds.append(ind)
        Clubs.append(ind)

    deck = [Hearts,Spades,Diamonds,Clubs]

    Hpick = False
    Spick = False
    Cpick = False
    Dpick = False
    counter = 0

    while Hpick == False or Spick == False or Dpick == False or Cpick == False:
        i = random.randint(0,3)
        j = random.randint(0,12)
        counter += 1
        if Hpick == False and i == 0:
            Hpick = True
            if j >= 9:
                i = random.randint(0,3)
                picklist.append((Facecard[i] + ' of Hearts'))
            else:
                picklist.append((str(deck[i][j])+ ' of Hearts'))
        if Spick == False and i == 1:
            Spick = True
            if j >= 9:
                i = random.randint(0,3)
                picklist.append((Facecard[i] + ' of Spades'))
            else:
                picklist.append((str(deck[i][j])) + ' of Spades')
        if Cpick == False and i == 2:
            Cpick = True
            if j>= 9:
                i = random.randint(0,3)
                picklist.append((Facecard[i] + ' of Clubs'))
            else:
                picklist.append((str(deck[i][j])) + ' of Clubs')
        if Dpick == False and i == 3:
            Dpick = True
            if j >= 9:
                i == random.randint(0,3)
                picklist.append((Facecard[i] + ' of Diamonds'))
            else:
                picklist.append((str(deck[i][j])) + ' of Diamonds')
        
    for fin in range(0,len(picklist)):
        print(picklist[fin])
    print('Number of picks: ' + str(counter))
    
    

        
