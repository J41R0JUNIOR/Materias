import java.util.ArrayList;
import java.util.Random;

public class Cliente extends Thread {
    private String id;
    private Conta conta;

    private ArrayList<Loja> lojas;
    private Banco banco;
    private int ultimaLoja = 0;
    private Random random = new Random();
    private boolean terminou = false;

    // Construtor da classe Cliente
    public Cliente(String id, ArrayList<Loja> lojas, Banco banco){
        super();
        this.id = id;
        this.lojas = lojas;
        this.banco = banco;

        try {
            // Inicializa a conta do cliente com um saldo inicial de 1000.00
            this.conta = new Conta(1000.00, id);
        } catch (Exception e) {
            // Lança uma exceção em caso de erro na criação da conta
            throw new RuntimeException(e);
        }
    }

    // Método para obter o ID do cliente
    public long getId() {
        return Long.parseLong(id);
    }

    // Método para verificar se o cliente terminou suas compras
    public boolean isTerminou() {
        return terminou;
    }

    // Método para obter a conta do cliente
    public Conta getConta() {
        return conta;
    }

    // Método principal que será executado pela thread do cliente
    public void run() {
        // Enquanto o saldo da conta do cliente for maior que zero, ele continuará fazendo compras
        while (conta.getSaldo() > 0.00) {
            int proximaLoja;
            do {
                // Seleciona aleatoriamente a próxima loja para fazer uma compra
                proximaLoja = random.nextInt(lojas.size());
            } while (proximaLoja == ultimaLoja);

            ultimaLoja = proximaLoja;

            // Define aleatoriamente o valor da compra como 100.00 ou 200.00
            double valorCompra = random.nextInt(2) == 0 ? 100.00 : 200.00;

            // Transfere o valor da compra da conta do cliente para a conta da loja
            banco.transferir(getConta(), lojas.get(proximaLoja).getConta(), valorCompra);
        }
        // Quando o saldo da conta do cliente se esgota, ele termina suas compras
        terminou = true;
    }
}
