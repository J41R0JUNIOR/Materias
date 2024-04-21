import java.lang.ref.Cleaner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();

        Cliente cliente1 = new Cliente(1);
        Cliente cliente2 = new Cliente(2);
        Cliente cliente3 = new Cliente(3);
        Cliente cliente4 = new Cliente(4);
        Cliente cliente5 = new Cliente(5);

        Loja loja1 = new Loja(1);
        Loja loja2 = new Loja(2);


       banco.transferir(cliente1.getConta(), cliente2.getConta(), 400.00);


       System.out.println(cliente1.getConta().getSaldo());
       System.out.println(cliente2.getConta().getSaldo());


       loja1.pagarFuncionario();



        System.out.printf("Hello and welcome!");


    }
}