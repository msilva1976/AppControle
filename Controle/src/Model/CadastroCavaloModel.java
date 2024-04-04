package Model;

public class CadastroCavaloModel {
    long id;
    String frota;
    String nomeMotorista;
    String placa;
    public CadastroCavaloModel(long id, String frota, String nomeMotorista, String placa) {
        this.id = id;
        this.frota = frota;
        this.nomeMotorista = nomeMotorista;
        this.placa = placa;
    }
    public CadastroCavaloModel(String frota, String nomeMotorista, String placa) {
        this.frota = frota;
        this.nomeMotorista = nomeMotorista;
        this.placa = placa;
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
    public String getNomeMotorista() {
        return nomeMotorista;
    }
    public void setNomeMotorista(String nomeMotorista) {
        this.nomeMotorista = nomeMotorista;
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
        System.out.println("Nome do motorista: "+getNomeMotorista());
        System.out.println("--------------------------------------");

        
    }

    
    
}
