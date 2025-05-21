package com.org.sisinventory.invoice.model;

import com.org.sisinventory.customer.model.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {

    private static int counterId = 1; //variable de clase
    private int id;
    private Date date;
    private Customer idCliente;
    private double tax;
    private double total;
    private List<Integer> idsProducts;

    public Invoice() {
        this.id = counterId;
        counterId++;
        this.idsProducts = new ArrayList<>();
    }

    public Invoice(int id, Date date, Customer idCliente, double tax, double total) {
        this();
        this.date = new Date();
        this.idCliente = idCliente;
        this.tax = tax;
        this.total = total;
    }

    public static int getCounterId() {
        return counterId;
    }

    public static void setCounterId(int counterId) {
        Invoice.counterId = counterId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Customer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Customer idCliente) {
        this.idCliente = idCliente;
    }

    public double getTax() {
        return tax;
    }

    public void setTax(double tax) {
        this.tax = tax;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void addIdsProducts(Integer idsProducts) {
        this.idsProducts.add(idsProducts);
    }

    public Integer[] getProducts() {

        Integer[] idsProductsCopi = new Integer[this.idsProducts.size()];
        this.idsProducts.toArray(idsProductsCopi);
        return idsProductsCopi;
    }

    @Override
    public String toString() {
        return
                id + " | " +
                        date + " | " +
                        idCliente + " | " +
                        tax + " | " +
                        total + " | ";

    }
}
