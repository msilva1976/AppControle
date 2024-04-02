package Controle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadastroBobs extends Application{
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage bobStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("../View/CadastroBobs.fxml"));
        Scene scene = new Scene(root);
        bobStage.setScene(scene);
        bobStage.setTitle("Bobs");
        bobStage.show();
        bobStage.setResizable(false);
        setStage(bobStage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        CadastroBobs.stage = stage;
    }

   
    

    
    
}
