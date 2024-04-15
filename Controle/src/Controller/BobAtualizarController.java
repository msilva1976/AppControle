package Controller;

import java.net.URL;
import java.util.ResourceBundle;

import Controle.AlterarPessoa;

import Controle.BobAtualizar;
import Controle.ListarBobs;
import DAO.BobDAO;
import Model.CadastroBobsModel;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class BobAtualizarController implements Initializable{

    @FXML    private Button btbbobcancelar;
    @FXML    private Button btnatualizar;
    @FXML    private Label lbid;
    @FXML    private TextField txtbobfrota;
    @FXML    private TextField txtbobplaca;
    @FXML    private TextField txtbobtara;
    private static CadastroBobsModel bob2;
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        iniciaBob(bob2.getId());    
        btbbobcancelar.setOnMouseClicked((MouseEvent)->{
            BobAtualizar.fecha();
            ListarBobs.abreListaBob();
        });
        btbbobcancelar.setOnKeyPressed((KeyEvent)->{
            BobAtualizar.fecha();
            ListarBobs.abreListaBob();
        });
        btnatualizar.setOnMouseClicked((MouseEvent)->{
            atualiza();
            
            ListarBobs.fecha();           
            BobAtualizar.AbreAtualizarBob();
        });  
        btnatualizar.setOnKeyPressed((KeyEvent)->{
            atualiza();
           
            ListarBobs.fecha();
            
            BobAtualizar.AbreAtualizarBob();
        });
    }
   
    public void iniciaBob(Long id){
        lbid.setText(bob2.getId().toString());
        txtbobfrota.setText(bob2.getFrota());
        txtbobplaca.setText(bob2.getPlaca());
        txtbobtara.setText(bob2.getTara());
    }
    public void atualiza(){
        Long id = Long.parseLong(lbid.getText());
        String frota = txtbobfrota.getText();
        String placa = txtbobplaca.getText();
        String tara = txtbobtara.getText();
        BobDAO dao = new BobDAO();
        CadastroBobsModel cadastroBobsModel = new CadastroBobsModel(id, frota, placa, tara);
        if (dao.update(cadastroBobsModel)) {
            Alert alert = new Alert(AlertType.CONFIRMATION);
                alert.setHeaderText("Bob atualizado");
                AlterarPessoa.fecha();
                alert.showAndWait();
            } else {
                Alert alert = new Alert(AlertType.ERROR);
                alert.setHeaderText("Usuario não atualizado");
                alert.show();

            }
    }



    public static CadastroBobsModel getBob2() {
        return bob2;
    }
    public static void setBob2(CadastroBobsModel bob2) {
        BobAtualizarController.bob2 = bob2;
    }
    

}