package Controller;



import java.net.URL;
import java.util.ResourceBundle;


import Controle.ListarCarreta;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class ListarCarretaController implements Initializable{

    @FXML    private Button btnaualizar;
    @FXML    private Button btncancela;
    @FXML    private Button btndeletar;
    @FXML    private TableColumn<?, ?> clmcapacidade;
    @FXML    private TableColumn<?, ?> clmeixos;
    @FXML    private TableColumn<?, ?> clmfrota;
    @FXML    private TableColumn<?, ?> clmid;
    @FXML    private TableColumn<?, ?> clmplaca;
    @FXML    private TableView<?> tabelacarreta;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btncancela.setOnMouseClicked((MouseEvent)->{
            ListarCarreta.fecharListaCarreta();
            
        });
        btncancela.setOnKeyPressed((KeyEvent)->{
            ListarCarreta.fecharListaCarreta();
            
        });
    }

}
