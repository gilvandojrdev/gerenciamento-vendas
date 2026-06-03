package repository;

import model.Customer;

import java.math.BigDecimal;
import java.util.List;

public interface CustomerRepository {
    void save(Customer customer);
    boolean remove(int id);
    List<Customer> view();
    List<Customer> filter(BigDecimal salary);
}
