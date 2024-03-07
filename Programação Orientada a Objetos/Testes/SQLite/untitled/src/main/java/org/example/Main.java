package org.example;

import poo.dao.PessoaDAO;
import poo.model.Pessoa;

public class Main {
    public static void main(String[] args) {

        System.out.print("Hello and welcome!\n");

        PessoaDAO dao = new PessoaDAO();

//        Pessoa p1 = new Pessoa("Jairo", "j@gmail.com");
//        Pessoa p2 = new Pessoa("Júnior", "jú@gmail.com");

//        Pessoa p1 = new dao.getPessoaById(Long.valueOf(1));
        Pessoa p1 = new PessoaDAO().getPessoaById(1L);

        System.out.println(p1);
//        System.out.println(p2);

//        dao.salvarPessoa(p1);
//        dao.salvarPessoa(p2);
    }
}