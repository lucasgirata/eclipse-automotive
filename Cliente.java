import java.util.Scanner;

public class Cliente extends Pessoa{
    protected String cnh;
    protected String endereco;

    public Cliente(String nome, String sobrenome, int idade, String cpf, String telefone, String email, String senha, String cnh, String endereco) {
        super(nome, sobrenome, idade, cpf, telefone, email, senha);
        this.cnh = cnh;
        this.endereco = endereco;
    }

    public Cliente(){
        super("", "", 0, "", "", "", "");
    }

    public String getEndereco() {
        return endereco;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void Cadastro(Scanner sc) {
        System.out.println("\n📝 Fazer Cadastro 📝");

        sc.nextLine();

        System.out.print("\nInsira seu nome: ");
        this.nome = sc.nextLine();

        System.out.print("\nInsira seu sobrenome: ");
        this.sobrenome = sc.nextLine();

        System.out.print("\nInsira sua idade: ");
        this.idade = sc.nextInt();

        sc.nextLine();

        System.out.print("\nInsira seu CPF: ");
        this.cpf = sc.nextLine();

        System.out.print("\nInsira seu telefone: ");
        this.telefone = sc.nextLine();

        System.out.print("\nInsira seu email: ");
        this.email = sc.nextLine();

        System.out.print("\nInsira a senha: ");
        this.senha = sc.nextLine();

        System.out.print("\nInsira sua CNH: ");
        this.cnh = sc.nextLine();

        System.out.println("\n📝 Cadastro feito com sucesso 📝");
    }

    public String toString(){
        return nome;
    }
}
