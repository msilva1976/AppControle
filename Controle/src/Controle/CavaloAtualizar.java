package Controle;


import java.util.logging.Level;
import java.util.logging.Logger;

import Controller.CavaloAtualizarController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class CavaloAtualizar extends Application{
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage cavaloatualizStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/CavaloAtualizar.fxml"));
        Scene scene = new Scene(root);
        cavaloatualizStage.setTitle("Atualiza ccavalo");
        cavaloatualizStage.setScene(scene);
        cavaloatualizStage.setResizable(false);
        cavaloatualizStage.show();
        setStage(cavaloatualizStage);   
    }
    public static Stage getStage() {
        return stage;
    }
    public static void setStage(Stage stage) {
        CavaloAtualizar.stage = stage;
    }
    public static void fecha(){
        CavaloAtualizar.getStage().close();
    }
    public static void Abre(){
        ListarCavalo.fecharListaCavalo();
        CavaloAtualizar cavaloAtualizar = new CavaloAtualizar();
        try {
            cavaloAtualizar.start(getStage());
        } catch (Exception e) {
            Logger.getLogger(CavaloAtualizarController.class.getName()).log(Level.SEVERE,null, e);
        }
    }
    
}
