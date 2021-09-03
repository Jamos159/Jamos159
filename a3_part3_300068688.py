# Course: IT1 1120 G
# Assignment number: 3
# Due Date: March 20th, 8:00 pm, 2020
# Amos, Jared
# Student number: 300068688

########################
# Question 1
########################
def Hangman():
    '''function called Hangman that takes no arguments and simulates a game of hangman
 , the function will randomely pick a word from a list of words and then encrypt
 it using the '*' sign, the user will then be prompted to enter a letter
 and if that letter is in the encrypted word it is revealed, this continues
 until the user has guessed every letter in the word, and then tells the user
 what the word was and how many missed tries they had '''
    import random
    encPickStr = ''
    words = ['write','program','that','receive','postive','change','study','excellent','nice'
             , 'warcraft', 'starcraft', 'mario' ]
    pick = random.choice(words)
    transl = str.maketrans('abcdefghijklmnopqrstuvwxyz','**************************')
    encPick = pick.translate(transl)
    encPick = list(encPick)
    pick = list(pick)
    counter = 0
    
    while encPick != pick:
        guess = input('(Guess) Enter a letter in word ' + (''.join(encPick)) + ' ')
        guess = guess.lower()
        if guess in encPick:
            print(guess + ' is already in the word')
        if guess in pick:
            for i in range(len(pick)):
                if pick[i] == guess:
                    encPick[i] = guess
        if guess not in pick:
            counter += 1

    print(' The Word is ' + (''.join(pick)) + ' you missed ' + str(counter) + ' times' + '\n')

    answer = input('Do you want to guess another word? Enter y or n ')

    if answer == 'y':
        Hangman()
    else:
        return("Thanks for playing")
    
            
        
    
                
            
    
    
         
