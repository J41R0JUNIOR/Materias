public class Executavel {
    
    public static void main(String[] args) throws Exception{
        
        ContaCorrente c1 = new ContaCorrente(123, 1500.34);
        ContaCorrente c2 = new ContaCorrente(456, 52.05);

        System.out.println(c1);
        System.out.println(c2);

        c1.transferir(c2, 500.00);

         System.out.println(c1);
        System.out.println(c2);
        
        c1.transferir(c2, c1, 340.03);
        
        System.out.println(c1);
        System.out.println(c2);

    }

}
