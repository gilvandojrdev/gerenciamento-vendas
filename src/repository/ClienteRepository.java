package repository;
import model.Cliente;
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

    public List<Cliente> listarTodos() {
        return clientes;
    }



}
