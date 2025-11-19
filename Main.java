    import java.util.Scanner;

    public class Main {
        public static void main(String[] args) {

            Scanner sc = new Scanner(System.in);
            Loja loja = new Loja("Eclipse Automotive");
            Pessoa pessoa = null;

            System.out.println("\n🔥🔥 Seja Bem-Vindo À Eclipse Automotive! 🔥🔥\n");

            while (true) {
                System.out.println("\nSelecione uma opção: ");
                System.out.println("1 - Fazer Login");
                System.out.println("2 - Fazer Cadastro");
                System.out.println("3 - Sair\n");

                System.out.print("Insira sua opção: ");
                int opcao = sc.nextInt();
                sc.nextLine();

                if (opcao == 1) {
                    if (pessoa == null) {
                        System.out.println("\nNenhum usuário cadastrado ainda!");
                        continue;
                    }

                    System.out.println("\n🔐 Fazer Login 🔐");

                    System.out.print("Informe o email: ");
                    String email = sc.nextLine();

                    if (!email.equals(pessoa.getEmail())) {
                        System.out.println("❌ Email inválido!");
                        continue;
                    }

                    System.out.print("Insira sua senha: ");
                    String senha = sc.nextLine();

                    if (!senha.equals(pessoa.getSenha())) {
                        System.out.println("❌ Senha incorreta!");
                        continue;
                    }

                    System.out.println("\n✅ Login feito com sucesso!");

                    if (pessoa instanceof Gerente) {

                        System.out.println("\n👨‍💼 Bem vindo Gerente " + pessoa.getNome() + "!");
                        int escolha = -1;

                        while (escolha != 0) {
                            System.out.println("\n1 - Adicionar carro");
                            System.out.println("2 - Adicionar moto");
                            System.out.println("3 - Buscar automóvel por modelo");
                            System.out.println("4 - Listar Clientes");
                            System.out.println("0 - Logout");
                            System.out.print("Escolha: ");
                            escolha = sc.nextInt();
                            sc.nextLine();

                            if (escolha == 1) {
                                ((Gerente) pessoa).adicionarCarro(loja, sc);
                            }
                            else if (escolha == 2) {
                                ((Gerente) pessoa).adicionarMoto(loja, sc);
                            }
                            else if (escolha == 3) {
                                System.out.print("\nDigite o modelo: ");
                                String modelo = sc.nextLine();

                                try {
                                    Automovel a = loja.buscarAutomovelPorModelo(modelo);
                                    System.out.println("👉 Veículo encontrado!");
                                    a.exibirInf();
                                } catch (AutomovelException e) {
                                    System.out.println("❌ " + e.getMessage());
                                }
                            }
                            else if (escolha == 4){
                                System.out.println("Lista de clientes: ");
                                for (Cliente c : loja.getClientes()) {
                                    System.out.println(c);
                                }
                            }
                        }
                    }

                    else if (pessoa instanceof Cliente) {
                        System.out.println("\n👤 Bem vindo " + pessoa.getNome() + "!");
                        int escolha = -1;

                        while (escolha != 0) {
                            System.out.println("\n1 - Ver opções de carros");
                            System.out.println("2 - Ver opções de motos");
                            System.out.println("3 - Alterar dados do cadastro");
                            System.out.println("0 - Logout");
                            System.out.print("Escolha: ");
                            escolha = sc.nextInt();
                            sc.nextLine();

                            if (escolha == 1) {
                                System.out.println("\nLista de Carros:");
                                for (Automovel a : loja.getAutomoveis()) {
                                    if (a instanceof Carro) a.exibirInf();
                                }
                            } else if (escolha == 2) {
                                System.out.println("\nLista de Motos:");
                                for (Automovel a : loja.getAutomoveis()) {
                                    if (a instanceof Moto) a.exibirInf();
                                }
                            }
                        }
                    }
                }

                else if (opcao == 2) {

                    System.out.println("\nTipos de cadastro: ");
                    System.out.println("1 - Cliente");
                    System.out.println("2 - Gerente");
                    System.out.print("Insira qual o tipo: ");
                    int tipo = sc.nextInt();
                    sc.nextLine();

                    if (tipo == 1) {
                        Cliente c = new Cliente();
                        c.Cadastro(sc);
                        pessoa = c;
                        loja.adicionarCliente(c);
                    }

                    else if (tipo == 2) {
                        System.out.println("\nCadastro de Gerente:");
                        System.out.print("Nome: ");
                        String nome = sc.nextLine();
                        System.out.print("Sobrenome: ");
                        String sobrenome = sc.nextLine();
                        System.out.print("Idade: ");
                        int idade = sc.nextInt();
                        sc.nextLine();
                        System.out.print("CPF: ");
                        String cpf = sc.nextLine();
                        System.out.print("Telefone: ");
                        String telefone = sc.nextLine();
                        System.out.print("Email: ");
                        String email = sc.nextLine();
                        System.out.print("Senha: ");
                        String senha = sc.nextLine();
                        System.out.print("ID do gerente: ");
                        String idG = sc.nextLine();

                        pessoa = new Gerente(nome, sobrenome, idade, cpf, telefone, email, senha, idG);
                    }

                    System.out.println("\n📝 Cadastro concluído!\n");
                }

                else if (opcao == 3) {
                    System.out.println("\nEncerrando sistema");
                    break;
                }

                else {
                    System.out.println("\nOpção inválida! Tente novamente.");
                }
            }
        }
    }
