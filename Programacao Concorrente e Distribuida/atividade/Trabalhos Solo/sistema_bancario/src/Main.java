import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) throws Exception {

        //Criando a instância do banco que será passada para todos que precisarem realizar transações
        Banco banco = new Banco();

        //Criando as instâncias das lojas
        Loja loja1 = new Loja("Loja1", banco);
        Loja loja2 = new Loja("Loja2", banco);

        //Precisarei desse array de lojas posteriormente pra passar a referência das lojas para os clientes
        // conseguirem realizar as compras
        ArrayList<Loja> lojas = new ArrayList<>();
        lojas.add(loja1);
        lojas.add(loja2);

        //Esse array de clientes é tanto pra criar os clientes, tanto pra conseguir printar posteriormente
        ArrayList<Cliente> clientes = getClientes(lojas, banco);

        //Com o join eu consigo esperar todas as threads fazerem seus trabalhos para depois imprimir o resultado
        for (Cliente cliente : clientes) {
            cliente.join();
        }

        //Impriminto todos os Saldos Finais de todas as contas
        System.out.println("\n\n\n\n\n");
        System.out.println("---------------Saldos Finais dos Clientes----------------------------");
        for (Cliente cliente : clientes) {
            System.out.println(cliente.getConta().getNome() + " R$ " + cliente.getConta().getSaldo());
        }

        System.out.println("---------------Saldos Finais das Lojas-------------------------------");
        for (Loja loja : lojas) {
            System.out.println(loja.getConta().getNome() + " R$ " + loja.getConta().getSaldo());
        }

        System.out.println("---------------Saldos Finais dos Funcionarios------------------------");

        for (Loja loja : lojas) {
            System.out.println(loja.getFuncionario1().getConta().getNome() + " R$ " + loja.getFuncionario1().getConta().getSaldo());
            System.out.println(loja.getFuncionario1().getContaInvestimento().getNome() + " R$ " + loja.getFuncionario1().getContaInvestimento().getSaldo());

            System.out.println(loja.getFuncionario2().getConta().getNome() + " R$ " + loja.getFuncionario2().getConta().getSaldo());
            System.out.println(loja.getFuncionario2().getContaInvestimento().getNome() + " R$ " + loja.getFuncionario2().getContaInvestimento().getSaldo());


        }
        System.out.println("---------------------------------------------------------------------");
    }

    private static ArrayList<Cliente> getClientes(ArrayList<Loja> lojas, Banco banco) {
        ArrayList<Cliente> clientes = new ArrayList<>();

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
        return clientes;
    }
}