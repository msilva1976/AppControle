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
import Model.CadastroBobsModel;

public class BobDAO{
    private Connection conn;
/*configuração para cadastro das carretas no banco de dados
 */
    public BobDAO(){
        conn = new ConnectionFactory().getConnection();
    }
    public boolean add(CadastroBobsModel bobs){
        String sql = "INSERT INTO bobs (frota, placa,tara ) VALUES (?,?,?);";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,bobs.getFrota().toUpperCase());
            stmt.setString(2,bobs.getPlaca().toUpperCase());
            stmt.setString(3,bobs.getTara());
            stmt.execute();
            stmt.close();
            conn.close();
                    
            return true;
            
        } catch (SQLException e) {
            Logger.getLogger(BobDAO.class.getName()).log(Level.SEVERE,null, e); 
            
        }
        return false;

    }
/* configuração para atualização do banco de dados */  

    public boolean update(CadastroBobsModel bobs){

        String sql = "UPDATE bobs SET frota = ?, placa = ?, tara = ? ) WHERE id = ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,bobs.getFrota().toUpperCase());
            stmt.setString(2,bobs.getPlaca().toUpperCase());
            stmt.setString(3,bobs.getTara());
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            Logger.getLogger(BobDAO.class.getName()).log(Level.SEVERE,null,e);


        
        }
        return false;
    }

/*configuração para deletar um arquivo no banco de dados */
    public boolean delete(CadastroBobsModel bobs){
    String sql = "DELETE FROM bobs WHERE id = ?;";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1,bobs.getId()); ;        
        stmt.execute();
        stmt.close();
        conn.close();
        return true  ;        

    } catch (SQLException e) {
       
        Logger.getLogger(BobDAO.class.getName()).log(Level.SEVERE,null,e);
        return false;
    }
    

}
/*configuração para relatorios do dados do banco */
public List<CadastroBobsModel>geList(){
    List<CadastroBobsModel> bobsModels = new ArrayList<>();
    String sql = "SELECT * FROM bobs ";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet st = stmt.executeQuery();
        while (st.next()) {
            CadastroBobsModel carreta =  new CadastroBobsModel(null, sql, sql, sql);
            carreta.setId(st.getLong("id"));
            carreta.setFrota(st.getString("frota"));
            carreta.setPlaca(st.getString("placa"));
            carreta.setTara(st.getString("tara"));
            bobsModels.add(carreta);
        }
        stmt.close();
        st.close();
        conn.close();
    } catch (Exception e) {
        System.out.println("Erro lista não retornada");
        return null;
        
    }
    
    return bobsModels;

}
    
}
