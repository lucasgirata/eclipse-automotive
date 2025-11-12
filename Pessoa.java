public abstract class Pessoa {
    protected String nome;
    protected String sobrenome;
    protected int idade;
    protected String cpf;
    protected String telefone;
    protected String email;
    protected String senha;

    public Pessoa(String nome, String sobrenome, int idade, String cpf, String telefone, String email, String senha) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cpf = cpf;
        this.telefone = telefone;
        this.email = email;
        this.senha = senha;
    }
}
