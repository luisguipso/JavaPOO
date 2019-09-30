/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controle;

import modelo.Banco;
import modelo.Estado;
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
public class EstadoMB {

    public void inserir(Estado estado) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("insert into estado (sigla, nome) values (?, ?)");
            comando.setString(1, estado.getSigla());
            comando.setString(2, estado.getNome());
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }
    }

    public void editar(Estado estado) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("UPDATE estado SET nome = ?, sigla = ? WHERE id = ?");
            comando.setString(1, estado.getNome());
            comando.setString(2, estado.getSigla());
            comando.setInt(3, estado.getId());
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }
    }

    public void excluir(Estado estado) {
        try {
            Connection conexao = Banco.abrirConexao();

            PreparedStatement comando = conexao.prepareStatement("DELETE FROM estado WHERE id = ?");
            comando.setInt(1, estado.getId());
            comando.executeUpdate();
            comando.close();
            conexao.close();
        } catch (SQLException ex) {

        }
    }

    public Estado buscar(Estado estado) {
//        Estado es = new Estado();
        try {
            Connection conn = Banco.abrirConexao();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM estado WHERE id = ?");
            ps.setInt(1, estado.getId());
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                estado = new Estado();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));

            }
        } catch (SQLException ex) {
        }
        return estado;
    }

    public List<Estado> buscarTodos() {
        List<Estado> estados = new ArrayList<>();

        try {
            Connection conn = Banco.abrirConexao();
            PreparedStatement ps = conn.prepareStatement("SELECT * FROM estado");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Estado estado = new Estado();
                estado.setId(rs.getInt("id"));
                estado.setNome(rs.getString("nome"));
                estado.setSigla(rs.getString("sigla"));
                estados.add(estado);
            }
        } catch (SQLException ex) {
        }
        return estados;
    }
}
