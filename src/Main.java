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
            System.out.print("\n 1 - Adicionar cliente \n 2 - Remover cliente \n 3 - Visualizar clientes \n 4 - Sair");

            System.out.println();

            String option = sc.next();

            switch (option) {
                case "1" -> {
                    System.out.println("Digite a quantidade de clientes que deseja cadastrar");
                    int quantity = 0;
                    boolean quantityValid = false;

                    while (!quantityValid) {
                        try {
                            quantity = sc.nextInt();
                            quantityValid = true;
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
                        int age = 0;
                        try {
                            age = sc.nextInt();
                        } catch (InputMismatchException e) {
                            System.err.println("Valor inválido! Digite um número.");
                            sc.nextLine();
                            i--;
                            continue;
                        }

                        System.out.print("Salário: ");
                        BigDecimal salario = BigDecimal.ZERO;
                        try {
                            salario = sc.nextBigDecimal();
                        } catch (InputMismatchException e) {
                            System.err.println("Salário inválido! Digite um número.");
                            sc.nextLine();
                            i--;
                            continue;
                        }

                        System.out.println();

                        controller.cadastrarCliente(name, age, salario);
                    }
                }

                case "2" -> {
                    System.out.println("Funcionalidade ainda não implementada.");
                }

                case "3" -> {
                    controller.listarClientes();
                }

                case "4" -> {
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