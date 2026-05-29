package model;

import java.math.BigDecimal;

public class Produto {
    private int produto_id;

    private String prodName;
    private String prodDescription;
    private String prodCharacteristics;
    private BigDecimal prodPrice;
    private Integer prodStock;
    public Produto(){

    }

    public Produto(String prodName, String prodDescription, String prodCharacteristics, BigDecimal prodPrice, Integer prodStock){
        this.prodName = prodName;
        this.prodDescription = prodDescription;
        this.prodCharacteristics = prodCharacteristics;
        this.prodPrice = prodPrice;
        this.prodStock = prodStock;
    }


    public int getProduto_id() {
        return produto_id;
    }

    public void setProduto_id(int produto_id) {
        this.produto_id = produto_id;
    }

    public String getProdName() {
        return prodName;
    }

    public void setProdName(String prodName) {
        this.prodName = prodName;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public void setProdDescription(String prodDescription) {
        this.prodDescription = prodDescription;
    }

    public String getProdCharacteristics() {
        return prodCharacteristics;
    }

    public void setProdCharacteristics(String prodCharacteristics) {
        this.prodCharacteristics = prodCharacteristics;
    }

    public BigDecimal getProdPrice() {
        return prodPrice;
    }

    public void setProdPrice(BigDecimal prodPrice) {
        this.prodPrice = prodPrice;
    }

    public Integer getProdStock() {
        return prodStock;
    }

    public void setProdStock(Integer prodStock) {
        this.prodStock = prodStock;
    }
}
