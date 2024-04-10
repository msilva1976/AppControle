package Controle;

import java.util.logging.Level;
import java.util.logging.Logger;

import Controller.CadatroCarretasController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadastroCarreta extends Application{
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }
     

    @Override
    public void start(Stage carretaStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/CadastroCarreta.fxml"));
        Scene scene = new Scene(root);
        carretaStage.setTitle("Carretas");
        carretaStage.setScene(scene);
        carretaStage.show();
        carretaStage.setResizable(false);
        setStage(carretaStage);
    }


    public static Stage getStage() {
        return stage;
    }


    public static void setStage(Stage stage) {
        CadastroCarreta.stage = stage;
    }


    public static void abreCarreta(){
        CadastroCarreta abreCarreta = new CadastroCarreta();
        
        try {
            App.fechar();
            abreCarreta.start(new Stage());
            
        } catch (Exception e) {
            Logger.getLogger(CadatroCarretasController .class.getName()).log(Level.SEVERE, null, e);
            
        }
    }
    


    
  
    
}
