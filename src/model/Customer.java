package model;

import java.math.BigDecimal;

public class Customer {
    private int id;


    private String name;
    private Integer age;
    private BigDecimal salary = BigDecimal.ZERO;
    private BigDecimal balance = BigDecimal.ZERO;


    public Customer() {

    }

    public Customer(String name, Integer age, BigDecimal salary, BigDecimal balance) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.balance = balance;
    }



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public BigDecimal getSalary() {
        return salary;
    }


    public void setSalary(BigDecimal salary) {
        this.salary = salary;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
