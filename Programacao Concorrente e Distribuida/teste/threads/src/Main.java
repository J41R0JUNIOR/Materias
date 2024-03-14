public class Main {

    public static void main(String[] args) {
        Ola ola1 = new Ola();
        Ola ola2 = new Ola();
        Ola ola3 = new Ola();
        Tchau tchau1 = new Tchau();
        Tchau tchau2 = new Tchau();
        Tchau tchau3 = new Tchau();

        ola1.start();
        ola2.start();
        ola3.start();
        tchau1.start();
        tchau2.start();
        tchau3.start();

//        ola1.join();
//        ola2.join();
//        ola3.join();
//        tchau1.join();
//        tchau2.join();
//        tchau3.join();
    }
}
