package Controller;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Controle.App;
import Controle.CadastroBobs;
import DAO.BobDAO;
import Model.CadastroBobsModel;
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

public class CadastroBobController implements Initializable {

    @FXML    private Button btbbobcancelar;
    @FXML    private Button btnbobcadastrar;
    @FXML    private TextField txtbobfrota;
    @FXML    private TextField txtbobplaca;
    @FXML    private TextField txtbobtara;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
       //configuração dos botoes
       btbbobcancelar.setOnMouseClicked((MouseEvent e)->{
        fecha();        
        abreApp();
       });
       btbbobcancelar.setOnAction((KeyEvent )->{
        fecha();
        abreApp();
       });
       //configuração do textfield
       txtbobfrota.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
            txtbobplaca.requestFocus();
        }       
       });
       txtbobplaca.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
            txtbobtara.requestFocus();
        }
       });
       txtbobtara.setOnKeyPressed((KeyEvent e)->{
        if (e.getCode() == KeyCode.ENTER) {
            btnbobcadastrar.requestFocus();
        }
       });
       //configuração dos botões
       btnbobcadastrar.setOnMouseClicked((MouseEvent)->{
        cadasbob();
       });
       btnbobcadastrar.setOnKeyPressed((KeyEvent)->{
        cadasbob();
       });
    }
    
    public void fecha(){
        CadastroBobs.getStage().close();
    }
    public void abreApp(){
        App app = new App();
        try {
            app.start(new Stage());
        } catch (Exception e1) {
            Logger.getLogger(CadastroBobController.class.getName()).log(Level.SEVERE,null,e1);
        }
    }
    public void cadasbob(){
        String frota = txtbobfrota.getText(),
               placa = txtbobplaca.getText(),
               tara = txtbobtara.getText();
        CadastroBobsModel cadbob = new CadastroBobsModel(frota, placa, tara);
        BobDAO dao = new BobDAO();

         if (dao.add(cadbob)) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText("Bobs Cadastrado");    
                abreApp();
                alert.showAndWait();
                fecha();
            }else{
                 Alert alert = new Alert(AlertType.ERROR);
                 alert.setHeaderText("Bobs não cadastrado");
                 alert.showAndWait();
            } 
        
        
    }
}

