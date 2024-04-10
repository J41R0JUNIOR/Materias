# The Formula 1 season consists of a series of races, known as Grand Prix, organized by the International Federation of Automobile (FIA). The results of each Grand Prix are combined to determine Pilots\' World Championship. More specifically, for each race some points are distributed to pilots, depending on their classification in the race. At the end of the season, the pilot who has earned the most points is declared the World Champion.

# Formula 1 organizers change constantly the competition rules, aiming to provide more excitement to fans. One rule modified for the 2010 season was the distribution of points in each Grand Prix. Since 2003, the scoring rule rewarded the top eight pilots, according to the following table:


# That is, the winning driver received 10 points, second place received 8 points, and so on. In the 2010 season the top ten will receive points, obeying the following table:


# The change in the scoring system led to much speculation about what would have been the effect to the World Championship in the past if the new score had been used. For example, would Lewis Hamilton have been champion in 2008, considering he and Felipe Massa were separated by just one point? To end the speculation, FIA hired you to write a program that, given the results of each race of a season determines the World Champion for different scoring systems.

# Input

# The input contains several test cases. The first line of a test case contains two integers G and P separated by a blank space, indicating the number of Grand Prix (1 ≤ G ≤ 100) and the number of pilots (1 ≤ P ≤ 100).. Pilots are identified by integers from 1 to P. Each of the following G lines indicates the result of a race, and contains Q integers separated by spaces. On each line, the (i)-th number indicates the order of arrival of pilot i in the race (the first number indicates the order of arrival of a pilot 1 in that race, the second number indicates the order of arrival of pilot 2 in that race and so on). The next line contains a single integer S indicating the number of scoring systems (1 ≤ S ≤ 10), After that, each of the following lines S contains a description of a scoring system. The description of a scoring system begins with an integerK (1 ≤ K ≤ P), indicating the last finishing order to receive points, followed by a blank space, followed by e K integers k0, k1, ... , kn−1 (1 ≤ ki ≤ 100) separated by spaces, indicating the number of points to be assigned (the first integer indicates the points for first place, the second integer indicates the points for second place and so on). The last test case is followed by a line containing only two zeros separated by a blank space.

# Output

# For each scoring system in the input your program must print one line, containing the identifier of the World Champion. If more than one pilot are World Champions (ie, if there is a tie), the line must contain all World Champions, in increasing order of identifier, separated by a space.


#To understand better you can start by main function

def calcular(r, k, q, p):
    result = [] #An array that we'll put the results of the races
    for i in range(p): #Filling the array with zero's, we'll need this after to be the same quantity fo pilots
        result.append(0) #adding the zero

    winners = [] #An array that we'll store all the winners of the RULE,(yes, the rule, for each one we have to calculate the winner of this rule)

    for i in range(len(q)):
        #The logic i used was to get the pilot position at each race and verify if it's less or equal to the k variable(quantity of pilots that will receive the points),                                                                                      
        #FOR EXAMPLE q = [3, 1, 2], the pilot[0] got at the third place, pilot[1] got at the first place...                                                                                             k = 2 and r = [5, 2], the first pilot one get five points and the second one get two                                                                                                  So, the pilot[1] get 5, and pilot[2] get 2 points, then we have to calculate the points of each pilot in each races and sum with is sucessor                                                            
        for j in range(len(q[i])):
            if q[i][j] <= k: 
                result[j] += r[q[i][j] - 1] #calculating the races, for each race and for each pilot it sum its points
                #FOR EXAMPLE: if the pilot one got at third at the first race, and first at the second, it will sum it's points
  
    maxPoints = max(result) #We just want to get the winners, so, it get the maximum point get
   
    for i in range(len(result)): #Now we get the position of the winner pilot and then we add to the array winners
        if result[i] == maxPoints:
            winners.append(i + 1) #this +1 is becouse the variable i goes through 0... and when we want to know the player we don't have player 0, we have the player[0] that is the player position at the array, the players comes from 1 to 100.

    return winners
            

def main():
    tryAgain = True #This is for continuing in the loop trying new cases
    while tryAgain:
        g, p = map(int, input().split()) #g variable is the quantity of races and the p variable is the quantity of pilots
        if g == 0 and p == 0: #end the program
            tryAgain = False
            break
        q = [list(map(int, input().split())) for _ in range(g)] #the position of each pilots going through 1 < g < 100. THIS IS NOT THE QUEUE FINISHING ORDER OF PILOTS, IT IS IT'S POSITIONS, so the first value is the pilot[0], the second is the pilot[1] ...
        s = int(input()) #quantity of rules that we'll calculate

        for _ in range(s): #for each rule, we have to calculate all races stored at the variable q
            k, *rules = map(int, input().split()) #the variable k, is the quantity of pilots that will receive points, and the rule variable is all the rules that the program will calculate
            result = calcular(rules, k, q, p) #here we get an array of results
            print(*result) #printing the result of each rule

main()