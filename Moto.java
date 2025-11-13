public class Moto extends Automovel{
    protected String chassi;

    public Moto(String marca, String cor, String modelo, int ano, double preco, String chassi) {
        super(marca, cor, modelo, ano, preco);
        this.chassi = chassi;
    }
}
