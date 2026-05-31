package repository;

import model.Produto;

import java.util.List;

public interface ProdutoRepository {
    void salvar(Produto produto);
    boolean remover(int id);
    List<Produto> listar();
    List<Produto> filtrar(String category);
}
