def createArray(lines, coluns, startValue):
    linha = [startValue] * lines
    array = [linha] * coluns

    return array
    
matriz = createArray(3,2,0)
print(*matriz)


