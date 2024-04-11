import java.util.concurrent.ThreadLocalRandom;

public class Receiver extends Thread{
    private Data data;
    public Receiver(Data data){
        this.data = data;
    }
    public void run(){
        while(true){
            String receivedMessage = this.data.receive();

            int randomDelay = ThreadLocalRandom.current().nextInt(5000, 10000);

            try {
                Thread.sleep(randomDelay);
            } catch (InterruptedException e) {
                System.out.println("Interrupted Thread!!!");
            }

            if(receivedMessage.equals("End")){
                break;
            }
        }
    }
}
