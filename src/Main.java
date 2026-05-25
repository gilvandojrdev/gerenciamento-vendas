import controller.ClienteController;

import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;
import java.math.BigDecimal;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        ClienteController controller = new ClienteController();

        System.out.println("Boas-Vindas ao Gerenciamento de Vendas");
        boolean running = true;

        while (running) {
            System.out.print("\n 1 - Adicionar cliente \n 2 - Remover cliente \n 3 - Visualizar clientes \n 4 - Filtrar clientes \n 5 - Sair");

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
                        } catch (InputMismatchException e) {
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
                        } catch (InputMismatchException e) {
                            System.err.println("Valor inválido! Digite um número.");
                            sc.nextLine();
                            i--;
                            continue;
                        }

                        System.out.print("Salário: ");
                        BigDecimal salary;
                        try {
                            salary = sc.nextBigDecimal();
                        } catch (InputMismatchException e) {
                            System.err.println("Salário inválido! Digite um número.");
                            sc.nextLine();
                            i--;
                            continue;
                        }

                        controller.cadastrarCliente(name, age, salary);
                    }

                }

                case "2" -> {
                    System.out.print("Digite o ID do cliente: ");
                    try {
                        int id_cliente = sc.nextInt();
                        controller.removerCliente(id_cliente);
                    } catch (InputMismatchException e) {
                        System.out.println("Erro: digite apenas números!");
                        sc.nextLine();
                    }
                }

                case "3" -> {
                    controller.listarClientes();
                }

                case "4" -> {
                    System.out.print("Salário: ");
                    BigDecimal salary = BigDecimal.ZERO;
                    try {
                        salary = sc.nextBigDecimal();
                    } catch (InputMismatchException e) {
                        System.err.println("Salário inválido! Digite um número.");
                        sc.nextLine();
                    }
                    
                    controller.filtrarCLientes(salary);
                }

                case "5" -> {
                    System.out.println("Programa finalizado...");
                    running = false;
                }

                default -> {
                    System.err.println("Opção inválida tente novamente");
                }
            }
        }
        sc.close();
    }
}