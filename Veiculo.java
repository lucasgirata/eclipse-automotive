import java.io.Serializable; // NOVO: Importa a interface

public abstract class Veiculo implements Serializable { // NOVO: Implementa Serializable

    // A ID de versão é adicionada para garantir a compatibilidade na serialização.
    private static final long serialVersionUID = 1L; // NOVO

    private String id;
    private String marca;
    private String modelo;
    private int ano;
    private double preco;

    public Veiculo(String id, String marca, String modelo, int ano, double preco) {
        this.id = id;
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }

    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }

    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }

    public double getPreco() { return preco; }
    public void setPreco(double preco) { this.preco = preco; }

    //Metodo concreto (será sobrescrito em Carro e Moto) - 7
    public double calcularTaxa() {
        return preco * 0.05;
    }

    // Metodo concreto (Sera sobrescrito em Carro e Moto) - 7
    public String mostrarInfo() {
        return marca + " " + modelo + " (" + ano + ") - R$ " + preco;
    }

    // Metodo abstrato (requisito 4)
    public abstract String getTipo();
}