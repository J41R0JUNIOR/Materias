import java.util.concurrent.ThreadLocalRandom;

public class Sender extends Thread{
    private Data data;
    private String[] messages;

    public Sender(Data data, String[] messages){
        this.data = data;
        this.messages = messages;
    }

     public void run() {
         for (String message : this.messages) {
             int randomDelay = ThreadLocalRandom.current().nextInt(5000, 10000);

             try {
                 Thread.sleep(randomDelay);
             } catch (InterruptedException e) {
                 System.out.println("Interrupted Thread!!!");
             }

             this.data.send(message);
         }
     }
}
