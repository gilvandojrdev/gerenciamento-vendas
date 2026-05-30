package repository;

import model.Cliente;
import java.math.BigDecimal;
import java.util.List;

public interface ClienteRepository {
    void salvar(Cliente cliente);
    boolean remover(int id);
    List<Cliente> listarTodos();
    List<Cliente> filtrar(BigDecimal salary);
}
