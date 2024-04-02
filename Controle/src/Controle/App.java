package Controle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application{
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage appStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/App.fxml"));
        Scene scene = new Scene(root);
        appStage.setTitle("Controle Carretas");
        appStage.setScene(scene);
        appStage.show();
        appStage.setResizable(false);
        setStage(appStage);

    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        App.stage = stage;
    }

    
    
    
}
