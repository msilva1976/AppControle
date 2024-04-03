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
import Model.CadastroCarretaModel;



public class CarretaDao {
    private Connection conn;
/*configuração para cadastro das carretas no banco de dados
 */
    public CarretaDao(){
        conn = new ConnectionFactory().getConnection();
    }
    public boolean add(CadastroCarretaModel carreta){
        String sql = "INSERT INTO carretas (frota, placacarreta, capacidade, eixos) VALUES (?,?,?,?);";
        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,carreta.getFrota());
            stmt.setString(2,carreta.getPlacaCarreta());
            stmt.setString(3,carreta.getCapacidade());
            stmt.setString(4,carreta.getEixos());
            stmt.execute();
            stmt.close();
            conn.close();
            return true;
            
        } catch (SQLException e) {
            Logger.getLogger(CarretaDao.class.getName()).log(Level.SEVERE,null,e);
            
        }
        return false;

    }
/* configuração para atualização do banco de dados */  

    public boolean update(CadastroCarretaModel carreta){

        String sql = "UPDATE carretas SET frota = ? , placacarreta = ?, capacidade = ?, eixos = ? WHERE id = ?;";

        try {
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1,carreta.getFrota());
            stmt.setString(2,carreta.getPlacaCarreta());
            stmt.setString(3,carreta.getCapacidade());
            stmt.setString(5,carreta.getEixos());
            stmt.execute();
            stmt.close();
            conn.close();
        } catch (Exception e) {
            Logger.getLogger(CarretaDao.class.getName()).log(Level.SEVERE,null,e);


        
        }
        return false;
    }

/*configuração para deletar um arquivo no banco de dados */
    public boolean delete(CadastroCarretaModel carreta){
    String sql = "DELETE FROM carretas WHERE id = ?;";

    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setLong(1,carreta.getId()); ;        
        stmt.execute();
        stmt.close();
        conn.close();
        return true  ;        

    } catch (SQLException e) {
       
        Logger.getLogger(CarretaDao.class.getName()).log(Level.SEVERE,null,e);
        return false;
    }
    

}
/*configuração para relatorios do dados do banco */
public List<CadastroCarretaModel>geList(){
    List<CadastroCarretaModel> carretasModels = new ArrayList<>();
    String sql = "SELECT * carretas ";
    try {
        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet st = stmt.executeQuery();
        while (st.next()) {
            CadastroCarretaModel carreta =  new CadastroCarretaModel(0, sql, sql, sql,sql);
            carreta.setId(st.getLong("id"));
            carreta.setFrota(st.getString("frota"));
            carreta.setPlacaCarreta(st.getString("placa"));
            carreta.setCapacidade(st.getString("capacidade"));
            carreta.setEixos(st.getString("eixo"));
            carretasModels.add(carreta);
        }
        stmt.close();
        st.close();
        conn.close();
    } catch (Exception e) {
        System.out.println("Erro lista não retornada");
        return null;
        
    }
    
    return carretasModels;

}
    
}
