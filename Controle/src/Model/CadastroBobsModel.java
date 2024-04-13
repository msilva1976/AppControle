package Model;

import java.util.List;



import DAO.BobDAO;

public class CadastroBobsModel {
    Long id;
    String frota;
    String placa;
    String tara;

    
   
    public CadastroBobsModel(String frota, String placa, String tara) {
        this.frota = frota;
        this.placa = placa;
        this.tara = tara;
    }
    public CadastroBobsModel(Long id, String frota, String placa, String tara) {
        this.id = id;
        this.frota = frota;
        this.placa = placa;
        this.tara = tara;
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
    public String getTara() {
        return tara;
    }
    public void setTara(String tara) {
        this.tara = tara;
    }
    public void mostrabob(){
        System.out.println("-----------Lista de Bobs----------");
        System.out.println("ID: "+ getId());
        System.out.println("Frota: " +getFrota());
        System.out.println("Placa: "+getPlaca());
        System.out.println("Tara: "+getTara());
        System.out.println("--------------------------------------");

        
    }
public static void main(String[] args) {
    BobDAO dao = new BobDAO();
    List<CadastroBobsModel>bob = dao.geList();
    if (bob!= null) {
        for(int x=0;x<bob.size();x++){
            bob.get(x).mostrabob();
        }
    } else {
        System.out.println("lista nula");
    }
}


    
    
}
