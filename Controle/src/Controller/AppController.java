package Controller;

import java.net.URL;

import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import Controle.App;
import Controle.CadastroBobs;
import Controle.CadastroCarreta;
import Controle.CadastroCavalo;
import Controle.ListarBobs;
import Controle.ListarCarreta;
import Controle.ListarCavalo;
import Controle.ListarUsuario;
import Controle.Usuario;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

public class AppController implements Initializable {

    @FXML    private Menu menuarquivo;
    @FXML    private MenuItem menucadastrabobs;
    @FXML    private MenuItem menucadastracarretas;
    @FXML    private MenuItem menucadastracavalos;
    @FXML    private MenuItem menucadastrasair;
    @FXML    private MenuItem menucadastrausuarios;
    @FXML    private Menu menucadastro;
    @FXML    private MenuItem menucadastrobobs;
    @FXML    private MenuItem menucadastrocarretas;
    @FXML    private MenuItem menucadastrocavalos;
    @FXML    private MenuItem menucadastrousuaris;
    @FXML    private Menu menueditar;
    @FXML    private MenuItem menueditarbobs;
    @FXML    private MenuItem menueditarcarretas;
    @FXML    private MenuItem menueditarcavalos;
    @FXML    private MenuItem menueditarusuarios;
    @FXML    private MenuBar menuprincipal;
    @FXML    private Menu menusobre;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // menu sair do sistema
        menucadastrasair.setOnAction((MouseEvent) -> {
            fechar();
        });
        // menu para cadastro de carretas
        menucadastracarretas.setOnAction((MouseEvent) -> {
           CadastroCarreta.abreCarreta();
        });
        menucadastrocarretas.setOnAction((KeyEvent) -> {
            CadastroCarreta.abreCarreta();
        });
        // menu para cadastro de cavalos
        menucadastracavalos.setOnAction((MouseEvent) -> {
           abrecavalo();
        });
        menucadastracavalos.setOnAction((KeyEvent) -> {
          abrecavalo();
        });
        // menu para cadastro de bobs
        menucadastrabobs.setOnAction((MouseEvent) -> {
           abrebob();
        });
        menucadastrabobs.setOnAction((KeyEvent) -> {
           abrebob();
        });
        //menu cadastro usuarios
        menucadastrausuarios.setOnAction((MouseEvent)->{
           abreuser();              
        });
        menucadastrausuarios.setOnAction((KeyEvent)->{
         abreuser();
        });
        // menu edita usuario
        menueditarusuarios.setOnAction((MouseEvent)->{
            listaruser();
        });
        //configuraçõe do menu editar
        menueditarusuarios.setOnAction((KeyEvent)->{
          listaruser();
       });
        menueditarcavalos.setOnAction((MouseEvent)->{
           ListarCavalo.abrirListaCavalo();
        });
        menueditarcavalos.setOnAction((KeyEvent)->{
           ListarCavalo.abrirListaCavalo();
        });
       menueditarcarretas.setOnAction((MouseEvent)->{
            ListarCarreta.abreListarCarreta();
        });
       menueditarcarretas.setOnAction((KeyEvent)->{
            ListarCarreta.abreListarCarreta();
        });
        menueditarbobs.setOnAction((MouseEvent)->{
            ListarBobs.abreListaBob();
        });
        menueditarbobs.setOnAction((KeyEvent)->{
            ListarBobs.abreListaBob();
        });
    }


    public void fechar() {
        App.getStage().close();
    }
    public void abreuser (){
        Usuario user =  new Usuario();
        fechar();
        try {
            user.start(new Stage());                
        } catch (Exception e) {
            Logger.getLogger(UsuarioController.class.getName()).log(Level.SEVERE,null,e);
        }

    }
    public void abrebob(){
        CadastroBobs bobs = new CadastroBobs();
        fechar();
        try {
            bobs.start(new Stage());
        } catch (Exception e) {
            Logger.getLogger(CadastroBobController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    public void abrecavalo(){
        CadastroCavalo cavalo = new CadastroCavalo();
        fechar();
        try {
            cavalo.start(new Stage());
        } catch (Exception e) {
            Logger.getLogger(CadastroCavaloController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
  
    public void listaruser(){
        ListarUsuario listaruser = new ListarUsuario();
        fechar();
        try {
            listaruser.start(new Stage());

        } catch (Exception e) {
            Logger.getLogger(ListarUsuarioController.class.getName()).log(Level.SEVERE, null, e);
        }
    }
  


    
}
