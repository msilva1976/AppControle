package Controller;



import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controle.App;
import Controle.Login;
import DAO.UsuarioDAO;
import Model.UsuarioModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class LoginController implements Initializable {

    @FXML    private Button btncancel;
    @FXML    private Button btnenter;
    @FXML    private PasswordField txtloginpassword;
    @FXML    private TextField txtloginuser;

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        btnenter.setOnMouseClicked((MouseEvent e)->{
         logar();
        });

        
        btncancel.setOnMouseClicked((MouseEvent e)->{
            fecha();
        });
        btncancel.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                fecha();
            }
        });
        txtloginuser.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                txtloginpassword.requestFocus();
            }
        });
        txtloginpassword.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                btnenter.requestFocus();
            }
        });
        btnenter.setOnKeyPressed((KeyEvent e)->{
            if (e.getCode() == KeyCode.ENTER) {
                logar();
            }
        });
      
    }
    public void fecha(){
        Login.getStage().close();
    }
    public void logar(){
        UsuarioDAO dao = new UsuarioDAO();
        List<UsuarioModel> usuario = dao.geList();
        for (int x = 0; x < usuario.size(); x++) {

            if (txtloginuser.getText().equals(usuario.get(x).getUsuario()) && txtloginpassword.getText().equals(usuario.get(x).getSenha())) {
                App principal = new App();
                x=usuario.size();
                fecha();
                try {
                    principal.start(new Stage());
                } catch (Exception e1) {
                    Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,null,e1);
                }
                
            } else {
                if (x == usuario.size()) {
                    Alert alert = new Alert(AlertType.ERROR);
                    alert.setHeaderText("Erro");
                    alert.setTitle("Erro de Login");
                    alert.setContentText("Erro de Usuario ou Senha");
                    alert.showAndWait();
                }
                  
                
               
                
            }

            
        }

       

      

    }


}
