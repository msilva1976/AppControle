package Controller;



import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import Controle.App;
import Controle.CarretaAtualizar;
import Controle.ListarCarreta;
import DAO.CarretaDao;
import Model.CadastroCarretaModel;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;



public class ListarCarretaController implements Initializable {

    @FXML    private Button btnaualizar;
    @FXML    private Button btncancela;
    @FXML    private Button btndeletar;
    @FXML    private TableColumn<CadastroCarretaModel, String> clmcapacidade;
    @FXML    private TableColumn<CadastroCarretaModel, String> clmeixos;
    @FXML    private TableColumn<CadastroCarretaModel, String> clmfrota;
    @FXML    private TableColumn<CadastroCarretaModel, Long> clmid;
    @FXML    private TableColumn<CadastroCarretaModel, String> clmplaca;
    @FXML    private Label lblid;
    @FXML    private Label lbeixo;
    @FXML    private Label lbcapoacidade;
    @FXML    private Label lbfrota;
    @FXML    private Label lbplaca;
    @FXML    private TableView<CadastroCarretaModel> tabelacarreta;
    private CadastroCarretaModel selecionado;
    @SuppressWarnings({ "unchecked", "rawtypes" })
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
      initTabelCarreta();
      
      btncancela.setOnMouseClicked((MouseEvent)->{
        ListarCarreta.getStage().close();
        App.abreApp();
      });
      btncancela.setOnKeyPressed((KeyEvent)->{
        ListarCarreta.getStage().close();
        App.fechar();
      });
      btndeletar.setOnMouseClicked((MouseEvent)->{
        deleta();
      });
      btndeletar.setOnKeyPressed((KeyEvent)->{
        deleta();
      });
      btnaualizar.setOnMouseClicked((MouseEvent)->{
       
        if (selecionado != null) {
          CarretaAtualizar carretaAtualizar = new CarretaAtualizar(selecionado);

          try {
            ListarCarreta.fecha();
            carretaAtualizar.start(new Stage());
          } catch (Exception e) {
            
          }
        } else {
          Alert alert = new Alert(AlertType.WARNING);
          alert.setHeaderText("Selecione uma carreta");
          alert.showAndWait();
          
        }
       
       
      });
      btnaualizar.setOnKeyPressed((KeyEvent)->{
        
        if (selecionado != null) {
          CarretaAtualizar carretaAtualizar = new CarretaAtualizar(selecionado);
          try {
            carretaAtualizar.start(new Stage());
          } catch (Exception e) {
           
          }
        } else {
          Alert alert = new Alert(AlertType.WARNING);
          alert.setHeaderText("Selecione uma carreta");
          alert.show();
                   
          
        }
  
      });
      try {
        tabelacarreta.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {

            @Override
            public void changed(ObservableValue obsvable, Object oldValue, Object newValue) {
              selecionado = (CadastroCarretaModel)newValue;
              selecionado.mostraCarreta();
              mostraDetalhe();
            }
            
          });
    } catch (Exception e) {
       
        e.printStackTrace();
    }
    
    }
    public void initTabelCarreta(){
      clmid.setCellValueFactory(new PropertyValueFactory<>("id"));
      clmfrota.setCellValueFactory(new PropertyValueFactory<>("frota"));
      clmplaca.setCellValueFactory(new PropertyValueFactory<>("placa"));
      clmcapacidade.setCellValueFactory(new PropertyValueFactory<>("capacidade"));
      clmeixos.setCellValueFactory(new PropertyValueFactory<>("eixos"));
      tabelacarreta.setItems(atualizaTabela());
    }
    public ObservableList<CadastroCarretaModel>atualizaTabela() {
      CarretaDao dao = new CarretaDao();
      return FXCollections.observableArrayList(dao.geList());
    
    }
    public static void abriListaCarreta(){
   //   ListarCarreta listarCarreta = new ListarCarreta();
      App.fechar();
      try {
   //     listarCarreta.start(new Stage());
      } catch (Exception e) {
        
      }

    }
    
    public void deleta(){
      if (selecionado != null) {
        CarretaDao dao = new CarretaDao();
        dao.delete(selecionado);
        Alert alert = new Alert(AlertType.CONFIRMATION);
        alert.setHeaderText("Carreta deletada com sucesso!");
        alert.showAndWait();
        tabelacarreta.setItems(atualizaTabela());
      } else {
        Alert alert = new Alert(AlertType.WARNING);
        alert.setHeaderText("Carreta não deletada");
        alert.showAndWait();
      }
    }

    public void mostraDetalhe(){
      if (selecionado != null) {
        lblid.setText(selecionado.getId().toString());
        lbfrota.setText(selecionado.getFrota());
        lbplaca.setText(selecionado.getPlaca());
        lbcapoacidade.setText(selecionado.getCapacidade());
        lbeixo.setText(selecionado.getEixos());
      } else {
        lblid.setText("");
        lbfrota.setText("");
        lbplaca.setText("");
        lbcapoacidade.setText("");
        lbeixo.setText("");        
      }
    }


}