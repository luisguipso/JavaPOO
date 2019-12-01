/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Cidade;
import modelo.Estado;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**
 *
 * @author aluno
 */
public class CidadeMB {

    EntityManager manager;

    public void inserir(Cidade cidade) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin(); // abre uma transação
            manager.persist(cidade); // salva 
            t.commit(); // confirma a transação 

        } catch (Exception e) {
            t.rollback(); // desfaz tudoo
            e.printStackTrace(); //imprime o erro
        } finally {
            manager.close(); // fecha a conexao
        }
    }

    public void editar(Cidade cidade) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin(); // abre uma transação
            manager.merge(cidade); // salva 
            t.commit(); // confirma a transação 

        } catch (Exception e) {
            t.rollback(); // desfaz tudoo
            e.printStackTrace(); //imprime o erro
        } finally {
            manager.close(); // fecha a conexao
        }
    }

    public void excluir(Cidade cidade) {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos 
        EntityTransaction t = manager.getTransaction();

        try {
            t.begin();
            Cidade c = manager.find(Cidade.class, cidade.getId());

            // abre uma transação

            manager.remove(c);
        } catch (Exception e) {
            e.printStackTrace();     //imprime o erro
        } finally {
            manager.getTransaction().commit();
            manager.close(); // fecha a conexao
        }
    }

    public List<Cidade> atualizarListaCidades() {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos  
        Query query = manager.createQuery("SELECT e FROM Cidade e");
        List<Cidade> cidades = query.getResultList();
        return cidades;
    }

    public List<Estado> preencherComboEstados() {
        manager = fabrica.Fabrica.get().createEntityManager(); // create... chama todos os métodos  
        Query query = manager.createQuery("SELECT e FROM Estado e");
        List<Estado> estados = query.getResultList();
        return estados;
    }

    public Cidade buscar(Cidade cidade) {
        System.out.println("metodo buscar cidade");
        EntityManager manager = fabrica.Fabrica.get().createEntityManager();//
        return manager.find(Cidade.class, cidade.getId());
    }
}
