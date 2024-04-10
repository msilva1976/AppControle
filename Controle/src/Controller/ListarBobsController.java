package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import Controle.ListarBobs;
import DAO.BobDAO;
import Model.CadastroBobsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;


public class ListarBobsController implements Initializable {

    @FXML    private Button btnaualizar;
    @FXML    private Button btncancela;
    @FXML    private Button btndeletar;
    @FXML    private TableColumn<CadastroBobsModel, String> clmfrota;
    @FXML    private TableColumn<CadastroBobsModel, Long> clmid;
    @FXML    private TableColumn<CadastroBobsModel, String> clmplaca;
    @FXML    private TableColumn<CadastroBobsModel, String> clmtara;
    @FXML    private TableView<CadastroBobsModel> tabelabob;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTabelBob();
        btncancela.setOnMouseClicked((MouseEvent)->{           
            ListarBobs.fechalistaBob();            
        });
        btncancela.setOnKeyPressed((KeyEvent)->{            
            ListarBobs.fechalistaBob();            
        });
    }
    public void initTabelBob(){
        clmid.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmfrota.setCellValueFactory(new PropertyValueFactory<>("frota"));
        clmplaca.setCellValueFactory(new PropertyValueFactory<>("Placa"));
        clmtara.setCellValueFactory(new PropertyValueFactory<>("tara") );
        tabelabob.setItems(atualizaTabela());

    }
    public ObservableList<CadastroBobsModel>atualizaTabela(){
        BobDAO dao = new BobDAO();
        return FXCollections.observableArrayList(dao.geList());


       

    }

    


}
