package repository;

import interfaces.ProductRepository;
import model.Product;

import java.util.ArrayList;
import java.util.List;

public class MemoryProductRepository implements ProductRepository {

    private List<Product> products = new ArrayList<>();
    private int productId = 1;


    @Override
    public void save(Product produto) {
        produto.setProdId(productId++);
        products.add(produto);
    }

    @Override
    public boolean remove(int id) {
        return false;
    }

    @Override
    public List<Product> view() {
        return List.of();
    }

    @Override
    public List<Product> filter(String category) {
        return List.of();
    }
}
