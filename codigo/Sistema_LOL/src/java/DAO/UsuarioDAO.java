/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import Entidades.Usuario;

/**
 *
 * @author victor
 */

public class UsuarioDAO {
    
    
    private Connection connection;
    private PreparedStatement stmtAdiciona;

    public UsuarioDAO() throws SQLException, ClassNotFoundException {
        //this.connection = DriverManager.getConnection("jdbc:mysql://localhost/exercicio", "root", "");
        this.connection = ConnectionFactory.getConnection();
        this.stmtAdiciona = connection.prepareStatement("insert into usuario (nome,senha) values (?,?)", Statement.RETURN_GENERATED_KEYS);
    }   
    
    public void adiciona(Usuario usuario) {
        //String sql = "insert into contatos (nome,email,endereco,dataNascimento) values (?,?,?,?)";
        try {
            // prepared statement para inserÃ§Ã£o
            //PreparedStatement stmt = connection.prepareStatement(sql);
            // seta os valores
            stmtAdiciona.setString(1, usuario.getNome());
            stmtAdiciona.setString(2, usuario.getSenha());
            // executa
            stmtAdiciona.execute();
            //Seta o id do contato
            ResultSet rs = stmtAdiciona.getGeneratedKeys();
            rs.next();
            Integer i;
            i = rs.getInt(1);
            usuario.setId(i);
            
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
    }

    public List<Usuario> getLista() throws SQLException{
        ResultSet rs = null;
        PreparedStatement stmtLista = this.connection.prepareStatement("select * from usuario");
        try {
            rs = stmtLista.executeQuery();
            List<Usuario> listaUsuarios = new ArrayList();
            while (rs.next()) {
                // criando o objeto Contato
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setSenha(rs.getString("senha"));
                // adicionando o objeto Ã  lista
                listaUsuarios.add(usuario);
            }
            
            return listaUsuarios;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally{
            rs.close();
            stmtLista.close();
        }

    }


    public void atualiza(Usuario usuario) throws SQLException{
        PreparedStatement stmtAtualiza = this.connection.prepareStatement("update usuario set nome=?, senha=? WHERE id=?;");
        try {
            stmtAtualiza.setString(1, usuario.getNome());
            stmtAtualiza.setString(2, usuario.getSenha());
            stmtAtualiza.setLong(5, usuario.getId());
            stmtAtualiza.executeUpdate();
        } finally{
            stmtAtualiza.close();
        }

    }

    public void excluir(Usuario usuario) throws SQLException {
        PreparedStatement stmtExcluir = this.connection.prepareStatement("delete from usuario WHERE id=?;");
        try {
            stmtExcluir.setLong(1, usuario.getId());
            stmtExcluir.executeUpdate();
        } finally{
            stmtExcluir.close();
        }

    }
    
    
    public Usuario autenticar(Usuario usuario) throws Exception{
       Usuario usuarioSessao = new Usuario();
        try {
            PreparedStatement statement = connection.prepareStatement("select nome,senha,perfil,id from usuario where nome=? and senha=?");
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSenha());
            ResultSet result = statement.executeQuery();
            if (result.next()) {
                
                usuarioSessao.setId(result.getInt("id"));
                usuarioSessao.setNome(result.getString("nome"));
                usuarioSessao.setSenha(result.getString("senha"));
                usuarioSessao.setPerfil(result.getInt("perfil"));
                
            } else {
                System.out.println("Invalid username or password!");
            }
        } catch (Exception e) {
            System.out.println("DB related Error");
            e.printStackTrace();
        }
        return usuarioSessao;

    }
   
}
