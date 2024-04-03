package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Controle.App;
import Controle.CadastroCavalo;
import DAO.CavaloDao;
import Model.CadastroCavaloModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class CadastroCavaloController implements Initializable{

    @FXML    private Button btnCavaloCancel;
    @FXML    private Button btnCavaloRegister;
    @FXML    private TextField txtCavaloFrota;
    @FXML    private TextField txtCavaloNomeMotorista;
    @FXML    private TextField txtCavaloPlaca;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //configurações dos botões 
        btnCavaloCancel.setOnMouseClicked((MouseEvent e)->{
            fecha();
            abreApp();
        });
        btnCavaloCancel.setOnKeyPressed((KeyEvent)->{
            fecha();
            abreApp();
         
        });
        //configurações dos texfield
        txtCavaloFrota.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                txtCavaloPlaca.requestFocus();
            }
        });
        txtCavaloPlaca.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                txtCavaloNomeMotorista.requestFocus();
            }
        });
        txtCavaloNomeMotorista.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                btnCavaloRegister.requestFocus();
            }
        });
        //configuração dos botões
        btnCavaloRegister.setOnKeyPressed((KeyEvent)->{
            cadcavalo();
        });
        btnCavaloRegister.setOnMouseClicked((MouseEvent)->{
            cadcavalo();
        });
    }
    public void fecha(){
        CadastroCavalo.getStage().close();
    }
    public void abreApp(){
        App app = new App();
        try {
           app.start(new Stage());
       } catch (Exception e1) {
           Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,e1);
       }
    }
    public void cadcavalo(){
        String frota = txtCavaloFrota.getText(),
               placa = txtCavaloPlaca.getText(),
               nomeMotorista = txtCavaloNomeMotorista.getText();
        CadastroCavaloModel cadcav = new CadastroCavaloModel(frota, nomeMotorista, placa);
        CavaloDao dao = new CavaloDao();
        if (dao.add(cadcav)) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
            alert.setHeaderText("Cavalo Cadastrado");
            abreApp();
            alert.showAndWait();
            fecha();
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Cavalo não cadastrado");
            alert.showAndWait();            
        } 
    }

}