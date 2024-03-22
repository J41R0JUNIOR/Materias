function transporMatriz(A){
    const linha = A.length;
    const coluna = A[0].length;

    vetor = [];

    console.log(linha);
    console.log(coluna);

    for(j = 0; j < coluna; j++){
        vetor[j] = []
    }

    for(i = 0; i < coluna; i++){
        for(j = 0; j < linha; j++){
            vetor[i][j] = A[j][i];
        }

    }


   console.log(vetor);
}

A = [[0,1,2,5], [3,,4,4], [5,6,3,5]];
transporMatriz(A);
