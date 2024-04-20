import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        int numExec = 0;
        ReentrantLock lock = new ReentrantLock();


        while(true) {
            Counter counter = new Counter(0,lock);

            Incrementer inc1 = new Incrementer(counter);
            Incrementer inc2 = new Incrementer(counter);
            Incrementer inc3 = new Incrementer(counter);
            Incrementer inc4 = new Incrementer(counter);

            inc1.start();
            inc2.start();
            inc3.start();
            inc4.start();

            try {
                inc1.join();
                inc2.join();
                inc3.join();
                inc4.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            numExec++;

            if(counter.getValue() != 2){ //resultado diferente do esperado
                System.out.println("valor final do contador: " + counter.getValue());
                System.out.println("numero de execuções: " + numExec);
                break;
            }



        }
    }
}