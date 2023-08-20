package atividade2.Exercicio1;
import atividade2.Exercicio1.Calculadora.Calculadora;


public class Exercicio1 {
    
    public static void main(String[] args) throws Exception{

        Calculadora calc = new Calculadora();


        calc.a = 3;
        calc.b = 5;

        calc.setOperador("+");

        System.out.println(calc.operar());
    }

    
}

