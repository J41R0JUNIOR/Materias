package atividade3;

public class Objeto {
    public int id, qtd;
    public String nome;
   
    

    Objeto(int id, String nome, int qtd){
        this.id = id;
        this.nome = nome;
        this.qtd = qtd;
    }



    String imprimir(){
        String imp = "";

        imp = "\nid = " + this.id + "\nnome = " + this.nome + "\nquantidade = " + this.qtd;

        return imp;
    }
}

