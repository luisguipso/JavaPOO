/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import dao.GenericDAO;
import modelo.Banco;
import modelo.Cidade;
import modelo.Estado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author aluno
 */
public class CidadeMB {
    private List<Cidade> listaCidade;
    private List<Cidade> listaBuscaCidade;
     
    @Inject
    private GenericDAO<Cidade> daoCidade;
    
    @Inject
    private Cidade cidadeBusca;
    
    
    public CidadeMB(){
        System.out.println("teste inicializador");
        listaCidade = new ArrayList<>();
        listaBuscaCidade = new ArrayList<>();
        //preenche lista de cidades
        preencheListaCidades();
    }
    
    public void preencheListaCidades(){
        listaBuscaCidade = daoCidade.lista(Cidade.class);
    }
    
    public void inserir(Cidade cidade) {
        cidadeBusca = daoCidade.buscarCondicao(Cidade.class, "id = "+cidade.getId().toString());
        if(cidadeBusca != null){
            daoCidade.inserir(cidade);
        }else{
            daoCidade.alterar(cidade);
        }
        
        /*try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("insert into cidade (nome, idestado) values (?, ?)");
            comando.setString(1, cidade.getNome());
            comando.setLong(2, cidade.getIdestado());

            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }*/
    }

    public void editar(Cidade cidade) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("UPDATE cidade SET nome = ?, idestado = ? WHERE id = ?");
            comando.setString(1, cidade.getNome());
            comando.setLong(2, cidade.getIdestado());
            comando.setLong(3, cidade.getId());
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }
    }

    public void excluir(Cidade cidade) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("DELETE FROM cidade WHERE id = ?");
            comando.setLong(1, cidade.getId());
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }
    }

    public List<Cidade> atualizarListaCidades() {
        List<Cidade> cidades = new ArrayList<>();
        try {
            Connection conn = Banco.abrirConexao();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM cidade");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Cidade cidade = new Cidade();
                cidade.setId(rs.getLong("id"));
                cidade.setIdestado(rs.getLong("idestado"));
                cidade.setNome(rs.getString("nome"));
                cidades.add(cidade);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cidades;
    }

    public List<Estado> preencherComboEstados() {
//        Estado estado[] = estado = new Estado[15];
        List<Estado> estados = new ArrayList<>();

        try {
            Connection conn = Banco.abrirConexao();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM estado");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Estado es = new Estado();
                es.setId(rs.getLong("id"));;
                es.setNome(rs.getString("nome"));;

                estados.add(es);
            }

            ps.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return estados;
    }

    public Cidade buscar(Cidade cidade) {
        try {
            Connection conn = Banco.abrirConexao();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM cidade WHERE id = ?");
            ps.setLong(1, cidade.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                cidade = new Cidade();
                cidade.setNome(rs.getString("nome"));
                cidade.setId(rs.getLong("id"));
            }
        } catch (SQLException ex) {
        }
        return cidade;
    }
}
