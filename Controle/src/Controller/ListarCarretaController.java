package Controller;



import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.mysql.cj.x.protobuf.MysqlxDatatypes.Scalar.String;

import Controle.App;
import Controle.ListarCarreta;
import DAO.CarretaDao;
import Model.CadastroCarretaModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
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
    @FXML    private TableView<CadastroCarretaModel> tabelacarreta;
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
    
    }
    public void initTabelCarreta(){
      clmid.setCellValueFactory(new PropertyValueFactory<>("id"));
      clmfrota.setCellValueFactory(new PropertyValueFactory<>("frota"));
      clmcapacidade.setCellValueFactory(new PropertyValueFactory<>("capacidade"));
      clmeixos.setCellValueFactory(new PropertyValueFactory<>("eixos"));
      tabelacarreta.setItems(atualizaTabela());
    }
    public ObservableList<CadastroCarretaModel>atualizaTabela() {
      CarretaDao dao = new CarretaDao();
      return FXCollections.observableArrayList(dao.geList());
    
    }
    public static void abriListaCarreta(){
      ListarCarreta listarCarreta = new ListarCarreta();
      App.fechar();
      try {
        listarCarreta.start(new Stage());
      } catch (Exception e) {
        Logger.getLogger(ListarCarretaController.class.getName()).log(Level.SEVERE,null,e);
      }

    }


}