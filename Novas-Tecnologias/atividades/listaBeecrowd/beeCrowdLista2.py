# def encontrar_intersecao_listas(lista_de_listas):
#     conjuntos = [set(lista) for lista in lista_de_listas]
    
#     intersecao = set.intersection(*conjuntos)
    
#     intersecao_ordenada = sorted(list(intersecao))
    
#     return intersecao_ordenada

# num_listas = int(input())

# listas = []
# for _ in range(num_listas):
#     lista = input().split()
#     listas.append(lista)

# resultado = encontrar_intersecao_listas(listas)

# resultado = [int(valorIndice) for valorIndice in resultado]


# print(resultado)

qtd = int(input())
lista = set()
listaDeConjuntos = []

for _ in range(qtd):
    lista = input().split()
    # listaDeListas.append(lista)
    listaDeConjuntos.append(set(lista))


listaFinal = sorted(set.intersection(*listaDeConjuntos))
listaFinal = [int(i) for i in listaFinal]


print(listaFinal)

