package Controle;

import java.util.List;

import DAO.UsuarioDAO;
import Model.UsuarioModel;

public class teste {
    public static void main(String[] args) {
        UsuarioDAO dao = new UsuarioDAO();
        List<UsuarioModel>usuarioModels = dao.geList();
        if (usuarioModels != null) {
            for (int x = 0; x < usuarioModels.size(); x++) {
                usuarioModels.get(x).mostausuario();
                
            }
        }else{
            System.out.println("lista nula");
            

        }

       
    }
}
