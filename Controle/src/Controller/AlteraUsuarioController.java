package Controller;

import java.net.URL;
import java.util.ResourceBundle;



import Controle.AlterarPessoa;
import Controle.App;
import Controle.ListarUsuario;
import DAO.UsuarioDAO;
import Model.UsuarioModel;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;



public class AlteraUsuarioController implements Initializable{

    @FXML    private Button btbatualizar;
    @FXML    private Button btbcadastrousurariocancela;
    @FXML    private Label lbid;
    @FXML    private TextField txtcadastrusuarionome;
    @FXML    private TextField txtcadastrusuariosenha;
    @FXML    private TextField txtcadastrusuariousuario;
    @FXML    private TextField txtconfirmasenha;
    private static UsuarioModel usuario2;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        iniciaPessoa(usuario2.getId());
        btbcadastrousurariocancela.setOnMouseClicked((MouseEvent)->{
            AlterarPessoa.fecha();
            App.abreApp();
        });
        btbcadastrousurariocancela.setOnKeyPressed((KeyEvent)->{
            AlterarPessoa.fecha();
            App.abreApp();
        });
        btbatualizar.setOnMouseClicked((MouseEvent)->{
            atualizar();
            AlterarPessoa.fecha();
            ListarUsuario.AbreListarUsuario();
         
           
        });
        btbatualizar.setOnKeyPressed((KeyEvent)->{
            atualizar();
            AlterarPessoa.fecha();
            ListarUsuario.AbreListarUsuario();
           
            
           
        });   
    }
    public void iniciaPessoa(long id){
            
            lbid.setText(usuario2.getId().toString());            
            txtcadastrusuarionome.setText(usuario2.getNome());
            txtcadastrusuariousuario.setText(usuario2.getUsuario());
            txtcadastrusuariosenha.setText(usuario2.getSenha());
            txtconfirmasenha.setText(usuario2.getSenha());

    
    }
    public static UsuarioModel getUsuario2() {
        return usuario2;
    }
    public static void setUsuario2(UsuarioModel usuario2) {
        AlteraUsuarioController.usuario2 = usuario2;
    }
    public void atualizar(){
        
        Long id = Long.parseLong(lbid.getText());
        String nome = txtcadastrusuarionome.getText();        
        String usuario = txtcadastrusuariousuario.getText();        
        String senha = txtcadastrusuariosenha.getText();
        String confirma = txtconfirmasenha.getText();
        if (senha.equals(confirma)) {
            UsuarioDAO dao = new UsuarioDAO();
            UsuarioModel usuarioModel = new UsuarioModel(id,nome, usuario, senha);
            if (dao.update(usuarioModel)) {
                Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText("Usuario alterado");
                AlterarPessoa.fecha();
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("Usuario não alterado");
                alert.show();
                
            }
        } else {
            Alert alert =  new Alert(AlertType.ERROR);
            alert.setHeaderText("Senhas não coincidem ");
            alert.showAndWait();
        }
        
    }
    
   
  
   

}
