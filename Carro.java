public class Carro extends Automovel {
    protected String chassi;

    public Carro(String marca, String cor, String modelo, int ano, double preco, String chassi) {
        super(marca, cor, modelo, ano, preco);
        this.chassi = chassi;
    }
}
