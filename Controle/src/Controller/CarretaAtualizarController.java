package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Controle.AlterarPessoa;
import Controle.CarretaAtualizar;
import Controle.ListarCarreta;
import DAO.CarretaDao;
import Model.CadastroCarretaModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class CarretaAtualizarController implements Initializable {

    @FXML    private Button btbatualizar;
    @FXML    private Button btnCadastraCarretaCancel;
    @FXML    private Label lbid;
    @FXML    private TextField txtCadastroCarretasCapacidade;
    @FXML    private TextField txtCadastroCarretasEixos;
    @FXML    private TextField txtCadastroCarretasFrota;
    @FXML    private TextField txtCadastroCarretasPlaca;
    private static CadastroCarretaModel carreta2;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
        iniciaCarreta();

        btnCadastraCarretaCancel.setOnMouseClicked((MouseEvent)->{
            CarretaAtualizar.fechar();
          
           
        });
        btnCadastraCarretaCancel.setOnKeyPressed((KeyEvent)->{
           CarretaAtualizar.fechar();
        });
        btbatualizar.setOnMouseClicked((MouseEvent)->{     
               atualizar();
               ListarCarreta.fecharListaCarreta();
        });
        btbatualizar.setOnKeyPressed((KeyEvent)->{
           atualizar();
           ListarCarreta.fecharListaCarreta();;
     
        });

    
    }
    
    public void iniciaCarreta(){
        lbid.setText(carreta2.getId().toString());
        txtCadastroCarretasFrota.setText(carreta2.getFrota());
        txtCadastroCarretasPlaca.setText(carreta2.getPlaca());
        txtCadastroCarretasCapacidade.setText(carreta2.getCapacidade());
        txtCadastroCarretasEixos.setText(carreta2.getEixos());

    }

    public static CadastroCarretaModel getCarreta2() {
        return carreta2;
    }
    public static void setCarreta2(CadastroCarretaModel carreta2) {
        CarretaAtualizarController.carreta2 = carreta2;
    }
    public void atualizar(){
        Long id = Long.parseLong(lbid.getText());
        String frota =  txtCadastroCarretasFrota.getText();
        String placa =  txtCadastroCarretasPlaca.getText();
        String capacidade = txtCadastroCarretasCapacidade.getText();
        String eixos = txtCadastroCarretasEixos.getText();
            CarretaDao dao = new CarretaDao();
            CadastroCarretaModel cadastroCarretaModel = new CadastroCarretaModel(id, frota, placa, capacidade, eixos);
            if (dao.update(cadastroCarretaModel)) {
                 Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText("Carreta atualizado");
                AlterarPessoa.fecha();
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("Carreta não atualizada");
                alert.show();

            }

    }
    

    
    
}