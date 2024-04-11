public class Data {
    private String message;
    private boolean isSendind = true;
    public synchronized void send(String message){
        //espero...
        while(!isSendind){
            System.out.println("Waiting the end of receiving...");
            try {
                wait();
            }catch (InterruptedException e){
                System.out.println("Interrupted Thread");
            }
        }
        //enviar a mensagem
        this.message = message;

        System.out.println(("Sended message: " + this.message));

        //fim do envio
        this.isSendind = false;
        notify();
    }

    public synchronized String receive(){
        //espero...
        while(isSendind){
            System.out.println("Waiting the end of sending...");

            try{
                wait();
            }catch (InterruptedException e){
                System.out.println("Interrupted Thread");
            }
        }
        //receber a mensagem...
        String receivedMessage = this.message;
        System.out.println(("Received message: " + this.message));

        //fim do recebimento...
        this.isSendind = true;
        notify();

        return receivedMessage;
    }
}
