package Controle;



import java.util.logging.Level;
import java.util.logging.Logger;

import Controller.CarretaAtualizarController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class CarretaAtualizar extends Application {
    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage carretaatualStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/CarretaAtualizar.fxml"));
        Scene scene = new Scene(root);
        carretaatualStage.setTitle("Atualizar Carreta");
        carretaatualStage.setScene(scene);
        carretaatualStage.setResizable(false);
        carretaatualStage.show();
        setStage(carretaatualStage);    
    }
    public static Stage getStage() {
        return stage;
    }
    public static void setStage(Stage stage) {
        CarretaAtualizar.stage = stage;
    }
    public static void fecha(){
        CarretaAtualizar.getStage().close();
    }
    public static void Abrea(){
        CarretaAtualizar carretaAtualizar = new CarretaAtualizar();
        try {
            ListarCarreta.fecharListaCarreta();
            carretaAtualizar.start(new Stage());
        } catch (Exception e) {
            Logger.getLogger(CarretaAtualizarController.class.getName()).log(Level.SEVERE,null,e);
            
        }

    }
    
    


     
}