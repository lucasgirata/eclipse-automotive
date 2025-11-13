public abstract class Automovel {
    private String marca;
    private String cor;
    private String modelo;
    private int ano;
    private double kmRodado;
    private String placa;
    private String combustivel;
    private String cambio;
    private double preco;
    private boolean disponivel;

    public Automovel(String marca, String cor, String modelo, int ano, double preco){
        this.marca = "Veiculo";
        this.cor = "Neutro";
        this.modelo = "Carro";
        this.ano = 0;
        this.preco = 0;
        this.disponivel = true;
    }

    protected Automovel() {
    }

    public void ligado(){
        System.out.println(modelo + "esta ligado.");
    }
    public void desligado(){
        System.out.println(modelo + "esta desligado.");
    }
    public void acelerando(){
        System.out.printf(modelo + "esta acelarando!");
    }
    public void freiar(){
        System.out.println(modelo + "esta freiando!");
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
        System.out.println("Marca: " + marca + "Cor: " + cor + "Modelo: " + modelo + "Ano: " + "Valor: " + preco);
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
