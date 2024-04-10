#ex m = [1, 2, 3] 
#       [4, 5, 6]   se transforme em [1, 4]
#                                    [2, 5]
#                                    [3, 6]

def transporMatriz(m):
    linha = len(m)
    coluna = len(m[0])

    matrizTransposta =  []
    for i in range(coluna):
        matrizTransposta.append([0] * linha)

    for i in range(len(m)):
        for j in range(len(m[i])):
            matrizTransposta[j][i] = m[i][j]

    printMatriz(matrizTransposta)

def printMatriz(m):
        for i in range(len(m)):
            print(m[i])

matriz = [[1,2,3],[4,5,6]]
printMatriz(matriz)
transporMatriz(matriz)