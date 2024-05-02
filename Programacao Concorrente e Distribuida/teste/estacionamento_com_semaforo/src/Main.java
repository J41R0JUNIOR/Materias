import java.util.concurrent.Semaphore;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Semaphore estacionamento = new Semaphore(10);

        for(int i = 0; i < 20; i++){
            new Carro("carro "+i, estacionamento).start();
        }

    }
}