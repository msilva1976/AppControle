package Controller;



import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controle.App;
import Controle.Login;
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
        if (txtloginuser.getText().equals("msilva") && txtloginpassword.getText().equals("1234")) {
            App principal = new App();
            fecha();
            try {
                principal.start(new Stage());
            } catch (Exception e1) {
                Logger.getLogger(LoginController.class.getName()).log(Level.SEVERE,null,e1);
            }
            
        } else {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setHeaderText("Erro");
            alert.setTitle("Erro de Login");
            alert.setContentText("Erro de Usuario ou Senha");
            alert.showAndWait();
            
        }

    }


}
