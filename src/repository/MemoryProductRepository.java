package repository;

import interfaces.ProductRepository;
import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        return products.removeIf(p -> p.getProdId() == id);
    }

    @Override
    public List<Product> view() {
        return new ArrayList<>(products);
    }

    @Override
    public List<Product> filter(String category) {
        return products.stream().filter(p -> Objects.equals(p.getProdCategory(), category)).toList();
    }

}
