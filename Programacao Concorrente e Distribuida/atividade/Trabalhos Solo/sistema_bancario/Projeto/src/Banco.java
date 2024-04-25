import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    // Declaração de um objeto Lock para garantir exclusão mútua
    private Lock lock = new ReentrantLock();

    // Método para transferir fundos entre duas contas
    public void transferir(Conta cOrigem, Conta cDestino, Double valorTransferencia) {
        // Bloqueia o acesso a outras threads enquanto esta operação está em andamento
        lock.lock();
        try {
            // Verifica se a conta de origem tem saldo suficiente para a transferência
            if (cOrigem.getSaldo() >= valorTransferencia) {
                // Realiza a transferência debitando da conta de origem e creditando na conta de destino
                cOrigem.debitar(valorTransferencia);
                cDestino.depositar(valorTransferencia);

                // Imprime informações sobre a transferência
                System.out.println("---------------------Transferencia Feita----------------------------");
                System.out.println("Valor da Transferencia: R$" + valorTransferencia);
                System.out.println("Saldo final da conta de origem " + cOrigem.getNome() + ": R$" + cOrigem.getSaldo());
                System.out.println("Saldo final da conta de destino " + cDestino.getNome() + ": R$" + cDestino.getSaldo());
                System.out.println("--------------------------------------------------------------------");
            } else {
                // Caso a conta de origem não tenha saldo suficiente, imprime uma mensagem de saldo insuficiente
                System.out.println("Saldo insuficiente!!!");
            }
        } finally {
            // Libera o bloqueio após a conclusão da operação
            lock.unlock();
        }
    }
}
