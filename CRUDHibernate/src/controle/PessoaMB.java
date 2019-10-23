/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Banco;
import modelo.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aluno
 */
public class PessoaMB {

    public void inserir(Pessoa pessoa) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("insert into PESSOA (nome, idcidade, rg, cpf) values (?, ?, ?, ?)");
            
            comando.setString(1, pessoa.getNome());
            comando.setString(3, pessoa.getRg());
            comando.setString(4, pessoa.getCpf());
            
            comando.setLong(2, pessoa.getIdcidade());
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }
    }

    public void editar(Pessoa pessoa) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("UPDATE pessoa SET nome = ?, idcidade = ?, rg = ?, cpf = ? WHERE id = ?");
            comando.setString(1, pessoa.getNome());
            comando.setLong(2, pessoa.getIdcidade());
            comando.setString(3, pessoa.getRg());
            comando.setString(4, pessoa.getCpf());
            comando.setInt(5, pessoa.getId());

            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }
    }

    public void excluir(Pessoa pessoa) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("DELETE FROM pessoa WHERE id = ?");
            comando.setInt(1, pessoa.getId());
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }
    }

    public Pessoa buscar(Pessoa pessoa) {
        try {
            Connection conn = Banco.abrirConexao();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM estado WHERE id = ?");
            ps.setInt(1, pessoa.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                pessoa = new Pessoa();                
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setRg(rs.getString("rg"));
                pessoa.setIdcidade(rs.getLong("idcidade"));

            }
        } catch (SQLException ex) {
        }
        return pessoa;
    }

    public List<Pessoa> buscarTodos() {

        List<Pessoa> pessoas = new ArrayList<>();

        try {
            Connection conn = Banco.abrirConexao();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM pessoa");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(rs.getInt("id"));
                pessoa.setNome(rs.getString("nome"));                
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setRg(rs.getString("rg"));
                pessoa.setIdcidade(rs.getLong("idcidade"));
                
                pessoas.add(pessoa);
            }
        } catch (SQLException ex) {
        }
        return pessoas;
    }

}
