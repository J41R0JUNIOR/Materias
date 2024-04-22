import java.lang.ref.Cleaner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();

        Cliente cliente1 = new Cliente("Cliente1");
        Cliente cliente2 = new Cliente("Cliente2");
        Cliente cliente3 = new Cliente("Cliente3");
        Cliente cliente4 = new Cliente("Cliente4");
        Cliente cliente5 = new Cliente("Cliente5");

        Loja loja1 = new Loja("Loja1");
        Loja loja2 = new Loja("Loja2");

//       banco.transferir(cliente1.getConta(), cliente2.getConta(), 400.00);

       loja1.pagarFuncionario();
       loja1.pagarFuncionario();
       loja1.pagarFuncionario();



        System.out.printf("Hello and welcome!");
    }
}