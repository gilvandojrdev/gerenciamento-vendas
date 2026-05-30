// POO
import controller.ClienteController;
import controller.LojaController;
import repository.ClienteRepository;
import repository.MemoryClienteRepository;

// Bibliotecas
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.math.BigDecimal;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        ClienteRepository repository = new MemoryClienteRepository();

        ClienteController controllerC = new ClienteController(repository);
        LojaController controllerL = new LojaController();

        System.out.println("Boas-Vindas ao Gerenciamento de Vendas");
        System.out.println();

        System.out.println("Digite as credenciais de login: ");

        System.out.print("Usuário: ");
        String user = sc.nextLine();
        System.out.print("Senha: ");
        String password = sc.nextLine();

        boolean login = controllerL.loginLoja(user, password);

        if (login){
            boolean running = true;

            while (running) {
                System.out.print("Sistema de Gerenciamento de vendas \n 1 - Adicionar cliente \n 2 - Remover cliente \n 3 - Visualizar clientes \n 4 - Filtrar clientes \n 5 - Adicionar saldo aos clientes \n 6 - Sair");

                System.out.println();

                String option = sc.next();

                switch (option) {
                    case "1" -> {
                        System.out.println("Digite a quantidade de clientes que deseja cadastrar");
                        int quantity = 0;

                        while (true) {
                            try {
                                quantity = sc.nextInt();
                                break;
                            } catch (InputMismatchException error) {
                                System.err.println("Valor inválido! Digite um número.");
                                sc.nextLine();
                            }
                        }

                        for (int i = 0; i < quantity; i++) {
                            System.out.println("Cadastro do cliente #" + (i + 1));
                            sc.nextLine();

                            System.out.print("Nome: ");
                            String name = sc.nextLine();

                            System.out.print("Idade: ");
                            int age;
                            try {
                                age = sc.nextInt();
                            } catch (InputMismatchException error) {
                                System.err.println("Valor inválido! Digite um número.");
                                sc.nextLine();
                                i--;
                                continue;
                            }

                            System.out.print("Salário: ");
                            BigDecimal salary;
                            try {
                                salary = sc.nextBigDecimal();
                            } catch (InputMismatchException error) {
                                System.err.println("Salário inválido! Digite um número.");
                                sc.nextLine();
                                i--;
                                continue;
                            }

                            BigDecimal balance = BigDecimal.ZERO;
                            controllerC.cadastrarCliente(name, age, salary, balance);
                        }

                    }

                    case "2" -> {
                        System.out.print("Digite o ID do cliente: ");
                        try {
                            int id_cliente = sc.nextInt();
                            controllerC.removerCliente(id_cliente);
                        } catch (InputMismatchException error) {
                            System.out.println("Erro: digite apenas números!");
                            sc.nextLine();
                        }
                    }

                    case "3" -> {
                        controllerC.listarClientes();
                    }

                    case "4" -> {
                        System.out.print("Digite o salário que deseja filtrar: ");
                        BigDecimal salary_filtered = BigDecimal.ZERO;
                        try {
                            salary_filtered = sc.nextBigDecimal();
                        } catch (InputMismatchException error) {
                            System.err.println("Salário inválido! Digite um número.");
                            sc.nextLine();
                        }

                        if (salary_filtered.compareTo(BigDecimal.ZERO) > 0){
                            controllerC.filtrarCLientes(salary_filtered);
                        } else{
                            System.out.println("Não foi possivel filtrar tente novamente! Motivo:");
                        }

                    }

                    case "5" -> {
                        System.out.println("Digite o ID do cliente que você deseja que o sistema vai setar o saldo: ");
                        int id_cliente = 0;
                        try {
                            id_cliente = sc.nextInt();
                        } catch (InputMismatchException error){
                            System.out.println("Digite apenas números");
                        }
                        controllerC.adicionarSaldo(id_cliente);
                    }

                    case "6" -> {
                        System.out.println("Programa finalizado...");
                        running = false;
                    }

                    default -> {
                        System.err.println("Opção inválida tente novamente");
                    }
                }
            }
        } else {
            System.out.println("Login inválido");
        }
        sc.close();
    }
}