package Model;

public class CadastroCarretaModel {
    private long id;
    private String frota;
    private String placaCarreta;
    private String capacidade;
    private String eixos;
    public CadastroCarretaModel(long id, String frota, String placaCarreta, String capacidade, String eixos) {
        this.id = id;
        this.frota = frota;
        this.placaCarreta = placaCarreta;
        this.capacidade = capacidade;
        this.eixos = eixos;
    }
    public CadastroCarretaModel(String frota, String placaCarreta, String capacidade, String eixos) {
        this.frota = frota;
        this.placaCarreta = placaCarreta;
        this.capacidade = capacidade;
        this.eixos = eixos;
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
    public String getPlacaCarreta() {
        return placaCarreta;
    }
    public void setPlacaCarreta(String placaCarreta) {
        this.placaCarreta = placaCarreta;
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
        System.out.println("Placa: "+getPlacaCarreta());
        System.out.println("Capacidade: "+getCapacidade());
        System.out.println("Eixos"+getEixos());
        System.out.println("--------------------------------------");

        
    }


    
    
}
