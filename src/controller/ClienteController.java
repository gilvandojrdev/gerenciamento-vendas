package controller;
import model.Cliente;
import repository.ClienteRepository;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class ClienteController {

    private final ClienteRepository repository = new ClienteRepository();


    public void cadastrarCliente(String name, int age, BigDecimal salary, BigDecimal balance) {
        Cliente cliente = new Cliente(name, age, salary, balance);
        repository.salvar(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
    }


    public void removerCliente(int id_cliente) {
        boolean remocao = repository.remover(id_cliente);

        if (remocao) {
            System.out.println("Cliente ID " + id_cliente + " removido.");
        } else {
            System.out.println("Error: ID " + id_cliente + " não encontrado");
        }

    }

    public void listarClientes() {
        List<Cliente> clientes = repository.listarTodos();

        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Clientes cadastrados");
        System.out.println();

        for (Cliente c : clientes) {
            System.out.println("ID:" + c.getId());
            System.out.println("Nome: " + c.getName());
            System.out.println("Idade: " + c.getAge());
            System.out.println("Salário: " + c.getSalary());
            System.out.println("Saldo: " + c.getBalance());
            System.out.println("-------------------------");
        }

    }

    public void filtrarCLientes(BigDecimal salary_filtered){
        List<Cliente> filtrados = repository.filtrar(salary_filtered);

        if (filtrados.isEmpty()) {
            System.out.println("Não existe clientes com salário acima de " + salary_filtered);
            return;
        }

        System.out.println("---CLIENTES FILTRADOS---");
        for (Cliente c : filtrados) {
            System.out.println("ID: " + c.getId());
            System.out.println("Nome: " + c.getName());
            System.out.println("Salário: " + c.getSalary());
            System.out.println("Saldo: " + c.getBalance());
            System.out.println("-------------------------");
        }

    }

    public void adicionarSaldo(int id_informado){

        List<Cliente> clientes = repository.listarTodos();

        Optional<Cliente> clienteOptional = clientes.stream()
                .filter(cliente -> cliente.getId() == id_informado)
                .findFirst();

        if(clienteOptional.isPresent()) {
            Cliente cliente = clienteOptional.get();

            BigDecimal salary_dividend = cliente.getSalary();
            BigDecimal divider = BigDecimal.valueOf(1000);
            BigDecimal  quotient = salary_dividend.divide(divider);


            BigDecimal quotient2 = BigDecimal.valueOf(10);
            BigDecimal  resulted = quotient.divide(quotient2);


            BigDecimal valueToAdd = salary_dividend.multiply(resulted);
            BigDecimal new_Balance = cliente.getBalance().add(valueToAdd);
            cliente.setBalance(new_Balance);

            System.out.println("Saldo de " + new_Balance + " foi adicionado, visualize na aba vizualizar clientes!" );

        }
        else {
            System.out.println("Cliente com id " + id_informado + " não encontrado!");
        }


    }

}