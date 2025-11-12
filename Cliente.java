public class Cliente extends Pessoa{
    protected String cnh;
    protected String endereco;

    public Cliente(String nome, String sobrenome, int idade, String cpf, String telefone, String email, String senha, String endereco, String cnh) {
        super(nome, sobrenome, idade, cpf, telefone, email, senha);
        this.endereco = endereco;
        this.cnh = cnh;
    }
}
