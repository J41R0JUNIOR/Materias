package poo.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import poo.model.Pessoa;

public class PessoaDAO {

    private static SessionFactory sessionFactory;

    static{
        try{
            Configuration configuration = new Configuration().configure();
            sessionFactory = configuration.buildSessionFactory();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void close(){
        sessionFactory.close();
    }

    public Pessoa getPessoaById(Long id){
        Pessoa p = null;

        try{
            Session session = sessionFactory.openSession();
            p = session.get(Pessoa.class, id);

        }catch (Exception e){
            e.printStackTrace();
        }
        return p;
    }

    public void salvarPessoa(Pessoa p){

        Transaction transaction = null;

        try{
            Session session = sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(p);
            transaction.commit();
        }catch (Exception e){
            if(transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }

}
