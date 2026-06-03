package controller;
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


    public void removeCustomer(int id_cliente) {
        boolean remocao = repository.remove(id_cliente);

        if (remocao) {
            System.out.println("Cliente ID " + id_cliente + " removido.");
        } else {
            System.out.println("Error: ID " + id_cliente + " não encontrado.");
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

    public void filterCustomer(BigDecimal salary_filtered){
        List<Customer> filtrados = repository.filter(salary_filtered);

        if (filtrados.isEmpty()) {
            System.out.println("Não existe clientes com salário acima de " + salary_filtered);
            return;
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

    public void addBalance(int id_informado){

        List<Customer> customers = repository.view();

        Optional<Customer> clienteOptional = customers.stream()
                .filter(customer -> customer.getId() == id_informado)
                .findFirst();

        if(clienteOptional.isPresent()) {
            Customer customer = clienteOptional.get();

            BigDecimal salary_dividend = customer.getSalary();
            BigDecimal divider = BigDecimal.valueOf(1000);
            BigDecimal  quotient = salary_dividend.divide(divider);


            BigDecimal quotient2 = BigDecimal.valueOf(10);
            BigDecimal  resulted = quotient.divide(quotient2);


            BigDecimal valueToAdd = salary_dividend.multiply(resulted);
            BigDecimal new_Balance = customer.getBalance().add(valueToAdd);
            customer.setBalance(new_Balance);

            System.out.println("Saldo de " + new_Balance + " foi adicionado, visualize na aba vizualizar clientes!" );

        }
        else {
            System.out.println("Cliente com id " + id_informado + " não encontrado!");
        }


    }

}