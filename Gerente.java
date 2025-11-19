import java.util.Scanner;

public class Gerente extends Pessoa {
    protected String idGerente;

    Scanner sc = new Scanner(System.in);

    public Gerente(String nome, String sobrenome, int idade, String cpf,
                   String telefone, String email, String senha, String idGerente) {

        super(nome, sobrenome, idade, cpf, telefone, email, senha);
        this.idGerente = idGerente;
    }

    public void adicionarCarro(Loja loja, Scanner sc) {

        System.out.println("\n🚗 Cadastro de Carro");

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Cor: ");
        String cor = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Ano: ");
        int ano = sc.nextInt();

        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        sc.nextLine(); // limpar buffer

        System.out.print("Chassi: ");
        String chassi = sc.nextLine();

        Carro c = new Carro(marca, cor, modelo, ano, preco, chassi);
        loja.adicionarAutomovel(c);

        System.out.println("✅ Carro adicionado à loja!");
    }

    public void adicionarMoto(Loja loja, Scanner sc) {

        System.out.println("\n🏍 Cadastro de Moto");

        System.out.print("Marca: ");
        String marca = sc.nextLine();

        System.out.print("Cor: ");
        String cor = sc.nextLine();

        System.out.print("Modelo: ");
        String modelo = sc.nextLine();

        System.out.print("Ano: ");
        int ano = sc.nextInt();

        System.out.print("Preço: ");
        double preco = sc.nextDouble();
        sc.nextLine(); // limpar buffer

        System.out.print("Chassi: ");
        String chassi = sc.nextLine();

        Moto m = new Moto(marca, cor, modelo, ano, preco, chassi);
        loja.adicionarAutomovel(m);

        System.out.println("✅ Moto adicionada à loja!");
    }


}
