import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private Lock lock = new ReentrantLock();
   public void transferir(Conta cOrigem, Conta cDestino, Double valorTransferencia){
       lock.lock();

       try {
           if (cOrigem.getSaldo() >= valorTransferencia) {
               cOrigem.debitar(valorTransferencia);
               cDestino.depositar(valorTransferencia);

               System.out.println("---------------------Transferencia Feita----------------------------");
               System.out.println("Valor da Transferencia: R$" + valorTransferencia);
               System.out.println("Saldo final da conta de origem " + cOrigem.getNome() + ": R$" + cOrigem.getSaldo());
               System.out.println("Saldo final da conta de destino " + cDestino.getNome() + ": R$" + cDestino.getSaldo());
               System.out.println("--------------------------------------------------------------------");
           }else{
               System.out.println("Saldo insuficiente!!!");
           }
       } finally {
           lock.unlock();
       }
   }
}
