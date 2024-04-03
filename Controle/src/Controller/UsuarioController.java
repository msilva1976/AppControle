package Controller;


import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import Controle.App;
import Controle.Usuario;
import DAO.UsuarioDAO;
import Model.UsuarioModel;
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

public class UsuarioController implements Initializable {

    @FXML    private Button btbcadastrausuario;
    @FXML    private Button btbcadastrousurariocancela;
    @FXML    private TextField txtcadastrusuarionome;
    @FXML    private TextField txtcadastrusuariosenha;
    @FXML    private TextField txtcadastrusuariousuario;
    @FXML    private TextField txtconfirmasenha;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    //configuração do botão cancelar  
        btbcadastrousurariocancela.setOnMouseClicked ((MouseEvent )->{ 
            fecha();
            abreApp();
           
        });
        btbcadastrousurariocancela.setOnAction((KeyEvent)->{
            fecha();
            abreApp();
        
        });
    //configuração do text field
        txtcadastrusuarionome.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                txtcadastrusuariousuario.requestFocus();
            }
        });
        txtcadastrusuariousuario.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                txtcadastrusuariosenha.requestFocus();
            }
        });
        txtcadastrusuariosenha.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                txtconfirmasenha.requestFocus();
            }
        });
        txtconfirmasenha.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                btbcadastrausuario.requestFocus();
            }
        });
    
        //configuração do botão cadastrar
        btbcadastrausuario.setOnKeyPressed((KeyEvent e)->{
            cadastraUsuario();
        });
        btbcadastrausuario.setOnMouseClicked((MouseEvent e)->{
            caduser();
        });
    }
    public void fecha(){
        Usuario.getStage().close();
    }
    public void abreApp(){
        App app = new App();
        try {
           app.start(new Stage());
       } catch (Exception e) {
           Logger.getLogger(App.class.getName()).log(Level.SEVERE,null,e);
       }

    }
    private void cadastraUsuario(){
        String nome = txtcadastrusuarionome.getText(),
               usuario = txtcadastrusuariousuario.getText(), 
               senha = txtcadastrusuariosenha.getText(),
               confimacao = txtconfirmasenha.getText();

        if (senha.equals(confimacao) == true) {
            UsuarioModel user = new UsuarioModel(nome, usuario, senha);
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.add(user)) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText("Usuario Cadastrado");    
                abreApp();
                alert.showAndWait();
                fecha();
            }else{
                 Alert alert = new Alert(AlertType.ERROR);
                 alert.setHeaderText("Usuario não cadastrado");
                 alert.showAndWait();
            }         
             

        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Senhas não são iguais");
            alert.showAndWait();
        }
      

        
    }
    public void caduser(){
           String nome = txtcadastrusuarionome.getText(),
                  usuario = txtcadastrusuariousuario.getText(),
                  senha = txtcadastrusuariosenha.getText();                         
            UsuarioModel user = new UsuarioModel(nome, usuario, senha);
            UsuarioDAO dao = new UsuarioDAO();
            if (dao.add(user)) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText("Usuario Cadastrado");    
                abreApp();
                alert.showAndWait();
                fecha();
            }else{
                 Alert alert = new Alert(AlertType.ERROR);
                 alert.setHeaderText("Usuario não cadastrado");
                 alert.showAndWait();
            } 

             

    }
}


