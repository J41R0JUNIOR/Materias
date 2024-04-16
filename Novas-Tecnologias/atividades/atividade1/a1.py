import numpy as np

with open('array.txt', 'r') as arquivo_entrada:
    n = int(arquivo_entrada.readline())
    dados = []
    for linha in arquivo_entrada:
        numeros_linha = [int(numero) for numero in linha.split()]
        dados.append(numeros_linha)

matriz = np.array(dados)

# for i in range(len(matriz)):
#     qtd = 0
#     for j in range(len(matriz[0])):
#         for n in range(matriz[i][j]):
#             if (matriz[i][j] % n == 0):

primos = [2, 3, 5, 7, 11]

multiplos_primos = []
for primo in primos:
    count_multiplos = 0
    for elemento in matriz.flatten():
        if elemento % primo == 0:
            count_multiplos += 1
    multiplos_primos.append((primo, count_multiplos))

with open('saida1.txt', 'w') as arquivo_saida:
    for primo, count_multiplos in multiplos_primos:
        arquivo_saida.write("{} {}\n".format(primo, count_multiplos))