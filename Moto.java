public class Moto extends Veiculo {

    private boolean temBagageiro;

    public Moto(String id, String marca, String modelo, int ano, double preco, boolean temBagageiro) {
        super(id, marca, modelo, ano, preco);
        this.temBagageiro = temBagageiro;
    }

    public boolean getTemBagageiro() { return temBagageiro; }
    public void setTemBagageiro(boolean temBagageiro) { this.temBagageiro = temBagageiro; }

    @Override
    public String getTipo() {
        return "Moto";
    }

    //Sobrescrita de metodo concreto (requisito 7)
    @Override
    public double calcularTaxa() {
        return getPreco() * 0.03;
    }

    //Sobrescrita de metodo concreto (requisito 7)
    @Override
    public String mostrarInfo() {
        return super.mostrarInfo() + " | Bagageiro: " + (temBagageiro ? "Sim" : "Não");
    }
}
