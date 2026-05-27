package model;

import java.math.BigDecimal;

public class Produto {
    private int produto_id;


    private String prod_name;
    private String prod_description;
    private String prod_characteristics;
    private BigDecimal prod_price;
    private Integer prod_stock;
    public Produto(){

    }

    public Produto(String prod_name, String prod_description, String prod_characteristics, BigDecimal prod_price, Integer prod_stock){
        this.prod_name = prod_name;
        this.prod_description = prod_description;
        this.prod_characteristics = prod_characteristics;
        this.prod_price = prod_price;
        this.prod_stock = prod_stock;
    }

    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public String getProd_name() {
        return prod_name;
    }

    public void setProd_name(String prod_name) {
        this.prod_name = prod_name;
    }

    public String getProd_description() {
        return prod_description;
    }

    public void setProd_description(String prod_description) {
        this.prod_description = prod_description;
    }

    public String getProd_characteristics() {
        return prod_characteristics;
    }

    public void setProd_characteristics(String prod_characteristics) {
        this.prod_characteristics = prod_characteristics;
    }

    public BigDecimal getProd_price() {
        return prod_price;
    }

    public void setProd_price(BigDecimal prod_price) {
        this.prod_price = prod_price;
    }

    public Integer getProd_stock() {
        return prod_stock;
    }

    public void setProd_stock(Integer prod_stock) {
        this.prod_stock = prod_stock;
    }



}
