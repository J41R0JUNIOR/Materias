package atividade2.Exercicio1;

public class Exercicio1 {
    
    public int a,b;
    private String operador;
    public char[] resposta;

    public static void main(String[] args) throws Exception{

        Exercicio1 calc = new Exercicio1();


        calc.a = 3;
        calc.b = 5;

        calc.setOperador("+");

        System.out.println(calc.operar());
    }
    

    public String getOperador(){
        return this.operador;
    }

    public void setOperador(String op) throws Exception{
        Boolean erro = true;

        switch (op) {
            case "+":
                erro = false;
                break;
            case "-":
                erro = false;
                break;
            case "*":
                erro = false;
                break;
            case "/":
                erro = false;
                break;
            default:
            erro = true;
                break;
        }

        if(erro){
            throw new Exception("Operador Inválido!");
        }
        this.operador = op;
    }

    public int operar(){

        int ret = 0;

        switch (this.operador) {
            case "+":
                ret = this.a + this.b;
                break;
            case "-":
                ret = this.a - this.b;
                break;
            case "*":
                ret = this.a * this.b;
                break;
            case "/":
                ret = this.a / this.b;
                break;
            default:
                break;
        }
        return ret;
    }


    public void setOperadors(String string, String string2) {
    }
    
    
}

