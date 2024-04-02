package Controle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CadastroCavalo extends Application{

    private static Stage stage;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage cavaloStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/CadastroCavalo.fxml"));
        Scene scene = new Scene(root);
        cavaloStage.setScene(scene);
        cavaloStage.setTitle("Cavalo");
        cavaloStage.show();
        cavaloStage.setResizable(false);
        setStage(cavaloStage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        CadastroCavalo.stage = stage;
    }

    
    
}
