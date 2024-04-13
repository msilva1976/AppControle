package Model;

import java.util.List;

import DAO.UsuarioDAO;

public class UsuarioModel {
    private Long id;
    private String nome;
    private String usuario;
    private String senha;
    
   public UsuarioModel(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }
public UsuarioModel(Long id, String nome, String usuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }
public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    /* public UsuarioModel(long id, String nome, String usuario, String senha) {
        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }
    public UsuarioModel(String nome, String usuario, String senha) {
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getUsuario() {
        return usuario;
    }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha) {
        this.senha = senha;
    }
    */
    public void mostausuario(){
        System.out.println("-----------Lista de Usuarios----------");
        System.out.println("ID: "+ getId());
        System.out.println("Nome: " +getNome());
        System.out.println("Usuario: "+getUsuario());
        System.out.println("Senha: "+getSenha());
        System.out.println("--------------------------------------");

        
    }
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
