package atividade2.Exercicio2.Calculadora2;

public class Calculadora2 {
    public float a, b;
    private String operador1, operador2;
    public float resposta;


    public void setOperadors(String op, String op2) throws Exception{
        Boolean erro1 = true;
        boolean erro2 = true;

        switch (op) {
            case "f":
                erro1 = false;
                break;
            case "c":
                erro1 = false;
                break;
            default:
            erro1 = true;
                break;
        }
        switch (op2) {
            case "f":
                erro2 = false;
                break;
            case "c":
                erro2 = false;
                break;
            default:
            erro2 = true;
                break;
        }

        if(erro1){
            throw new Exception("Operador 1 Inválido!");
        }
        if(erro2){
            throw new Exception("Operador 2 Inválido!");
        }

        
        this.operador1 = op;
        this.operador2 = op2;
        converter(this.a, this.b);
    }

    public void converter(Float a, Float b)  throws Exception{
        
        if(operador1 == "c" && operador2 == "f"){
            //this.resposta = (a/5) / ((b-32)/9);
            this.resposta = (a * 9/5) + 32;
        }
        else if(operador1 == "f" && operador2 == "c"){
            this.resposta = (a - 32) * 5/9;
            //this.resposta = ((a-32)/9) / (b/5);
        }
        else{
            throw new Exception("Operadores iguais");
        }
        
    }
}
