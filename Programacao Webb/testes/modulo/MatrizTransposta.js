function transporMatriz(A){
    const linha = A.length;
    const coluna = A[0].length;

    vetor = [];

    for(j = 0; j < coluna; j++){
        vetor[j] = []
    }
    

    for(i = 0; i < coluna; i++){
        for(j = 0; j < linha; j++){
            vetor[i][j] = A[j][i];
        }

    }

    print(A, linha);
    console.log("\n")
    print(vetor, coluna);

  
}

function print(arr, coluna){
    for(j = 0; j < coluna; j++){
        console.log(arr[j]);
    }
}

module.exports = {
    transporMatriz,
    print
};