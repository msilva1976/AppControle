package Model;

import java.util.List;

import DAO.CarretaDao;

public class CadastroCarretaModel {
    private Long id;
    private String frota;
    private String placa;
    private String capacidade;
    private String eixos;

    
 
    
    public CadastroCarretaModel(String frota, String placa, String capacidade, String eixos) {
        this.frota = frota;
        this.placa = placa;
        this.capacidade = capacidade;
        this.eixos = eixos;
    }
    public CadastroCarretaModel(Long id, String frota, String placa, String capacidade, String eixos) {
        this.id = id;
        this.frota = frota;
        this.placa = placa;
        this.capacidade = capacidade;
        this.eixos = eixos;
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
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getCapacidade() {
        return capacidade;
    }
    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }
    public String getEixos() {
        return eixos;
    }
    public void setEixos(String eixos) {
        this.eixos = eixos;
    }
    public void mostraCarreta(){
        System.out.println("-----------Lista de Carretas----------");
        System.out.println("ID: "+ getId());
        System.out.println("Frota: " +getFrota());
        System.out.println("Placa: "+getPlaca());
        System.out.println("Capacidade: "+getCapacidade());
        System.out.println("Eixos"+getEixos());
        System.out.println("--------------------------------------");

        
    }
    public static void main(String[] args) {
        CarretaDao dao = new CarretaDao();
        List<CadastroCarretaModel>carreta = dao.geList();
        if (carreta != null) {
            for (int x = 0; x < carreta.size() ; x++) {
                carreta.get(x).mostraCarreta();
            }
        } else {
            System.out.println("lista nula");
        }
    }
    
   


    
    
}
