import random

qtd = 1
max = 3
randInt = random.randint(0, 10)
userTry = int(input("try figure out the number, type some: "))

while randInt != userTry and qtd < max:
    
  
    if userTry > randInt:
        print("The number is smaller")
    else:
        print("The number is greater")

    print("You have {} time{}".format(max - qtd, '' if max - qtd == 1 else 's'))


    userTry = int(input("Try figure out the number, type some: "))

    qtd += 1
   

if userTry == randInt:
  print("Congratulations you got it")
else:
  print("Game Over")