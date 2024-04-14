package Controle;

import java.util.logging.Level;
import java.util.logging.Logger;

import Controller.BobAtualizarController;
import Model.CadastroBobsModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class BobAtualizar extends Application{
    private static Stage stage;

    public BobAtualizar(CadastroBobsModel bob1) {
        BobAtualizarController.setBob2(bob1);
    }


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage bobatuStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/BobAtualizar.fxml"));
        Scene scene = new Scene(root);
        bobatuStage.setTitle("Atualizar Bobs");
        bobatuStage.setScene(scene);
        bobatuStage.setResizable(false);
        bobatuStage.show();
        setStage(bobatuStage);
    }
    public static Stage getStage() {
        return stage;
    }
    public static void setStage(Stage stage) {
     BobAtualizar.stage = stage;
    }
    public static void fecha(){
        BobAtualizar.getStage().close();
        }  

    public static void AbreAtualizarBob(){
        BobAtualizar atualizar = new BobAtualizar(null);
        try {
            ListarBobs.fechalistaBob();
            atualizar.start(new Stage());
        } catch (Exception e) {
            Logger.getLogger(BobAtualizarController.class.getName()).log(Level.SEVERE,null,e);
            
        }
    }
    

    
}
