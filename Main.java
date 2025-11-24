import javax.swing.JOptionPane;
import java.io.IOException;

public class Main {

    private static void adicionarDadosIniciais(Loja loja) {
        loja.adicionarVeiculo(new Carro("C01", "Fiat", "Argo", 2021, 52000, 4));
        loja.adicionarVeiculo(new Carro("C02", "Volkswagen", "Gol", 2019, 45000, 4));
        loja.adicionarVeiculo(new Carro("C03", "Chevrolet", "Onix", 2020, 58000, 4));
        loja.adicionarVeiculo(new Carro("C04", "Ford", "Ka", 2018, 42000, 4));
        loja.adicionarVeiculo(new Carro("C05", "Hyundai", "HB20", 2021, 62000, 4));
        loja.adicionarVeiculo(new Carro("C06", "Toyota", "Corolla", 2017, 85000, 4));
        loja.adicionarVeiculo(new Carro("C07", "Honda", "Civic", 2016, 79000, 4));
        loja.adicionarVeiculo(new Carro("C08", "Renault", "Kwid", 2022, 49000, 4));
        loja.adicionarVeiculo(new Carro("C09", "Nissan", "Kicks", 2020, 97000, 4));
        loja.adicionarVeiculo(new Carro("C10", "Jeep", "Renegade", 2019, 99000, 4));

        loja.adicionarVeiculo(new Moto("M01", "Honda", "CG 160", 2020, 15000, true));
        loja.adicionarVeiculo(new Moto("M02", "Yamaha", "Factor 150", 2019, 13000, false));
        loja.adicionarVeiculo(new Moto("M03", "Honda", "Biz 125", 2021, 16000, true));
        loja.adicionarVeiculo(new Moto("M04", "Yamaha", "Fazer 250", 2020, 21000, true));
        loja.adicionarVeiculo(new Moto("M05", "Honda", "CB 250F Twister", 2018, 17500, false));
        loja.adicionarVeiculo(new Moto("M06", "Honda", "PCX 150", 2022, 18500, true));
        loja.adicionarVeiculo(new Moto("M07", "BMW", "G 310 GS", 2021, 33000, true));
    }


    public static void main(String[] args) {

        Loja loja = new Loja();
        final String NOME_ARQUIVO = "veiculos.dat";

        // Tenta carregar os veículos do arquivo
        try {
            loja.carregarVeiculos(NOME_ARQUIVO);

            // Se o arquivo foi encontrado e a lista está vazia, adiciona dados iniciais
            if (loja.quantidade() == 0) {
                adicionarDadosIniciais(loja);
            }

        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "Erro ao carregar dados: " + e.getMessage() + ". Iniciando com dados iniciais.");
            adicionarDadosIniciais(loja);
        }

        Administrador admin = new Administrador("Adm1", "João Gabriel");
        Usuario usuarioComum = new Usuario("Usu1", "Vinicius");


        JOptionPane.showMessageDialog(null, "Bem-vindo ao Sistema da Loja de Veículos!");

        Usuario usuarioLogado = null;

        while (usuarioLogado == null) {

            String usuarioDigitado = JOptionPane.showInputDialog(
                    "=== LOGIN ===\n\nDigite seu ID:");

            if (usuarioDigitado == null) return;

            if (usuarioDigitado.equals(admin.getId())) {
                usuarioLogado = admin;
                JOptionPane.showMessageDialog(null, "Login realizado como ADMINISTRADOR.");
            }
            else if (usuarioDigitado.equals(usuarioComum.getId())) {
                usuarioLogado = usuarioComum;
                JOptionPane.showMessageDialog(null, "Login realizado como USUÁRIO.");
            }
            else {
                JOptionPane.showMessageDialog(null, "ID inválido. Tente novamente.");
            }
        }

        String opcao = "";

        // O loop agora roda enquanto a opção não for "5"
        while (!opcao.equals("5")) {

            opcao = JOptionPane.showInputDialog(
                    "=== MENU PRINCIPAL ===\n" +
                            "Usuário: " + usuarioLogado.getNome() + " (" + usuarioLogado.getTipoUsuario() + ")\n\n" +
                            "1 - Listar veículos\n" +
                            "2 - Buscar veículo por ID\n" +
                            "3 - Adicionar veículo (somente administrador)\n" +
                            "4 - Remover veículo (somente admnistrador)\n" +
                            "5 - Sair\n\n" +
                            "Escolha uma opção:"
            );

            if (opcao == null) break;

            switch (opcao) {

                case "1":
                    JOptionPane.showMessageDialog(null, loja.listarVeiculosGUI());
                    break;

                case "2":
                    String idBusca = JOptionPane.showInputDialog("Digite o ID para buscar:");

                    try {
                        Veiculo v = loja.buscarPorId(idBusca);
                        JOptionPane.showMessageDialog(null, v.mostrarInfo());
                    } catch (VeiculoNaoEncontradoException e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                    }
                    break;

                case "3":
                    if (!usuarioLogado.podeAdicionarVeiculo()) {
                        JOptionPane.showMessageDialog(null,
                                "Você não tem permissão para adicionar veículos!");
                        break;
                    }

                    String tipo = JOptionPane.showInputDialog("Carro ou Moto?");
                    String idNovo = JOptionPane.showInputDialog("ID:");
                    String marca = JOptionPane.showInputDialog("Marca:");
                    String modelo = JOptionPane.showInputDialog("Modelo:");
                    try {
                        int ano = Integer.parseInt(JOptionPane.showInputDialog("Ano:"));
                        double preco = Double.parseDouble(JOptionPane.showInputDialog("Preço:"));

                        if (tipo.equalsIgnoreCase("Carro")) {
                            int portas = Integer.parseInt(JOptionPane.showInputDialog("Número de portas:"));
                            loja.adicionarVeiculo(new Carro(idNovo, marca, modelo, ano, preco, portas));
                        } else {
                            boolean bag = Boolean.parseBoolean(
                                    JOptionPane.showInputDialog("Tem bagageiro? true/false"));
                            loja.adicionarVeiculo(new Moto(idNovo, marca, modelo, ano, preco, bag));
                        }

                        JOptionPane.showMessageDialog(null, "Veículo adicionado com sucesso!");
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Entrada inválida. Operação cancelada.");
                    }
                    break;

                // Case 4 para remover veículo
                case "4":
                    if (!usuarioLogado.podeAdicionarVeiculo()) { // Usamos a mesma checagem de permissão
                        JOptionPane.showMessageDialog(null,
                                "Você não tem permissão para remover veículos!");
                        break;
                    }

                    String idRemocao = JOptionPane.showInputDialog("Digite o ID do veículo para remover:");

                    if (idRemocao != null) {
                        int tamanhoInicial = loja.quantidade();
                        loja.removerVeiculo(idRemocao);

                        if (loja.quantidade() < tamanhoInicial) {
                            JOptionPane.showMessageDialog(null, "Veículo com ID '" + idRemocao + "' removido com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Veículo com ID '" + idRemocao + "' não foi encontrado (ou ID inválido).");
                        }
                    }
                    break;

                case "5": // Ação de saída alterada
                    // A ação de salvar é feita após o loop.
                    break;

                default:
                    JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }

        // Salva os dados antes de sair do programa
        try {
            loja.salvarVeiculos(NOME_ARQUIVO);
            JOptionPane.showMessageDialog(null, "Dados salvos com sucesso.");
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, "ATENÇÃO: Erro ao salvar dados! " + e.getMessage());
        }

        JOptionPane.showMessageDialog(null, "Saindo do sistema...");
    }
}
