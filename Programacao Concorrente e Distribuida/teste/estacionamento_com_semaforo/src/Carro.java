import java.util.concurrent.Semaphore;
import java.util.Random;

public class Carro extends Thread {
    private Semaphore estacionamento;
    public Carro(String nome, Semaphore estacionamento){
        super(nome);
        this.estacionamento = estacionamento;
    }

    public void espera(){
        try {
            Thread.sleep(new Random().nextInt(15000));
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void run() {
        try{
            this.estacionamento.acquire();

            System.out.println(this.getName() + " entrou no estacionamento!");

            this.espera();

            System.out.println(this.getName() + " saindo do estacionamento!");

            this.estacionamento.release();

        }catch (InterruptedException e){
            System.out.println("Thread Interrompida");
        }
    }
}
