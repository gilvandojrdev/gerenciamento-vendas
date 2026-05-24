import controller.ClienteController;

import java.util.Locale;
import java.util.Scanner;
import java.math.BigDecimal;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        ClienteController controller = new ClienteController();

        System.out.println("Boas-Vindas ao Gerenciamento de Vendas");

        while (true) {
            System.out.print("\n 1 - Adicionar cliente \n 2 - Remover cliente \n 3 - Vizualizar clientes \n 4 - Sair");

            System.out.println();

            String option = sc.next();

            String flow = switch (option) {
                case "1" -> {
                    System.out.println("Digite a quantidade de clientes que deseja cadastrar");
                    int quantity = sc.nextInt();

                    for (int i = 0; i < quantity; i++) {

                        System.out.println("Cadastro do cliente #" + (i + 1));

                        sc.nextLine();

                        System.out.print("Nome: ");
                        String name = sc.nextLine();

                        System.out.print("Idade: ");
                        Integer age = sc.nextInt();

                        System.out.print("Salário: ");
                        BigDecimal salario = sc.nextBigDecimal();

                        System.out.println();

                        controller.cadastrarCliente(name, age, salario);
                    }

                    yield "Está perfeito!";
                }

                case "2" -> "Remover pendente";

                case "3" -> {
                    controller.listarClientes();
                    yield "Clientes listados";
                }

                case "4" -> {
                    System.out.println("Programa finalizado...");
                    System.exit(0);
                    yield "Status encerrado";
                }

                default -> {
                    System.err.println("Opção inválida tente novamente");
                    yield "Erro na opção";
                }
            };
        }
    }
}