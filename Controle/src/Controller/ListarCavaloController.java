package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import Controle.ListarCavalo;

import DAO.CavaloDao;

import Model.CadastroCavaloModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ListarCavaloController implements Initializable {

    @FXML    private Button btnaualizar;
    @FXML    private Button btncancela;
    @FXML    private Button btndeletar;
    @FXML    private TableColumn<CadastroCavaloModel, String> clmfrota;
    @FXML    private TableColumn<CadastroCavaloModel, Long> clmid;
    @FXML    private TableColumn<CadastroCavaloModel, String> clmnome;
    @FXML    private TableColumn<CadastroCavaloModel, String> clmplaca;
    @FXML    private TableView<CadastroCavaloModel> tabelacavalo;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTabela();
       
      
        btncancela.setOnMouseClicked((MouseEvent)->{            
            ListarCavalo.fecharListaCavalo();            
        });
        btncancela.setOnKeyPressed((KeyEvent)->{           
            ListarCavalo.fecharListaCavalo();            
        });
    }

   public void initTabela(){
        clmid.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmfrota.setCellValueFactory(new PropertyValueFactory<>("frota"));
        clmnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        clmplaca.setCellValueFactory(new PropertyValueFactory<>("placa"));        
        tabelacavalo.setItems(atualizaTabela());
    }
  
    public ObservableList<CadastroCavaloModel>atualizaTabela(){
        CavaloDao dao = new CavaloDao();
        return FXCollections.observableArrayList(dao.geList());


       

    }



}
