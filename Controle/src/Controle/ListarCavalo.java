package Controle;


import java.util.logging.Level;
import java.util.logging.Logger;

import Controller.ListarCavaloController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ListarCavalo extends Application {
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage listarcavaloStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/ListarCavalo.fxml"));
        Scene scene = new Scene(root);
        listarcavaloStage.setTitle("Lista de Cavalos");
        listarcavaloStage.setScene(scene);
        listarcavaloStage.setResizable(false);
        listarcavaloStage.show();
        setStage(listarcavaloStage);
        

    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ListarCavalo.stage = stage;
    }
    public static void abrirListaCavalo(){
        
        ListarCavalo labrirListaCavalo = new ListarCavalo();
        App.fechar();
        try {
            labrirListaCavalo.start(new Stage());
        } catch (Exception e) {
            Logger.getLogger(ListarCavaloController.class.getName()).log(Level.SEVERE, null, e); 
        }    
    }
    public static void fecharListaCavalo(){
        App.abreApp();
        ListarCavalo.getStage().close();
        
    }
    
  
    
    
}
