package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import Controle.App;
import Controle.ListarCavalo;
import DAO.CavaloDao;

import Model.CadastroCavaloModel;

import javafx.beans.binding.LongBinding;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
public class ListarCavaloController implements Initializable{

    @FXML    private Button btnaualizar;
    @FXML    private Button btncancela;
    @FXML    private Button btndeletar;
    @FXML    private TableColumn<CadastroCavaloModel, String> clmfrota;
    @FXML    private TableColumn<CadastroCavaloModel, LongBinding> clmid;
    @FXML    private TableColumn<CadastroCavaloModel, String> clmnome;
    @FXML    private TableColumn<CadastroCavaloModel, String> clmplaca;
    @FXML    private Label lbid;
    @FXML    private Label lbfrota;
    @FXML    private Label lbnome;
    @FXML    private Label lbplaca;
    @FXML    private TableView<CadastroCavaloModel> tabelacavalo;
    private CadastroCavaloModel selecionado;
    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        initTabel();
        btncancela.setOnMouseClicked((MouseEvent)->{
            fecha();
            App.abreApp();
        });
        btncancela.setOnKeyPressed((KeyEvent)->{
            fecha();
            App.abreApp();
        });
        btndeletar.setOnMouseClicked((MouseEvent)->{
            deleta();
        });
        btndeletar.setOnKeyPressed((KeyEvent)->{
            deleta();
        });
        btndeletar.setOnKeyPressed((KeyEvent)->{
            deleta();
        });

        tabelacavalo.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                selecionado = (CadastroCavaloModel)newValue;
                selecionado.mostraCavalo();
                mostraDetalhe();
               
            }
            
        });
       
    }
    public void fecha(){
        App.abreApp();
        ListarCavalo.getStage().close();
    }
    
    public void initTabel(){
        clmid.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmfrota.setCellValueFactory(new PropertyValueFactory<>("frota"));
        clmplaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
        clmnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tabelacavalo.setItems(atualizaTabela());
    }
      public ObservableList<CadastroCavaloModel>atualizaTabela(){
        CavaloDao dao = new CavaloDao();       
        return FXCollections.observableArrayList(dao.geList()) ;

    }
 
    public void deleta(){
        if (selecionado != null) {
            CavaloDao dao = new CavaloDao();
            dao.delete(selecionado);
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("Cavalo deletado com sucesso!");
            alert.showAndWait();
            tabelacavalo.setItems(atualizaTabela());

        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.showAndWait();
        }
    }
    public void mostraDetalhe(){
        if (selecionado != null) {
            lbid.setText(selecionado.getId().toString());
            lbfrota.setText(selecionado.getFrota());
            lbplaca.setText(selecionado.getPlaca());
            lbnome.setText(selecionado.getNome());
        } else {
            lbid.setText("");
            lbfrota.setText("");
            lbplaca.setText("");
            lbnome.setText("");
            
        }
    }


}
