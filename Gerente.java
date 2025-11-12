public class Gerente extends Pessoa{
    protected String idGerente;

    public Gerente(String nome, String sobrenome, int idade, String cpf, String telefone, String email, String senha,String idGerente){
        super(nome, sobrenome, idade, cpf, email, senha, telefone);
        this.idGerente = idGerente;
    }

    public void adicionarCarro(){

    }
}
