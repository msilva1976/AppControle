package Controle;


import java.util.logging.Level;
import java.util.logging.Logger;
import Controller.AppController;
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
    public static void abreApp(){
        App app = new App();
        try {
            app.start(new Stage());
        } catch (Exception e) {
            Logger.getLogger(AppController.class.getName()).log(Level.SEVERE, null, e);
            e.printStackTrace();
        }
     
    }
    public static void fechar(){
        App.getStage().close();
    }
    
    
    
    
}
