import java.util.ArrayList;
import java.io.Serializable;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

// A classe Loja deve ser Serializable para persistir seu estado (a listaVeiculos)
public class Loja implements Serializable {

    // A ID única da versão da classe para serialização
    private static final long serialVersionUID = 1L;

    private ArrayList<Veiculo> listaVeiculos = new ArrayList<>();

    public void adicionarVeiculo(Veiculo v) {
        listaVeiculos.add(v);
    }

    public Veiculo buscarPorId(String id) throws VeiculoNaoEncontradoException {
        for (Veiculo v : listaVeiculos) {
            if (v.getId().equals(id)) {
                return v;
            }
        }
        throw new VeiculoNaoEncontradoException("Veículo com ID '" + id + "' não encontrado.");
    }

    public void removerVeiculo(String id) {
        listaVeiculos.removeIf(v -> v.getId().equals(id));
    }

    public String listarVeiculosGUI() {

        if (listaVeiculos.isEmpty()) {
            return "Nenhum veículo cadastrado.";
        }

        String texto = "=== Veículos Cadastrados ===\n\n";

        //Chamada polimorfica de metodo (Programa consegue diferenciar Carro de Moto) - 8
        for (Veiculo v : listaVeiculos) {
            texto += v.getTipo() + " - " + v.mostrarInfo() + "\n";
        }

        return texto;
    }

    public int quantidade() {
        return listaVeiculos.size();
    }

    //Método para salvar a lista de veículos
    public void salvarVeiculos(String nomeArquivo) throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(nomeArquivo))) {
            oos.writeObject(this.listaVeiculos); // Salva o ArrayList completo
        }
    }

    //Método para carregar a lista de veículos
    @SuppressWarnings("unchecked")
    public void carregarVeiculos(String nomeArquivo) throws IOException, ClassNotFoundException {
        // Tentativa de carregar o arquivo
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(nomeArquivo))) {
            this.listaVeiculos = (ArrayList<Veiculo>) ois.readObject(); // Carrega o ArrayList
        } catch (java.io.FileNotFoundException e) {
            // Se o arquivo não existir na primeira execução, a lista é inicializada vazia
            System.out.println("Arquivo de dados não encontrado. Lista de veículos inicializada vazia.");
            this.listaVeiculos = new ArrayList<>();
        }
    }
}