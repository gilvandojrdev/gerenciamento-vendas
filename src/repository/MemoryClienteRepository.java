package repository;

import model.Cliente;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MemoryClienteRepository implements ClienteRepository {
    private List<Cliente> clientes = new ArrayList<>();
    private int cliente_id = 1;

    @Override
    public void salvar(Cliente cliente) {
        cliente.setId(cliente_id++);
        clientes.add(cliente);
    }

    @Override
    public boolean remover(int id) {
        return clientes.removeIf(c -> c.getId() == id);
    }

    @Override
    public List<Cliente> listarTodos() {
        return new ArrayList<>(clientes);
    }

    @Override
    public List<Cliente> filtrar(BigDecimal salary) {
        return clientes.stream()
                .filter(c -> c.getSalary().compareTo(salary) >= 1)
                .collect(Collectors.toList());
    }
}
