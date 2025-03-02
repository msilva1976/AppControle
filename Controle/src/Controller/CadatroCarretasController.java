package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Controle.App;
import Controle.CadastroCarreta;
import DAO.CarretaDao;
import Model.CadastroCarretaModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadatroCarretasController implements Initializable{

    @FXML    private Button btbCadastraCarretaCadastra;
    @FXML    private Button btnCadastraCarretaCancel;
    @FXML    private TextField txtCadastroCarretasCapacidade;
    @FXML    private TextField txtCadastroCarretasEixos;
    @FXML    private TextField txtCadastroCarretasFrota;
    @FXML    private TextField txtCadastroCarretasPlaca;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //confuiguração dos botoẽs
        btnCadastraCarretaCancel.setOnMouseClicked((MouseEvent e)->{
            fecha();
            abreapp();
        });
        btnCadastraCarretaCancel.setOnAction((KeyEvent)->{
            
            fecha();
            abreapp();
        });
       //configurações dos textfield
        txtCadastroCarretasFrota.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                txtCadastroCarretasPlaca.requestFocus();
            }
        });
        txtCadastroCarretasPlaca.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER ) {
                txtCadastroCarretasCapacidade.requestFocus();
            }
        });
        txtCadastroCarretasCapacidade.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() ==  KeyCode.ENTER) {
                txtCadastroCarretasEixos.requestFocus();
            }
        });
        txtCadastroCarretasEixos.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                btbCadastraCarretaCadastra.requestFocus();
            }
        });
       // configuração dos botoẽs 
        btbCadastraCarretaCadastra.setOnMouseClicked((MouseEvent )->{
        cadcarreta();
       });
        btbCadastraCarretaCadastra.setOnKeyPressed((KeyEvent)->{
        cadcarreta();
       });
    }
    public void fecha(){
        CadastroCarreta.getStage().close();
    }
    public void abreapp(){
        App app = new App();
        try {
            app.start(new Stage());
        } catch (Exception e1) {
            Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,e1);
        }

    }
    public void cadcarreta(){
        String frota = txtCadastroCarretasFrota.getText(),
               placa = txtCadastroCarretasPlaca.getText(),
               capacidade = txtCadastroCarretasCapacidade.getText(),
               eixos = txtCadastroCarretasEixos.getText();

        CadastroCarretaModel cadcar = new CadastroCarretaModel(null, frota, placa, capacidade, eixos);
        CarretaDao dao = new CarretaDao();
        if (dao.add(cadcar)) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText("Carreta Cadastrada");    
                abreapp();
                alert.showAndWait();
                fecha();
            }else{
                 Alert alert = new Alert(AlertType.ERROR);
                 alert.setHeaderText("Carreta não cadastrada");
                 alert.showAndWait();
            } 
    }

}