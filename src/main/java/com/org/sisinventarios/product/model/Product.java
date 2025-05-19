package com.org.sisinventarios.product.model;

import com.org.sisinventarios.suplier.model.Supplier;

public class Product {

    private int id;
    private String name;
    private String description;
    private double purchasePrice;
    private double salePrice;
    private int amount;
    private int amountMinStock;
    private Supplier idSuplier;

    public Product() {
    }

    public Product(int id, String name, String description, double purchasePrice, double salePrice, int amount, int amountMinStock, Supplier idSuplier) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.purchasePrice = purchasePrice;
        this.salePrice = salePrice;
        this.amount = amount;
        this.amountMinStock = amountMinStock;
        this.idSuplier = idSuplier;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(double purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getAmountMinStock() {
        return amountMinStock;
    }

    public void setAmountMinStock(int amountMinStock) {
        this.amountMinStock = amountMinStock;
    }

    public Supplier getIdSuplier() {
        return idSuplier;
    }

    public void setIdSuplier(Supplier idSuplier) {
        this.idSuplier = idSuplier;
    }

    @Override
    public String toString() {
        return
                id +
                name + " | " +
                description + " | " +
                purchasePrice +  " | "+
                salePrice + " | "+
                amount + " | " +
                amountMinStock +" | "+
                idSuplier + "' \n '";

    }
}
