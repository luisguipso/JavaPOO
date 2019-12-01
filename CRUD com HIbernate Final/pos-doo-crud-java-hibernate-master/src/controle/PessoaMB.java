/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Pessoa;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author aluno
 */
public class PessoaMB {

    EntityManager manager;

    public void inserir(Pessoa pessoa) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin(); // abre uma transação
            manager.persist(pessoa); // salva 
            t.commit(); // confirma a transação 

        } catch (Exception e) {
            t.rollback(); // desfaz tudoo
            e.printStackTrace(); //imprime o erro
        } finally {
            manager.close(); // fecha a conexao
        }
    }

    public void editar(Pessoa pessoa) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin(); // abre uma transação
            manager.merge(pessoa); // salva 
            t.commit(); // confirma a transação 

        } catch (Exception e) {
            t.rollback(); // desfaz tudoo
            e.printStackTrace(); //imprime o erro
        } finally {
            manager.close(); // fecha a conexao
        }
    }

    public void excluir(Pessoa pessoa) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin();
            Pessoa p = manager.find(Pessoa.class, pessoa.getId());

            // abre uma transação
            manager.remove(p);
        } catch (Exception e) {
            e.printStackTrace();     //imprime o erro
        } finally {
            manager.getTransaction().commit();
            manager.close(); // fecha a conexao
        }
    }

    public List<Pessoa> buscarTodos() {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos  
        Query query = manager.createQuery("SELECT e FROM Pessoa e");
        List<Pessoa> pessoas = query.getResultList();
        return pessoas;
    }

    

}
