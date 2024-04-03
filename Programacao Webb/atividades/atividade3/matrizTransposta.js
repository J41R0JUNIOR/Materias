function transporMatriz(A) {
    console.log("Matriz original:");
    imprimirMatriz(A);

    const linhas = A.length;
    const colunas = A[0].length;

    const matrizTransposta = [];
    for (let j = 0; j < colunas; j++) {
        matrizTransposta[j] = [];
    }

    for (let i = 0; i < linhas; i++) {
        for (let j = 0; j < colunas; j++) {
            matrizTransposta[j][i] = A[i][j];
        }
    }

    console.log("Matriz transposta:");l
    imprimirMatriz(matrizTransposta);
}

function imprimirMatriz(matriz) {
    for (let i = 0; i < matriz.length; i++) {
        console.log(matriz[i].join("\t"));
    }
}

transporMatriz(matriz);

const matriz = [
    [1,2],
    [3,4],
    [5,6]
];
