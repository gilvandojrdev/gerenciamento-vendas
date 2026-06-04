package controller;
import exceptions.CustomerNotFound;
import exceptions.InsufficientBalance;
import model.Customer;
import repository.CustomerRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class CustomerController {


    private final CustomerRepository repository;


    public CustomerController(CustomerRepository repository) {
        this.repository = repository;
    }


    public void registerCustomer(String name, int age, BigDecimal salary, BigDecimal balance) {
        Customer customer = new Customer(name, age, salary, balance);
        repository.save(customer);
        System.out.println("Cliente cadastrado com sucesso.");
    }


    public void removeCustomer(int customer_id) throws CustomerNotFound {
        boolean exclusion = repository.remove(customer_id);

        if (!exclusion) {
            throw new CustomerNotFound("Cliente com ID " + customer_id + " não encontrado.");
        }

    }

    public void viewCustomer() {
        List<Customer> customers = repository.view();

        if (customers.isEmpty()) {
            System.out.println("Nenhum cliente cadastrado.");
            return;
        }

        System.out.println("Clientes cadastrados");
        System.out.println();

        for (Customer c : customers) {
            System.out.println("ID:" + c.getId());
            System.out.println("Nome: " + c.getName());
            System.out.println("Idade: " + c.getAge());
            System.out.println("Salário: " + c.getSalary());
            System.out.println("Saldo: " + c.getBalance());
            System.out.println("-------------------------");
        }

    }

    public void filterCustomer(BigDecimal salary_filtered) throws CustomerNotFound {
        List<Customer> filtrados = repository.filter(salary_filtered);

        if (filtrados.isEmpty()) {
            throw new CustomerNotFound("Não existe clientes com salário acima de " + salary_filtered);
        }

        System.out.println("---CLIENTES FILTRADOS---");
        for (Customer c : filtrados) {
            System.out.println("ID: " + c.getId());
            System.out.println("Nome: " + c.getName());
            System.out.println("Salário: " + c.getSalary());
            System.out.println("Saldo: " + c.getBalance());
            System.out.println("-------------------------");
        }

    }

    public void addBalance(int id_provided) throws InsufficientBalance, CustomerNotFound {

        BigDecimal salaryMin = BigDecimal.valueOf(1620);

        List<Customer> customers = repository.view();

        Optional<Customer> clienteOptional = customers.stream()
                .filter(customer -> customer.getId() == id_provided)
                .findFirst();

        if (clienteOptional.isEmpty()) {
            throw new CustomerNotFound("Cliente com ID " + id_provided + " não encontrado!");
        }

        Customer customer = clienteOptional.get();

        if (customer.getSalary().compareTo(salaryMin) < 0) {
            throw new InsufficientBalance("Salário atual de R$ " + customer.getSalary() + " é inferior ao mínimo permitido.");
        }

        BigDecimal newBalance = customer.getSalary().divide(BigDecimal.TWO);
        customer.setBalance(newBalance);

    }
}