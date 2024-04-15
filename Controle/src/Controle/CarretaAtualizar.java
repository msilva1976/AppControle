package Controle;


import Controller.CarretaAtualizarController;
import Model.CadastroCarretaModel;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CarretaAtualizar extends Application {
    private static Stage stage;
    

    public CarretaAtualizar(CadastroCarretaModel carreta1) {
        CarretaAtualizarController.setCarreta2(carreta1);
    }


    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage carretaatualizStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/View/CarretaAtualizar.fxml"));
        Scene scene = new Scene(root);
        carretaatualizStage.setTitle("Atualizar Carreta");
        carretaatualizStage.setScene(scene);
        carretaatualizStage.setResizable(false);
        carretaatualizStage.show();
        setStage(carretaatualizStage);

    }

    public static Stage getStage() {
        return stage;
    }

    public static void setStage(Stage stage) {
        CarretaAtualizar.stage = stage;
    }
    public static void abre(){
        CarretaAtualizar carretaAtualizar = new CarretaAtualizar(null);
        try {
            
            carretaAtualizar.start(new Stage());
        } catch (Exception e) {
            
        }
    }
    public static void fechar(){
        CarretaAtualizar.getStage().close();
        ListarCarreta.abreListarCarreta();
    }

}