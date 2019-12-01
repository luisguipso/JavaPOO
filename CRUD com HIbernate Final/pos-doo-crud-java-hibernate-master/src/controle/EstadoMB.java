/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author aluno
 */
public class EstadoMB {

    EntityManager manager;

    public void inserir(Estado estado) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin(); // abre uma transação
            manager.persist(estado); // salva 
            t.commit(); // confirma a transação 

        } catch (Exception e) {
            t.rollback(); // desfaz tudoo
            e.printStackTrace(); //imprime o erro
        } finally {
            manager.close(); // fecha a conexao
        }
    }

    public void editar(Estado estado) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin(); // abre uma transação
            manager.merge(estado); // salva 
            t.commit(); // confirma a transação 

        } catch (Exception e) {
            t.rollback(); // desfaz tudoo
            e.printStackTrace(); //imprime o erro
        } finally {
            manager.close(); // fecha a conexao
        }
    }

    public void excluir(Estado estado) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin();
            Estado e = manager.find(Estado.class, estado.getId());

            // abre uma transação

            manager.remove(e);
        } catch (Exception e) {
            e.printStackTrace();     //imprime o erro
        } finally {
            manager.getTransaction().commit();
            manager.close(); // fecha a conexao
        }
    }

    public Estado buscar(Estado estado) {
        EntityManager manager = fabrica.Fabrica.get().createEntityManager();//
        return manager.find(Estado.class, estado.getId());
    }

    public List<Estado> buscarTodos() {

        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos  
        Query query = manager.createQuery("SELECT e FROM Estado e");
        List<Estado> estados = query.getResultList();
        return estados;
    }
}
