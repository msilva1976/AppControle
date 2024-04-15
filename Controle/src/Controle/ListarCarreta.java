package Controle;

import java.util.logging.Level;
import java.util.logging.Logger;

import Controller.ListarCarretaController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListarCarreta extends Application {
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage listarcarretStage) throws Exception {
        Parent root = FXMLLoader.load( getClass().getResource("/View/ListarCarreta.fxml"));
        Scene scene = new Scene(root);
        listarcarretStage.setScene(scene);
        listarcarretStage.setTitle("Lista de Carretas");
        listarcarretStage.setResizable(false);
        listarcarretStage.show();;

        setStage(listarcarretStage);
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ListarCarreta.stage = stage;
    }
    public static void abreListarCarreta(){
        ListarCarreta abreListarCarreta =  new ListarCarreta();
        try {
            App.fechar();
            abreListarCarreta.start(new Stage());

        } catch (Exception e) {
            Logger.getLogger(ListarCarretaController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public static void fecharListaCarreta(){
        ListarCarreta.getStage().close();
        
    }
    public static void fecha(){
        ListarCarreta.getStage().close();
    }
    

}
    


