package Controle;



import java.util.logging.Level;
import java.util.logging.Logger;
import Controller.AlteraUsuarioController;
import Controller.ListarUsuarioController;
import Model.UsuarioModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class AlterarPessoa extends Application{
    private static Stage stage;


    public AlterarPessoa(UsuarioModel usuario1) {
        AlteraUsuarioController.setUsuario2(usuario1);
    }
    





 

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage alterStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/AlteraUsuario.fxml"));
        Scene scene =  new Scene(root);
        alterStage.setTitle("Alterar Usuario");
        alterStage.setScene(scene);
        alterStage.setResizable(false);
        alterStage.show();
        setStage(alterStage);
      
    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        AlterarPessoa.stage = stage;
    }

    public static void fecha(){
        AlterarPessoa.getStage().close();
        
    }


    
    public static void AbreAlterarPessoa(){
        AlterarPessoa alterarPessoa = new AlterarPessoa(null);
        try {
            ListarUsuario.fecha();
            alterarPessoa.start(new Stage());
        } catch (Exception e) {
             Logger.getLogger(ListarUsuarioController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public static void AtualizaFecha(){
        
        

    }

    
}
