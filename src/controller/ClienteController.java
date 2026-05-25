package controller;
import model.Cliente;
import repository.ClienteRepository;
import java.math.BigDecimal;
import java.util.List;

public class ClienteController {

    private ClienteRepository repository = new ClienteRepository();


    public void cadastrarCliente(String name, int age, BigDecimal salary) {
        Cliente cliente = new Cliente(name, age, salary);
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
            System.out.println("Salário " + c.getSalary());
            System.out.println("-------------------------");
        }

    }

    public void filtrarCLientes(BigDecimal salary){

        repository.filtrar(salary);


    }

}