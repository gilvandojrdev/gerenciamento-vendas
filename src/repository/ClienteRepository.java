package repository;

import model.Cliente;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();
    private int cliente_id = 1;

    public void salvar(Cliente cliente) {
        cliente.setId(cliente_id);
        cliente_id++;
        clientes.add(cliente);
    }

    public boolean remover(int id) {
        return clientes.removeIf(f -> f.getId() == id);
    }

    public boolean filtrar(BigDecimal salary) {
        List<Cliente> filtrados = clientes.stream()
                .filter(c -> c.getSalary().compareTo(salary) >= 1)
                .toList();

        filtrados.forEach(c -> {
            System.out.println("ID: " + c.getId());
            System.out.println("Nome: " + c.getName());
            System.out.println("-------------------------");
        });

        if (filtrados.isEmpty()){
            System.out.println("Não existe pessoas com o salário de " + salary);
        }

        return !filtrados.isEmpty();
    }




    public List<Cliente> listarTodos() {
        return clientes;
    }

}