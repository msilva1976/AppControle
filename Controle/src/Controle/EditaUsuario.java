package Controle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class EditaUsuario extends Application{

    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage editauserStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/EditaUsuario.fxml"));
        Scene scene = new Scene(root);
        editauserStage.setTitle("Edita Usuario");
        editauserStage.setScene(scene);
        editauserStage.show();
        editauserStage.setResizable(false);
        setStage(editauserStage);
       
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        EditaUsuario.stage = stage;
    }
    
    
}
