package controller;

import interfaces.ProductRepository;
import model.Product;
import repository.MemoryProductRepository;

import java.math.BigDecimal;
import java.util.Objects;

public class StoreController {

    private final ProductRepository repository;

    public StoreController(ProductRepository repository) {
        this.repository = repository;
    }

    public boolean login(String user, String password){
        if(Objects.equals(user, "admin") && Objects.equals(password, "admin")){
            return true;
        }
        return false;
    }

    public void registerProduct(String prodName, String prodDescription, String prodCharacteristics, BigDecimal prodPrice, int prodStock){
        Product product = new Product(prodName, prodDescription, prodCharacteristics, prodPrice, prodStock);
        repository.save(product);
    }

}
