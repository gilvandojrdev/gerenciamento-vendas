package repository;

import model.Product;

import java.util.List;

public interface ProductRepository {
    void save(Product produto);
    boolean remove(int id);
    List<Product> view();
    List<Product> filter(String category);
}
