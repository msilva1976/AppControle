

package Controller;



import java.net.URL;
import java.util.ResourceBundle;

import Controle.App;
import Controle.ListarUsuario;
import DAO.UsuarioDAO;
import Model.UsuarioModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;



public class ListarUsuarioController implements Initializable {

    protected static final UsuarioModel newvalue = null;
    @FXML    private Button btnaualizar;
    @FXML    private Button btncancela;
    @FXML    private Button btndeletar;
    @FXML    private TableColumn<UsuarioModel,String> celmusuario;
    @FXML    private TableColumn<UsuarioModel,String> cldmsenha;
    @FXML    private TableColumn<UsuarioModel,Long> clmid;
    @FXML    private TableColumn<UsuarioModel, String> clmnome;
    @FXML    private TableView<UsuarioModel> tabelausuario;
    private UsuarioModel selecionado;

   
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initTabel();
        btncancela.setOnMouseClicked((MouseEvent)->{
            fechar();
        });
        btncancela.setOnKeyPressed((KeyEvent)->{
            fechar();
        });
        btndeletar.setOnMouseClicked((MouseEvent)->{
            deleta();

        });
        btndeletar.setOnKeyPressed((KeyEvent)->{
            deleta();

        });
        btnaualizar.setOnMouseClicked((KeyEvent)->{

        });
        btnaualizar.setOnMouseClicked((MouseEvent)->{

        });
        tabelausuario.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
               selecionado = (UsuarioModel) newValue;
               selecionado.mostausuario();
            }
            
        });


    
       
    }
    public void fechar(){
        
        App.abreApp();    
        ListarUsuario.getStage().close();
       
        

    }
    public void initTabel(){
        clmid.setCellValueFactory(new PropertyValueFactory<>("id"));
        clmnome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        celmusuario.setCellValueFactory(new PropertyValueFactory<>("usuario"));
        cldmsenha.setCellValueFactory(new PropertyValueFactory<>("senha"));
        tabelausuario.setItems(atualizaTabela());



    }
    public ObservableList<UsuarioModel>atualizaTabela(){
        UsuarioDAO dao = new UsuarioDAO();        
        return FXCollections.observableArrayList(dao.geList()) ;

    }
    public void deleta(){
        if (selecionado != null) {
            UsuarioDAO dao = new UsuarioDAO();
            dao.delete(selecionado);
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("Usuario deletado com sucesso!");
            alert.showAndWait();
            tabelausuario.setItems(atualizaTabela());
        } else {
            Alert alert = new Alert(AlertType.WARNING);
            alert.setHeaderText("Usuario não selecionado");
            alert.showAndWait();
        }
        
    }
    
  
   


}