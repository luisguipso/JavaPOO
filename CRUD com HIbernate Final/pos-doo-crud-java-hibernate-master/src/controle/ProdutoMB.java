/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author aluno
 */
public class ProdutoMB {
    EntityManager manager;

    public void inserir(Produto produto) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin(); // abre uma transação
            manager.persist(produto); // salva 
            t.commit(); // confirma a transação 

        } catch (Exception e) {
            t.rollback(); // desfaz tudoo
            e.printStackTrace(); //imprime o erro
        } finally {
            manager.close(); // fecha a conexao
        }
    }

    public void editar(Produto produto) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin(); // abre uma transação
            manager.merge(produto); // salva 
            t.commit(); // confirma a transação 

        } catch (Exception e) {
            t.rollback(); // desfaz tudoo
            e.printStackTrace(); //imprime o erro
        } finally {
            manager.close(); // fecha a conexao
        }
    }

    public void excluir(Produto produto) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin();
            Produto e = manager.find(Produto.class, produto.getId());

            // abre uma transação

            manager.remove(e);
        } catch (Exception e) {
            e.printStackTrace();     //imprime o erro
        } finally {
            manager.getTransaction().commit();
            manager.close(); // fecha a conexao
        }
    }

    public Produto buscar(Produto produto) {
        EntityManager manager = fabrica.Fabrica.get().createEntityManager();//
        return manager.find(Produto.class, produto.getId());
    }

    public List<Produto> buscarTodos() {

        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos  
        Query query = manager.createQuery("SELECT e FROM Produto e");
        List<Produto> produtos = query.getResultList();
        return produtos;
    }
}
