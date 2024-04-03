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
        String sql = "NSERT INTO carretas (frota, placacarreta, capacidade, eixos) VALUES (?,?,?,?);";
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

    public boolean update(CadastroCavaloModel carreta){

        String sql = "UPDATE carretas SET frota = ? , placacarreta = ?, capacidade = ?, eixos = ? WHERE id = ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,carreta.getFrota());
            stmt.setString(2,carreta.getPlaca());
            stmt.setString(3,carreta.getNomeMotorista());
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            Logger.getLogger(CavaloDao.class.getName()).log(Level.SEVERE,null,e);


        
        }
        return false;
    }

/*configuração para deletar um arquivo no banco de dados */
    public boolean delete(CadastroCavaloModel carreta){
    String sql = "DELETE FROM carretas WHERE id = ?;";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1,carreta.getId()); ;        
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
    String sql = "SELECT * carretas ";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet st = stmt.executeQuery();
        while (st.next()) {
            CadastroCavaloModel carreta =  new CadastroCavaloModel(0, sql, sql,sql);
            carreta.setId(st.getLong("id"));
            carreta.setFrota(st.getString("frota"));
            carreta.setPlaca(st.getString("placa"));
            carreta.setNomeMotorista(st.getString("nome motorista"));
            cavaloModels.add(carreta);
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
