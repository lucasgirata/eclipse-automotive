public abstract class Automovel {
    private String marca;
    private String cor;
    private String modelo;
    private int ano;
    private double preco;
    private boolean disponivel;

    public Automovel(String marca, String cor, String modelo, int ano, double preco){
        this.marca = marca;
        this.cor = cor;
        this.modelo = modelo;
        this.ano = ano;
        this.preco = preco;
        this.disponivel = true;
    }

    protected Automovel() {
    }

    public String getMarca() {
        return marca;
    }

    public String getCor() {
        return cor;
    }

    public String getModelo() {
        return modelo;
    }

    public int getAno() {
        return ano;
    }

    public double getPreco() {
        return preco;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void venda(){
        if (disponivel) {
            System.out.println(modelo + "veiculo vendido!!");
            disponivel = false;
        } else {
            System.out.println("veiculo ja foi vendido!");
        }
    }
    public void exibirInf(){
        System.out.println("Marca: " + marca);
        System.out.println("Cor: " + cor);
        System.out.println("Modelo: " + modelo);
        System.out.println("Ano: " + ano);
        System.out.println("Valor: " + preco);
    }
    public boolean estaDisponivel(){
        return disponivel;
    }
    public void aplicarDesconto(double percentual) {
        preco -= preco * (percentual / 100);
        System.out.println("Desconto aplicado! Novo preço: R$" + preco);
    }
    public void revisao(){
        System.out.printf(modelo + "passou por uma revisao completa!!");
    }

}

