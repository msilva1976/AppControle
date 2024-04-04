package Model;

public class CadastroBobsModel {
    long id;
    String frota;
    String placa;
    String tara;
    public CadastroBobsModel(long id, String frota, String placa, String tara) {
        this.id = id;
        this.frota = frota;
        this.placa = placa;
        this.tara = tara;
    }
    public CadastroBobsModel(String frota, String placa, String tara) {
        this.frota = frota;
        this.placa = placa;
        this.tara = tara;
    }
    public long getId() {
        return id;
    }
    public void setId(long id) {
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
    public void mostausuario(){
        System.out.println("-----------Lista de Bobs----------");
        System.out.println("ID: "+ getId());
        System.out.println("Frota: " +getFrota());
        System.out.println("Placa: "+getPlaca());
        System.out.println("Tara: "+getTara());
        System.out.println("--------------------------------------");

        
    }


    
    
}
