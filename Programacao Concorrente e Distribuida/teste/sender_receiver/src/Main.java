public class Main {
    public static void main(String[] args) {
        Data data = new Data();
        String[] messages = {
                "message 1", "message 2", "message 3", "message 4", "End"
        };

        Sender r1 = new Sender(data, messages);
        Receiver d1 = new Receiver(data);

    r1.start();
    d1.start();


    }
}