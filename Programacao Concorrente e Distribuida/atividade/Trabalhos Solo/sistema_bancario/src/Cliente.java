public class Cliente extends Thread{
    private String id;
    private Conta conta;

    public Cliente(String id){
        super();
        this.id = id;

        try {
            this.conta = new Conta(1000.00, id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public long getId(){return Long.parseLong(id);}


    public Conta getConta() {
        return conta;
    }

}
