# The Formula 1 season consists of a series of races, known as Grand Prix, organized by the International Federation of Automobile (FIA). The results of each Grand Prix are combined to determine Pilots\' World Championship. More specifically, for each race some points are distributed to pilots, depending on their classification in the race. At the end of the season, the pilot who has earned the most points is declared the World Champion.

# Formula 1 organizers change constantly the competition rules, aiming to provide more excitement to fans. One rule modified for the 2010 season was the distribution of points in each Grand Prix. Since 2003, the scoring rule rewarded the top eight pilots, according to the following table:


# That is, the winning driver received 10 points, second place received 8 points, and so on. In the 2010 season the top ten will receive points, obeying the following table:


# The change in the scoring system led to much speculation about what would have been the effect to the World Championship in the past if the new score had been used. For example, would Lewis Hamilton have been champion in 2008, considering he and Felipe Massa were separated by just one point? To end the speculation, FIA hired you to write a program that, given the results of each race of a season determines the World Champion for different scoring systems.

# Input

# The input contains several test cases. The first line of a test case contains two integers G and P separated by a blank space, indicating the number of Grand Prix (1 ≤ G ≤ 100) and the number of pilots (1 ≤ P ≤ 100).. Pilots are identified by integers from 1 to P. Each of the following G lines indicates the result of a race, and contains Q integers separated by spaces. On each line, the (i)-th number indicates the order of arrival of pilot i in the race (the first number indicates the order of arrival of a pilot 1 in that race, the second number indicates the order of arrival of pilot 2 in that race and so on). The next line contains a single integer S indicating the number of scoring systems (1 ≤ S ≤ 10), After that, each of the following lines S contains a description of a scoring system. The description of a scoring system begins with an integerK (1 ≤ K ≤ P), indicating the last finishing order to receive points, followed by a blank space, followed by e K integers k0, k1, ... , kn−1 (1 ≤ ki ≤ 100) separated by spaces, indicating the number of points to be assigned (the first integer indicates the points for first place, the second integer indicates the points for second place and so on). The last test case is followed by a line containing only two zeros separated by a blank space.

# Output

# For each scoring system in the input your program must print one line, containing the identifier of the World Champion. If more than one pilot are World Champions (ie, if there is a tie), the line must contain all World Champions, in increasing order of identifier, separated by a space.


def calcular(r, k, q, p, g):
    resultado = [[0] * p for _ in range(g)]
    print(resultado)
    winners = []

    for i in range(q):
        for j in range(q[i]):
            resultado[i][j] += r[i]
            


    return winners
            



g, p = map(int, input().split())
# print(g,p)

q = [list(map(int, input().split())) for _ in range(g)]
# print(q)

s = int(input())
# print(s)

for _ in range(s):
    k, *regras = map(int, input().split())
  
    print(calcular(regras, k, q, p, g))