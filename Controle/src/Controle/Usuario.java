package Controle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Usuario extends Application {
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage usuariosStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/Usuario.fxml"));
        Scene scene = new Scene(root);
        usuariosStage.setScene(scene);
        usuariosStage.setTitle("Usuarios");
        usuariosStage.show();
        usuariosStage.setResizable(false);
        setStage(usuariosStage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        Usuario.stage = stage;
    }

    
   
}
