public class Carro extends Veiculo {

    private int portas;

    public Carro(String id, String marca, String modelo, int ano, double preco, int portas) {
        super(id, marca, modelo, ano, preco);
        this.portas = portas;
    }

    public int getPortas() { return portas; }
    public void setPortas(int portas) { this.portas = portas; }

    @Override
    public String getTipo() {
        return "Carro";
    }

    //Sobrescrita de metodo concreto (requisito 7)
    @Override
    public double calcularTaxa() {
        return getPreco() * 0.06;
    }

    //Sobrescrita de metodo concreto (requisito 7)
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | " + portas + " portas";
    }
}
