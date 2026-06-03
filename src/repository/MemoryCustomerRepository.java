package repository;

import model.Customer;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class MemoryCustomerRepository implements CustomerRepository {
    private List<Customer> customers = new ArrayList<>();
    private int cliente_id = 1;

    @Override
    public void save(Customer customer) {
        customer.setId(cliente_id++);
        customers.add(customer);
    }

    @Override
    public boolean remove(int id) {
        return customers.removeIf(c -> c.getId() == id);
    }

    @Override
    public List<Customer> view() {
        return new ArrayList<>(customers);
    }

    @Override
    public List<Customer> filter(BigDecimal salary) {
        return customers.stream()
                .filter(c -> c.getSalary().compareTo(salary) >= 1)
                .collect(Collectors.toList());
    }
}
