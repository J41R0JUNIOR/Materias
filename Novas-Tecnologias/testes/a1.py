
print("Hello World")

# 0,1,1,2,3,5,8

vet = [0]
valor = 1
n = int(0)
i = int(0)

n = input(str("digite o n: "))
n = int(n) - 1

while i < n:
    i += 1
    vet.append(valor)

    valor = valor + vet[i - 1]
    
print(vet)