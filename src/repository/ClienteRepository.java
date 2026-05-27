package repository;

import model.Cliente;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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


    public List<Cliente> listarTodos() {
        return clientes;
    }

    public List<Cliente> filtrar(BigDecimal salary) {
        return clientes.stream()
                .filter(c -> c.getSalary().compareTo(salary) >= 1)
                .collect(Collectors.toList());
    }

}