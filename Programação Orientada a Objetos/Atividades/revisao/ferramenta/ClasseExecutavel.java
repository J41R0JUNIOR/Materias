package ferramenta;
import revisao.ferramenta.Calculadora;

public class ClasseExecutavel {
    
    public static void main(String[] args) throws Exception{

        Calculadora calc = new Calculadora();
        Calculadora calc2 = new Calculadora();


        calc.a = 3;
        calc.b = 5;

        calc.setOperador("+");

        System.out.println(calc.operar());
    }
}
