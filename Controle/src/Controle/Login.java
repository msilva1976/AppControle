package Controle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Login extends Application{
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage loginsStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Login.fxml"));
        Scene scene = new Scene(root);
        loginsStage.setTitle("Login");
        loginsStage.setScene(scene);
        loginsStage.show();   
        loginsStage.setResizable(false); 
        setStage(loginsStage);   
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Login.stage = stage;
    }

    
    
    
}
