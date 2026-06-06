package controller;

import exceptions.CategoryNotFound;
import exceptions.ProductNotFound;
import interfaces.ProductRepository;
import model.Customer;
import model.Product;
import repository.MemoryProductRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

public class StoreController {

    private final ProductRepository repository;

    public StoreController(ProductRepository repository) {
        this.repository = repository;
    }

    public boolean login(String user, String password) {
        return Objects.equals(user, "admin") && Objects.equals(password, "admin");
    }

    public void registerProduct(String prodCategory, String prodName, String prodDescription, String prodCharacteristics, BigDecimal prodPrice, int prodStock) {
        Product product = new Product(prodCategory, prodName, prodDescription, prodCharacteristics, prodPrice, prodStock);
        repository.save(product);
    }

    public void removerProduct(int productId) throws ProductNotFound {
        boolean exclusion = repository.remove(productId);

        if (!exclusion) {
            throw new ProductNotFound("Produto de ID: " + productId + " não foi encontrado.");
        }

        System.out.println("Produto do ID:" + productId + " removido com sucesso");

    }

    public void viewProducts() {
        List<Product> products = repository.view();
        if (products.isEmpty()) {
            System.out.println("Não existe produtos");
            return;
        }
        System.out.println("Produtos cadastrados: \n");
        for (Product p : products) {
            System.out.println("ID: " + p.getProdId());
            System.out.println("Catégoria: " + p.getProdCategory());
            System.out.println("Nome: " + p.getProdName());
            System.out.println("Descrição: " + p.getProdDescription());
            System.out.println("Características: " + p.getProdCharacteristics());
            System.out.println("Preço: " + p.getProdPrice());
            System.out.println("-------------------------");
        }
    }

    public void filterProducts(String category) throws CategoryNotFound {
        List<Product> filteredProducts = repository.filter(category);

        if (filteredProducts.isEmpty()) {
            throw new CategoryNotFound("Não existe produtos com a categória: " + category);
        }
        System.out.println("Produtos com a cateǵoria" + category + " :");
        for (Product p : filteredProducts) {
            System.out.println("ID: " + p.getProdId());
            System.out.println("Catégoria: " + p.getProdCategory());
            System.out.println("Nome: " + p.getProdName());
            System.out.println("Descrição: " + p.getProdDescription());
            System.out.println("Características: " + p.getProdCharacteristics());
            System.out.println("Preço: " + p.getProdPrice());
            System.out.println("-------------------------");
        }
    }
}
