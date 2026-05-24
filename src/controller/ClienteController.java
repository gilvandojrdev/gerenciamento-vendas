package controller;

import model.Cliente;
import repository.ClienteRepository;

import java.math.BigDecimal;
import java.sql.SQLOutput;
import java.util.List;

public class ClienteController {
    private ClienteRepository repository = new ClienteRepository();

    public void cadastrarCliente(String name, Integer age, BigDecimal salary) {
        Cliente cliente = new Cliente(name, age, salary);
        repository.salvar(cliente);
        System.out.println("Cliente cadastrado com sucesso.");
        System.out.println();
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

}