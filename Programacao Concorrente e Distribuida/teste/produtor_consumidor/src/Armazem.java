import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.Queue;

public class Armazem {
    static private int CAPACIDADE = 10;
    private Queue<Integer> fila;
    private ReentrantLock lock;
    private Condition armazemVazio;
    private Condition armazemCheio;

    public Armazem(Queue<Integer> fila, ReentrantLock lock, Condition armazemVazio, Condition armazemCheio) {
        this.fila = fila;
        this.lock = lock;
        this.armazemVazio = armazemVazio;
        this.armazemCheio = armazemCheio;
    }

    public void adicionar(int produto){
        this.lock.lock();

        while(this.fila.size() == CAPACIDADE){
            try {
                this.armazemCheio.await();
            }catch (InterruptedException e){
                System.out.println("Thread Interrompida");
            }
        }

        System.out.println("Adicionando produto " + produto);
        this.fila.add(produto);
        this.armazemVazio.signalAll();

        this.lock.unlock();
    }

    public int remover(int produto){
        this.lock.lock();

        while(this.fila.size() == 0){
            try {
                this.armazemVazio.await();
            }catch (InterruptedException e){
                System.out.println("Thread Interrompida");
            }
        }


        this.fila.remove();
        System.out.println("Removendo produto" + produto);
        this.armazemVazio.signalAll();

        this.lock.unlock();

        return produto;
    }
}
