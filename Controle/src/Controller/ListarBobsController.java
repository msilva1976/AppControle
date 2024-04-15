package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;



import Controle.BobAtualizar;
import Controle.ListarBobs;

import DAO.BobDAO;
import Model.CadastroBobsModel;
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
import javafx.stage.Stage;



public class ListarBobsController implements Initializable {

    @FXML    private Button btnaualizar;
    @FXML    private Button btncancela;
    @FXML    private Button btndeletar;
    @FXML    private TableColumn<CadastroBobsModel, String> clmfrota;
    @FXML    private TableColumn<CadastroBobsModel, Long> clmid;
    @FXML    private TableColumn<CadastroBobsModel, String> clmplaca;
    @FXML    private TableColumn<CadastroBobsModel, String> clmtara;
    @FXML    private Label lbid;
    @FXML    private Label lbfrota;
    @FXML    private Label lbplaca;
    @FXML    private Label lbtara;
    @FXML    private TableView<CadastroBobsModel> tabelabob;
    private CadastroBobsModel selecionado;

    @SuppressWarnings({ "rawtypes", "unchecked" })
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTabelBob();
        btncancela.setOnMouseClicked((MouseEvent) -> {
            ListarBobs.fecha();
        });
        btncancela.setOnKeyPressed((KeyEvent) -> {
            ListarBobs.fecha();
        });
        btndeletar.setOnMouseClicked((MouseEvent)->{
            deleta();
        });
        btndeletar.setOnKeyPressed((KeyEvent)->{
            deleta();
        });
        btnaualizar.setOnMouseClicked((MouseEvent)->{
           if (selecionado != null) {
                BobAtualizar atualizar = new BobAtualizar(selecionado);
                
               ListarBobs.fechalistaBob();
                try {
                    atualizar.start(new Stage());
                } catch (Exception e) {
                    Logger.getLogger(ListarUsuarioController.class.getName()).log(Level.SEVERE,null,e);
                }
                
            } else {
                Alert alert = new Alert(AlertType.WARNING);
                alert.setHeaderText("Selecione um usuario");
                alert.showAndWait();
            }
            

        });
        btnaualizar.setOnKeyPressed((KeyEvent)->{
           
            BobAtualizar.AbreAtualizarBob();
            
        });
        tabelabob.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue obsevable, Object oldVAlue, Object newValue) {
               selecionado = (CadastroBobsModel) newValue;
               selecionado.mostrabob();
               mostraDetalhe();

            }
            
        });
    }

    public void initTabelBob() {
        clmid.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmfrota.setCellValueFactory(new PropertyValueFactory<>("frota"));
        clmplaca.setCellValueFactory(new PropertyValueFactory<>("Placa"));
        clmtara.setCellValueFactory(new PropertyValueFactory<>("tara"));
        tabelabob.setItems(atualizaTabela());

    }

    public ObservableList<CadastroBobsModel> atualizaTabela() {
        BobDAO dao = new BobDAO();
        return FXCollections.observableArrayList(dao.geList());

    }

    public void deleta(){
        if (selecionado != null) {
            BobDAO dao = new BobDAO();
            dao.delete(selecionado);
            Alert alert =  new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("Bob deletado com sucesso!");
            alert.showAndWait();
            tabelabob.setItems(atualizaTabela());
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Bob não deletado");
            alert.showAndWait();
        }
    }
    public void mostraDetalhe(){
        if (selecionado != null) {
            lbid.setText(selecionado.getId().toString());
            lbfrota.setText(selecionado.getFrota());
            lbplaca.setText(selecionado.getPlaca());
            lbtara.setText(selecionado.getTara());
        } else {
            lbid.setText("");
            lbfrota.setText("");
            lbplaca.setText("");
            lbtara.setText(""); 
        }
    }
    


}
