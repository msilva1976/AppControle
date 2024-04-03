package Controle;

import java.util.List;

import DAO.CarretaDao;
import DAO.UsuarioDAO;
import Model.CadastroCarretaModel;


public class teste {
    public static void main(String[] args) {
        /*UsuarioDAO dao = new UsuarioDAO();
        List<UsuarioModel>usuarioModels = dao.geList();
        if (usuarioModels != null) {
            for (int x = 0; x < usuarioModels.size(); x++) {
                usuarioModels.get(x).mostausuario();
                
            }
        }else{
            System.out.println("lista nula");
            

        }
    */
      CarretaDao dao = new CarretaDao();
        List<CadastroCarretaModel>carretaModels = dao.geList();
        if (carretaModels != null) {
            for (int x = 0; x < carretaModels.size(); x++) {
                carretaModels.get(x).mostraCarreta();;
                
            }
        }else{
            System.out.println("lista nula");
            

        }

       
      /* public static void main(String[] args) {
        UsuarioModel p = new UsuarioModel(null, null, null);
        p.setNome("Jocely marcia");
        p.setUsuario("jmarcia");
        p.setSenha("1234");

        UsuarioDAO dao  = new UsuarioDAO();
        if (dao.add(p)) {
            System.out.println("Cadastrado");
        } else {
            System.out.println("Não Cadastrado");
        }
    } 8?
     /*   CadastroCarretaModel carreta = new CadastroCarretaModel(null, null, null, null);
        carreta.setFrota("1234");
        carreta.setPlacaCarreta("gfh 4575");
        carreta.setCapacidade("65000");
        carreta.setEixos("6");
        
        CarretaDao dao = new CarretaDao();
        if (dao.add(carreta)) {
            System.out.println("Cadastro realizado com sucesso");
        } else {
            System.out.println("Cadastro não realizado");
        }
     
    */
    }
}
