

# # def main():
# #     g, p = map(int, input().split())

# #     q = [list(map(int, input().split())) for _ in range(g)]

# #     s = int(input())

# #     scoreRules = [list(map(int, input().split())) for _ in range(s)]


# #     pilotsScores = [0] * p

# #     resultado = {}
# #     for i in range(len(q)):
# #         for j in range(len(q[i])):
# #             resultado[q[i][j]] = 0
# #     print(resultado)

# #     for i in range(len(scoreRules)):
# #         for j in range(len(q)):
# #             k = scoreRules[0][i]
# #             calculateResult(scoreRules[i], pilotsScores, k)
# #             whoWon(q, pilotsScores, k)
# #             pilotsScores = [0] * p



# # def calculateResult(rule, pilotScores, k):
# #     rule = rule[1:]
# #     print("rule",rule, "candidatos", k)
# #     for i in range(len(pilotScores)):
# #         if i <= k - 1:
# #             pilotScores[i] += rule[i]

# #     print("pilotScores =",pilotScores)



# # def whoWon(queue, pilotScores, k):
# #     print("queue=", queue)
# #     indexes = []
# #     greater = max(pilotScores)
# #     print("greater =",greater)
    
    
# #     for i in range(len(pilotScores)):
# #         if  i <= k and pilotScores[i] == greater:
# #             indexes.append(i)
# #     print("vencedores = ", indexes)
                

# # main()

#////////////////////////////////////////////////////////////////////////////////////////////////////////////



# g, p = map(int, input().split()) 

# while (g < 1 or g > 100):
#     g = int(input())

# while (p < 1 or p > 100):
#     p = int(input())

# q = []

# for i in range(g):
#     queue = input().split()
#     queue = queue[0:p]
#     queue = [int(n) for n in queue]
#     q.append(queue)

# s = int(input())

# while (s < 1 or s > 10):
#     s = int(input())

# scoresDescriptions = []
# k = []

# for i in range(s):
#     scoreSequence = input().split()
#     scoreSequence = [int(n) for n in scoreSequence]
#     k.append(scoreSequence[0])
#     scoresDescriptions.append(scoreSequence[1:k[i]+1])
    


# #calculando...

# resultado = {}


#////////////////////////////////////////////////////////////////////////////////////////////////////////////





# indices = []
# for scores in scoresDescriptions:
#     resultado = {piloto: 0 for corrida in q for piloto in corrida}

#     for j, points in enumerate(scores):
#         for k, race in enumerate(q):
#             resultado[race[j]] += points

#     max_score = max(resultado.values())
#     indices = [piloto for piloto, score in resultado.items() if score == max_score]
    
#     # print(indices)
#     indices.sort()
#     print(" ".join(str(p) for p in indices))


# #  for i in range(len(scoresDescriptions)):

# #     resultado = {piloto: 0 for corrida in q for piloto in corrida}

# #     for j in range(len(scoresDescriptions[i])):
# #         for k in range(len(q)):
# #             resultado[q[k][j]] += scoresDescriptions[i][j]

# #     max = max(resultado.values)
# #     if(resultado[i] == max):
# #         indices.append(resultado)
# #     print(resultado)
   


#////////////////////////////////////////////////////////////////////////////////////////////////////////////



# vet = []

# def iguais(lista, pontuacao, listaa):
#     texto = []
#     for a in range(0, len(listaa)):
#         if pontuacao == lista[listaa[a]]:
#             texto.append(listaa[a])
#     texto.sort()
#     texto = ' '.join(texto)

    
#     vet.append(texto)
# def insere(listaposicoes, dicionario, index):
#     if len(listaposicoes) == index -1:
#         return dicionario
#     else:
#         dicionario[str(index)]['lista'] += [int(listaposicoes[index-1])]
#         return insere(listaposicoes, dicionario, index + 1)
# def cria(qtd):
#     lista = {}
#     for a in range(1, qtd+1):
#         lista[str(a)] = {'lista':[], 'pontuacao': 0}
#     return lista
# def somapontos(listaposicoes, sistema):
#     listaPontos = {}
#     for b in range(1, len(listaposicoes)+1):
#         for a in range(1, len(sistema)):
#             for c in listaposicoes[str(b)]['lista']:
#                 if a == c:
#                     if str(b) in listaPontos:
#                         listaPontos[str(b)] += int(sistema[a])
#                     else:
#                         temp = {str(b): int(sistema[a])}
#                         listaPontos.update(temp)
#     return listaPontos
# def maior(lista, maiornum, index, listaa):
#     if len(lista) == index:
#         return maiornum
#     elif lista[listaa[index]] > maiornum:
#         maiornum = lista[listaa[index]]
#     return maior(lista, maiornum, index + 1, listaa)
# def main():
#     linha = str(input())
#     if linha != '0 0':
#         spl = linha.split(' ')
#         qtdPremios = int(spl[0])
#         qtdPilotos = int(spl[1])
#         listaPosicoes = cria(qtdPilotos)
#         for a in range(1, qtdPremios+1):
#             linha1 = str(input())
#             listaPosicoes = insere(linha1.split(' '), listaPosicoes, 1)
#         qtdsistpont = int(input())
#         listaPontuacao = []
#         for b in range(0, qtdsistpont):
#             linha2 = str(input())
#             listaPontuacao = somapontos(listaPosicoes, linha2.split(' '))
#             ind = list(listaPontuacao.keys())
#             maximo = maior(listaPontuacao, 0, 0, ind)
#             iguais(listaPontuacao, maximo, ind)
#         main()
#     else:
        
#         for i in vet:
#             print(i)
# main()

