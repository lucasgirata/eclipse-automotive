import java.util.ArrayList;

public class Loja {
    private String nome;
    private ArrayList<Automovel> automoveis;
    private ArrayList<Cliente> clientes;

    public Loja(String nome) {
        this.nome = nome;
        this.automoveis = new ArrayList<>();
        this.clientes = new ArrayList<>();
    }

    public void adicionarAutomovel(Automovel automovel) {
        automoveis.add(automovel);
    }

    public void adicionarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public ArrayList<Automovel> getAutomoveis() {
        return automoveis;
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Automovel buscarAutomovelPorModelo(String modelo) throws AutomovelException {
        for (Automovel a : automoveis) {
            if (a.getModelo().equalsIgnoreCase(modelo)) {
                return a;
            }
        }
        throw new AutomovelException("Automóvel não encontrado: " + modelo);
    }
}


