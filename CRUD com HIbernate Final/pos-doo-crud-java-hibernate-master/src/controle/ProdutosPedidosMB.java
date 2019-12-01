/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Query;
import modelo.Pedido;
import modelo.Produto;
import modelo.ProdutosPedidos;

/**
 *
 * @author luis
 */
public class ProdutosPedidosMB {

    EntityManager manager;
    ProdutosPedidos produtoPedido = new ProdutosPedidos();
    
    public void inserir(ProdutosPedidos produtoPedido) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin(); // abre uma transação
            manager.persist(produtoPedido); // salva 
            t.commit(); // confirma a transação 

        } catch (Exception e) {
            t.rollback(); // desfaz tudoo
            e.printStackTrace(); //imprime o erro
        } finally {
            manager.close(); // fecha a conexao
        }
    }

    public void editar(ProdutosPedidos produtoPedido) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin(); // abre uma transação
            manager.merge(produtoPedido); // salva 
            t.commit(); // confirma a transação 

        } catch (Exception e) {
            t.rollback(); // desfaz tudoo
            e.printStackTrace(); //imprime o erro
        } finally {
            manager.close(); // fecha a conexao
        }
    }

    public void excluir(ProdutosPedidos produtoPedido) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin();
            ProdutosPedidos e = manager.find(ProdutosPedidos.class, produtoPedido);
            // abre uma transação
            manager.remove(e);
        } catch (Exception e) {
            e.printStackTrace();     //imprime o erro
        } finally {
            manager.getTransaction().commit();
            manager.close(); // fecha a conexao
        }
    }

    public ProdutosPedidos buscar(ProdutosPedidos produtoPedido) {
        EntityManager manager = fabrica.Fabrica.get().createEntityManager();//
        return manager.find(ProdutosPedidos.class, produtoPedido.getId());
    }

    public List<ProdutosPedidos> buscarTodos() {

        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos  
        Query query = manager.createQuery("SELECT e FROM PedidosProdutos e");
        List<ProdutosPedidos> produtoPedidos = query.getResultList();
        return produtoPedidos;
    }
    
    public List<ProdutosPedidos> buscarProdutosPedido(Pedido pedido) {

        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos  
        Query query = manager.createQuery("SELECT e FROM ProdutosPedidos e where pedido_id = "+pedido.getId().toString());
        List<ProdutosPedidos> produtoPedidos = query.getResultList();
        return produtoPedidos;
    }

}
