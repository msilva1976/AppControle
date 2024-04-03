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

import Model.CadastroCavaloModel;

public class CavaloDao {
    private Connection conn;
/*configuração para cadastro das carretas no banco de dados
 */
    public CavaloDao(){
        conn = new ConnectionFactory().getConnection();
    }
    public boolean add(CadastroCavaloModel cavalo){
        String sql = "INSERT INTO cavalo (frota, placa,nomedomotorista) VALUES (?,?,?);";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cavalo.getFrota());
            stmt.setString(2,cavalo.getPlaca());
            stmt.setString(3,cavalo.getNomeMotorista());
            stmt.execute();
            stmt.close();
            conn.close();
            return true;
            
        } catch (SQLException e) {
            Logger.getLogger(CavaloDao.class.getName()).log(Level.SEVERE,null,e);


          //  Logger.getLogger (CarretaDao.class.getName()).log(Level.SEVERE,null,e);
            
        }
        return false;

    }
/* configuração para atualização do banco de dados */  

    public boolean update(CadastroCavaloModel cavalo){

        String sql = "UPDATE cavalo SET frota = ? , placa = ?, nomedomotorista = ? WHERE id = ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,cavalo.getFrota());
            stmt.setString(2,cavalo.getPlaca());
            stmt.setString(3,cavalo.getNomeMotorista());
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            Logger.getLogger(CavaloDao.class.getName()).log(Level.SEVERE,null,e);


        
        }
        return false;
    }

/*configuração para deletar um arquivo no banco de dados */
    public boolean delete(CadastroCavaloModel cavalo){
    String sql = "DELETE FROM cavalo WHERE id = ?;";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1,cavalo.getId()); ;        
        stmt.execute();
        stmt.close();
        conn.close();
        return true  ;        

    } catch (SQLException e) {
       
        Logger.getLogger(CavaloDao.class.getName()).log(Level.SEVERE,null,e);
        return false;
    }
    

}
/*configuração para relatorios do dados do banco */
public List<CadastroCavaloModel>geList(){
    List<CadastroCavaloModel> cavaloModels = new ArrayList<>();
    String sql = "SELECT * cavalo ";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet st = stmt.executeQuery();
        while (st.next()) {
            CadastroCavaloModel cavalo =  new CadastroCavaloModel(0, sql, sql,sql);
            cavalo.setId(st.getLong("id"));
            cavalo.setFrota(st.getString("frota"));
            cavalo.setPlaca(st.getString("placa"));
            cavalo.setNomeMotorista(st.getString("nome motorista"));
            cavaloModels.add(cavalo);
        }
        stmt.close();
        st.close();
        conn.close();
    } catch (Exception e) {
        System.out.println("Erro lista não retornada");
        return null;
        
    }
    
    return cavaloModels;

}
    
}
