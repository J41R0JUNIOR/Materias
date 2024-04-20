import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int NUM_CONSUMIDORES = 2;
         int NUM_PRODUTORES = 3;


        ReentrantLock lock = new ReentrantLock();
        Condition armazemCheio = lock.newCondition();
        Condition armazemVazio = lock.newCondition();
        Queue<Integer> fila =  new LinkedList<Integer>();

        Armazem armazem = new Armazem(fila, lock, armazemVazio, armazemCheio);

        for(int i = 0; i < NUM_PRODUTORES; i ++){
            new Produtor(armazem, "produtor_" + (i + 1)).start();
        }

        for(int i = 0; i < NUM_CONSUMIDORES; i ++){
            new Consumidor(armazem, "consumidor" +  + (i + 1)).start();
        }


    }
}