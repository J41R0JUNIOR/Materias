import java.lang.ref.Cleaner;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {
        Banco banco = new Banco();

        Loja loja1 = new Loja("Loja1", banco);
        Loja loja2 = new Loja("Loja2", banco);

        ArrayList<Loja> lojas = new ArrayList<>();
        lojas.add(loja1);
        lojas.add(loja2);

        ArrayList<Cliente> clientes = new ArrayList<>();

//        for(int i = 1; i < 6; i++){
//            Cliente cliente = new Cliente("Cliente" + i , lojas, banco);
//            cliente.start();
//        }

        Cliente cliente1 = new Cliente("Cliente1", lojas, banco);
        Cliente cliente2 = new Cliente("Cliente2", lojas, banco);
        Cliente cliente3 = new Cliente("Cliente3", lojas, banco);
        Cliente cliente4 = new Cliente("Cliente4", lojas, banco);
        Cliente cliente5 = new Cliente("Cliente5", lojas, banco);


        cliente1.start();
        clientes.add(cliente1);
        cliente2.start();
        clientes.add(cliente2);
        cliente3.start();
        clientes.add(cliente3);
        cliente4.start();
        clientes.add(cliente4);
        cliente5.start();
        clientes.add(cliente5);


        for (Cliente cliente : clientes) {
            cliente.join();
        }

        System.out.println("\n\n\n\n\n");
        System.out.println("---------------Saldos Finais dos Clientes---------------");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getConta().getNome() + " R$ " + cliente.getConta().getSaldo());
        }

        System.out.println("---------------Saldos Finais das Lojas---------------");
        for (Loja loja : lojas) {
            System.out.println(loja.getConta().getNome() + " R$ " + loja.getConta().getSaldo());
        }

        System.out.println("---------------Saldos Finais dos Funcionarios---------------");

        for (Loja loja : lojas) {
            System.out.println(loja.getFuncionario1().getConta().getNome() + " R$ " + loja.getFuncionario1().getConta().getSaldo());
            System.out.println(loja.getFuncionario1().getContaInvestimento().getNome() + " R$ " + loja.getFuncionario1().getContaInvestimento().getSaldo());

            System.out.println(loja.getFuncionario2().getConta().getNome() + " R$ " + loja.getFuncionario2().getConta().getSaldo());
            System.out.println(loja.getFuncionario2().getContaInvestimento().getNome() + " R$ " + loja.getFuncionario2().getContaInvestimento().getSaldo());


        }



    }
}