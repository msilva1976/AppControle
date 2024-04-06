package Controller;

import java.net.URL;
import java.util.ResourceBundle;


import Controle.ListarBobs;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListarBobsController implements Initializable {

    @FXML    private Button btnaualizar;
    @FXML    private Button btncancela;
    @FXML    private Button btndeletar;
    @FXML    private TableColumn<?, ?> clmfrota;
    @FXML    private TableColumn<?, ?> clmid;
    @FXML    private TableColumn<?, ?> clmplaca;
    @FXML    private TableColumn<?, ?> clmtara;
    @FXML    private TableView<?> tabelabob;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btncancela.setOnMouseClicked((MouseEvent)->{           
            ListarBobs.fechalistaBob();            
        });
        btncancela.setOnKeyPressed((KeyEvent)->{            
            ListarBobs.fechalistaBob();            
        });
    }

}
