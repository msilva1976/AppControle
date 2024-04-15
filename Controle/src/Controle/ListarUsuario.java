package Controle;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.logging.Level;
import java.util.logging.Logger;


import Controller.ListarUsuarioController;

public class ListarUsuario extends Application{

    private static Stage stage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage listaruserStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/ListarUsuario.fxml"));
        Scene scene = new Scene(root);
        listaruserStage.setTitle("Listar de Usuarios");
        listaruserStage.setScene(scene);
        listaruserStage.setResizable(false);
        listaruserStage.show();
        setStage(listaruserStage);

       
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        ListarUsuario.stage = stage;
    }
    public static void fecha(){
        ListarUsuario.getStage().close();
    }
    public static void AbreListarUsuario(){
        ListarUsuario listarUsuario = new ListarUsuario();
        try {
            listarUsuario.start(new Stage());
        } catch (Exception e) {
            Logger.getLogger(ListarUsuarioController.class.getName()).log(Level.SEVERE, null, e);
        }
    } 
    
    
    
}
