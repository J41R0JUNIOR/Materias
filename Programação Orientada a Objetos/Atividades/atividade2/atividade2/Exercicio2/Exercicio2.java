package atividade2.Exercicio2;

import java.util.Scanner;

public class Exercicio2 {
    public float a, b;
    private String operador1, operador2;
    public float resposta;


    public static void main(String[] args) throws Exception{

        Exercicio2 calc = new Exercicio2();


        calc.a = 0;
        // Cria um objeto Scanner para ler entradas do terminal
        Scanner scanner = new Scanner(System.in);

        System.out.print("Digite o valor: ");
        float valor = scanner.nextFloat(); 

        scanner.nextLine();

        System.out.printf("f para Fahreneit e c para Celsius \n valor digitado é:");
        String op = scanner.nextLine(); // Lê a linha digitada pelo usuário

        System.out.print("e voce quer transformar em:");
        String op2 = scanner.nextLine(); 

        

        // Não se esqueça de fechar o Scanner quando terminar de usá-lo
        scanner.close();


        System.out.println(op);
        System.out.println(op2);



       calc.a = valor;
        calc.setOperadors(op, op2, "foi");

        System.out.print(calc.resposta);
        
    }


    public void setOperadors(String op, String op2, String string) throws Exception{
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

    public void converter(Float a, Float b) throws Exception {

        if (this.operador1.equals("c") && this.operador2.equals("f")) {
            this.resposta = (a * 9/5) + 32;

        } else if (this.operador1.equals("f") && this.operador2.equals("c")) {
            this.resposta = (a - 32) * 5/9;

        } else if (this.operador1.equals("f")) {
            System.out.print(operador1);

        } else {
            throw new Exception("Operadores iguais");
        }
    }
    
}
