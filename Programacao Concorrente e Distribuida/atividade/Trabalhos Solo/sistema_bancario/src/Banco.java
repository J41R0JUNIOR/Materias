import java.util.ArrayList;
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
           }else{
               System.out.println("Saldo insuficiente!!!");
           }
       } finally {
           lock.unlock();
       }
   }
}
