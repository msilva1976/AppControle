package Controle;

import java.util.logging.Level;
import java.util.logging.Logger;

import Controller.ListarBobsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListarBobs extends Application {
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage listarbobsStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/ListarBobs.fxml"));
        Scene scene = new Scene(root);
        listarbobsStage.setScene(scene);
        listarbobsStage.setTitle("Lista de Cavalos");
        listarbobsStage.setResizable(false);
        listarbobsStage.show();
        setStage(listarbobsStage);
       
    }
    public static Stage getStage() {
        return stage;
    }
    public static void setStage(Stage stage) {
        ListarBobs.stage = stage;
    }
    public static void abreListaBob(){
        ListarBobs listarBobs = new ListarBobs();
        App.fechar();
        try {
            listarBobs.start(new Stage());
        } catch (Exception e) {
            Logger.getLogger(ListarBobsController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public static void fechalistaBob(){
        ListarBobs.getStage().close();
        App.abreApp();
    }
     
}
