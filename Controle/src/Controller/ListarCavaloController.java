package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import Controle.ListarCavalo;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;


public class ListarCavaloController implements Initializable {

    @FXML    private Button btnaualizar;
    @FXML    private Button btncancela;
    @FXML    private Button btndeletar;
    @FXML    private TableColumn<?, ?> clmfrota;
    @FXML    private TableColumn<?, ?> clmid;
    @FXML    private TableColumn<?, ?> clmnome;
    @FXML    private TableColumn<?, ?> clmplaca;
    @FXML    private TableView<?> tabelacavalo;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btncancela.setOnMouseClicked((MouseEvent)->{            
            ListarCavalo.fecharListaCavalo();            
        });
        btncancela.setOnKeyPressed((KeyEvent)->{           
            ListarCavalo.fecharListaCavalo();            
        });
    }

}
