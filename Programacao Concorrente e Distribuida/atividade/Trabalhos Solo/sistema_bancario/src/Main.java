import java.lang.ref.Cleaner;
import java.util.ArrayList;

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
        cliente1.start();
        clientes.add(cliente1);
        Cliente cliente2 = new Cliente("Cliente2", lojas, banco);
        cliente2.start();
        clientes.add(cliente2);
        Cliente cliente3 = new Cliente("Cliente3", lojas, banco);
        cliente3.start();
        clientes.add(cliente3);
        Cliente cliente4 = new Cliente("Cliente4", lojas, banco);
        cliente4.start();
        clientes.add(cliente4);
        Cliente cliente5 = new Cliente("Cliente5", lojas, banco);
        cliente5.start();
        clientes.add(cliente5);

        System.out.println("---------------Saldos Finais dos Clientes---------------");
        for(int i = 0; i < 5; i ++){
            System.out.println(Long.toString(clientes.get(i).getId()) + " " + clientes.get(i).getConta().getSaldo());

        }


    }
}