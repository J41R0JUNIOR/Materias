package atividade1;

public class a01 {
    
    public static void main (String args[]){

        

       int x = 9, resultado = verificarNumeroPrimo(x);

       System.out.println(x);
       
        if (resultado == 1){
            System.out.println("Numero Primo");
        }else{
              System.out.println("Numero Não Primo");
        }
    }

    public static Integer verificarNumeroPrimo(Integer number){
        int qtd = 0;
        
        if((number % 2) != 0){
            for(int i = number ; i != 0; i--){
                if((number % i) == 0){
                    qtd++;
                }
            }  
            if(qtd <= 2){
            return 1;
            }else{
                return 0;
            }
        }else{
            return 0;
        }
    }
}
