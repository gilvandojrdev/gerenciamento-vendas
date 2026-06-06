// POO
import controller.CustomerController;
import controller.StoreController;

// Interfaces
import interfaces.CustomerRepository;
import interfaces.ProductRepository;

// Inversões
import repository.MemoryCustomerRepository;
import repository.MemoryProductRepository;

// Exeções
import exceptions.CategoryNotFound;
import exceptions.CustomerNotFound;
import exceptions.InsufficientBalance;
import exceptions.ProductNotFound;

// Bibliotecas
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.math.BigDecimal;

class Main {
    public static void main(String[] args)  {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        CustomerRepository repositoryClient = new MemoryCustomerRepository();
        ProductRepository repositoryProduct = new MemoryProductRepository();

        CustomerController controllerC = new CustomerController(repositoryClient);
        StoreController controllerL = new StoreController(repositoryProduct);

        System.out.println("Boas-Vindas ao Gerenciamento de Vendas");
        System.out.println();

        System.out.println("Digite as credenciais de login: ");

        System.out.print("Usuário: ");
        String user = sc.nextLine();
        System.out.print("Senha: ");
        String password = sc.nextLine();

        boolean login = controllerL.login(user, password);

        if (login) {
            boolean running = true;

            while (running) {
                System.out.println();
                System.out.println("Sistema de Gerenciamento de vendas");
                System.out.println("\n 1 - Gerenciamento clientes \n 2 - Gerenciamento Produtos \n");

                System.out.println("Digite uma opção exemplo '1', '2'");
                String option = sc.nextLine();

                switch (option) {
                    case "1" -> {
                        System.out.println(" 1 - Adicionar cliente \n 2 - Remover cliente \n 3 - Visualizar clientes \n 4 - Filtrar clientes \n 5 - Adicionar saldo aos clientes \n 6 - Sair");

                        String option2 = sc.nextLine();

                        switch (option2) {
                            case "1" -> {
                                System.out.print("Digite a quantidade de clientes: ");
                                int quantity = 0;

                                while (true) {
                                    try {
                                        quantity = sc.nextInt();
                                        sc.nextLine();
                                        break;
                                    } catch (InputMismatchException error) {
                                        System.err.println("Erro do sistema: Digite apenas números.");
                                        sc.nextLine();
                                    }
                                }

                                for (int i = 0; i < quantity; i++) {
                                    System.out.println("Cadastro do cliente #" + (i + 1));

                                    System.out.print("Nome: ");
                                    String name = sc.nextLine();

                                    System.out.print("Idade: ");
                                    int age;
                                    try {
                                        age = sc.nextInt();
                                        sc.nextLine();
                                    } catch (InputMismatchException error) {
                                        System.err.println("Valor inválido! Digite apenas números.");
                                        sc.nextLine();
                                        i--;
                                        continue;
                                    }

                                    System.out.print("Salário: ");
                                    BigDecimal salary;
                                    try {
                                        salary = sc.nextBigDecimal();
                                        sc.nextLine();
                                    } catch (InputMismatchException error) {
                                        System.err.println("Salário inválido! Digite apenas números.");
                                        sc.nextLine();
                                        i--;
                                        continue;
                                    }

                                    BigDecimal balance = BigDecimal.ZERO;
                                    controllerC.registerCustomer(name, age, salary, balance);
                                }
                            }
                            case "2" -> {
                                System.out.print("Digite o ID do cliente: ");
                                try {
                                    int id_cliente = sc.nextInt();
                                    sc.nextLine();

                                    controllerC.removeCustomer(id_cliente);
                                    System.out.println("Cliente removido com sucesso!");

                                } catch (InputMismatchException error) {
                                    System.err.println("Erro do sistema: Digite apenas números!");
                                    sc.nextLine();
                                } catch (CustomerNotFound error) {
                                    System.err.println("Aviso: " + error.getMessage());
                                }
                            }
                            case "3" -> {
                                controllerC.viewCustomer();
                            }
                            case "4" -> {
                                System.out.print("Digite o salário que deseja filtrar: ");
                                BigDecimal salary_filtered;
                                try {
                                    salary_filtered = sc.nextBigDecimal();
                                    sc.nextLine();
                                    controllerC.filterCustomer(salary_filtered);
                                } catch (InputMismatchException error) {
                                    System.err.println("Erro do sistema: Digite apenas números.");
                                    sc.nextLine();
                                } catch (CustomerNotFound error) {
                                    System.err.println("Erro do sistema :" + error.getMessage());
                                }
                            }
                            case "5" -> {
                                System.out.println("Digite o ID do cliente que você deseja setar o saldo: ");
                                try {
                                    int id_cliente = sc.nextInt();
                                    sc.nextLine();
                                    controllerC.addBalance(id_cliente);
                                    System.out.println("Operação realizada com sucesso!");

                                } catch (InputMismatchException error) {
                                    System.err.println("Erro do sistema: Digite apenas números!");
                                    sc.nextLine();
                                } catch (InsufficientBalance error) {
                                    System.err.println("Não foi possível aplicar o saldo: " + error.getMessage());
                                } catch (CustomerNotFound error) {
                                    System.err.println("Erro do sistema: " + error.getMessage());
                                }
                            }
                            case "6" -> {
                                System.out.println("Saindo do programa");
                                running = false;
                            }
                            default -> System.err.println("Opção inválida! Digite de '1' a '6'.");
                        }
                    }
                    case "2" -> {
                        System.out.println(" 1 - Adicionar produto \n 2 - Remover produto \n 3 - Visualizar produtos \n 4 - Filtrar produtos \n 5 - Sair");

                        String option3 = sc.nextLine();

                        switch (option3) {
                            case "1" -> {
                                System.out.print("Digite a quantidade de produtos: ");
                                int quantity = 0;

                                while (true) {
                                    try {
                                        quantity = sc.nextInt();
                                        sc.nextLine();
                                        break;
                                    } catch (InputMismatchException error) {
                                        System.err.println("Erro do sistema: Digite apenas números.");
                                        sc.nextLine();
                                    }
                                }

                                for (int i = 0; i < quantity; i++) {
                                    System.out.println("Cadastro do produto #" + (i + 1));


                                    System.out.print("Categoria do produto: ");
                                    String prodCategory = sc.nextLine();

                                    System.out.print("Nome do produto: ");
                                    String prodName = sc.nextLine();

                                    System.out.print("Descrição do produto: ");
                                    String prodDescription = sc.nextLine();

                                    System.out.print("Caracteristica do produto: ");
                                    String prodCharacteristics = sc.nextLine();

                                    System.out.print("Preço do produto: ");
                                    BigDecimal prodPrice;

                                    try {
                                        prodPrice = sc.nextBigDecimal();
                                        sc.nextLine();
                                    } catch (InputMismatchException error) {
                                        System.err.println("Preço inválido! Digite apenas números.");
                                        sc.nextLine();
                                        i--;
                                        continue;
                                    }

                                    System.out.print("Estoque do produto: ");
                                    int prodStock = 0;

                                    try {
                                        prodStock = sc.nextInt();
                                        sc.nextLine();
                                    } catch (InputMismatchException error) {
                                        System.err.println("Estoque inválido! Digite apenas números.");
                                        sc.nextLine();
                                        i--;
                                        continue;
                                    }

                                    controllerL.registerProduct(prodCategory, prodName, prodDescription, prodCharacteristics, prodPrice, prodStock);
                                }
                            }
                            case "2" -> {
                                System.out.println("Digite o ID do produto que deseja remover:");
                                try {
                                    int productId = sc.nextInt();
                                    sc.nextLine();
                                    controllerL.removerProduct(productId);
                                    System.out.println("Produto removido com sucesso!");
                                } catch (InputMismatchException error) {
                                    System.err.println("Erro do sistema: Digite apenas números!");
                                    sc.nextLine();
                                } catch (ProductNotFound error) {
                                    System.err.println("Aviso: " + error.getMessage());
                                }
                            }
                            case "3" -> {
                                controllerL.viewProducts();
                            }
                            case "4" -> {
                                System.out.println("Digite a categoria do produto: ");
                                try {
                                    String category = sc.nextLine();
                                    controllerL.filterProducts(category);
                                } catch (CategoryNotFound erro){
                                    System.err.println("Aviso: " + erro.getMessage());
                                }
                            }
                            case "5" -> {
                                System.out.println("Voltando ao menu principal...");
                            }
                            default -> System.err.println("Opção inválida!");
                        }
                    }
                    default -> System.err.println("Opção inválida! Digite '1' ou '2'.");
                }
            }
        } else {
            System.out.println("Login inválido");
        }
        sc.close();
    }
}
