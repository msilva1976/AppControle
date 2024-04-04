package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import JDBC.ConnectionFactory;
import Model.UsuarioModel;

public class UsuarioDAO {
    private Connection conn;

    public UsuarioDAO(){
        this.conn = new ConnectionFactory().getConnection();
    }
    /*public class teste {
    public static void main(String[] args) {
        UsuarioModel p = new UsuarioModel(null, null, null);
        p.setNome("Jocely marcia");
        p.setUsuario("jmarcia");
        p.setSenha("1234");

        UsuarioDAO dao  = new UsuarioDAO();
        if (dao.add(p)) {
            System.out.println("Cadastrado");
        } else {
            System.out.println("Não Cadastrado");
        }
    }
} */
    public boolean add(UsuarioModel p){
        String sql = "INSERT INTO usuarios (nome,usuario,senha) VALUES (?,?,?);";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getUsuario());
            stmt.setString(3,p.getSenha());
            stmt.execute();
            stmt.close();
            conn.close();
            return true  ;        

        } catch (SQLException e) {
           
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            return false;
        }
        

    }
    /*public class teste {
    public static void main(String[] args) {
        UsuarioModel p = new UsuarioModel(0, null, null, null);
        p.setId(6L);
        p.setNome("Jocely marcia");
        p.setUsuario("jmarcia");
        p.setSenha("1234");

        UsuarioDAO dao  = new UsuarioDAO();
        if (dao.update(p)) {
            System.out.println("Atualizado");
        } else {
            System.out.println("Não Atualizado");
        }
    }
} */
    public boolean update(UsuarioModel p){
        String sql = "UPDATE usuarios SET nome = ? , usuario = ?, senha = ? WHERE id = ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, p.getNome());
            stmt.setString(2, p.getUsuario());
            stmt.setString(3,p.getSenha());
            stmt.setLong(4, p.getId());
            stmt.execute();
            stmt.close();
            conn.close();
            return true  ;        

        } catch (SQLException e) {
           
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
            return false;
        }
        

    }
    /*public class teste {
    public static void main(String[] args) {
        UsuarioModel p = new UsuarioModel(0, null, null, null);
        p.setId(6L);
        UsuarioDAO dao  = new UsuarioDAO();
        if (dao.delete(p)) {
            System.out.println("Deletado");
        } else {
            System.out.println("Não Deletado");
        }
    }
} */

public boolean delete(UsuarioModel p){
    String sql = "DELETE FROM usuarios WHERE id = ?;";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1,p.getId()); ;        
        stmt.execute();
        stmt.close();
        conn.close();
        return true  ;        

    } catch (SQLException e) {
       
        Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE,null,e);
        return false;
    }
    

}
/* public class teste {
    public static void main(String[] args) {
        UsuarioModel p = new UsuarioModel(0, null, null, null);
        p.setId(6L);
        UsuarioDAO dao  = new UsuarioDAO();
        if (dao.delete(p)) {
            System.out.println("Deletado");
        } else {
            System.out.println("Não Deletado");
        }
    } */

public List<UsuarioModel>geList(){
    List<UsuarioModel> usuarioModels = new ArrayList<>();
    String sql = "SELECT * FROM usuarios ";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet st = stmt.executeQuery();
        while (st.next()) {
            UsuarioModel p =  new UsuarioModel(0, sql, sql, sql);
            p.setId(st.getLong("id"));
            p.setNome(st.getString("nome"));
            p.setUsuario(st.getString("usuario"));
            p.setSenha(st.getString("senha"));
            usuarioModels.add(p);
        }
        stmt.close();
        st.close();
        conn.close();
    } catch (Exception e) {
        System.out.println("Erro lista não retornada");
        return null;
        
    }
    
    return usuarioModels;

 } 

}

