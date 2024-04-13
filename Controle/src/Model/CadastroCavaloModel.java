package Model;

import java.util.List;

import DAO.CavaloDao;

public class CadastroCavaloModel {
    Long id;
    String frota;
    String nome;
    String placa;
    

    public CadastroCavaloModel(String frota, String nome, String placa) {
        this.frota = frota;
        this.nome = nome;
        this.placa = placa;
    }
    public CadastroCavaloModel(Long id, String frota, String nome, String placa) {
        this.id = id;
        this.frota = frota;
        this.nome = nome;
        this.placa = placa;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getFrota() {
        return frota;
    }
    public void setFrota(String frota) {
        this.frota = frota;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public void mostraCavalo(){
        System.out.println("-----------Lista de Carretas----------");
        System.out.println("ID: "+ getId());
        System.out.println("Frota: " +getFrota());
        System.out.println("Placa: "+getPlaca());
        System.out.println("Nome do motorista: "+getNome());
        System.out.println("--------------------------------------");

        
    }
    public static void main(String[] args) {
        CavaloDao dao = new CavaloDao();
        List<CadastroCavaloModel>cavalo = dao.geList();
        if (cavalo != null) {
            for (int x=0;x<cavalo.size();x++) {
                cavalo.get(x).mostraCavalo();
            }
        } else {
            System.out.println("lsita nula");
        }
    }

    
    
}
