package com.org.sisinventory.invoice.model;

import com.org.sisinventory.customer.model.Customer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {

    private static int counterId = 1; //variable de clase
    private Integer idInvoice;
    private Date date;
    private String idCliente;
    private double tax;
    private double total;
    private List<Integer> idsProducts;

    public Invoice() {
        this.idInvoice = counterId;
        counterId++;
        this.idsProducts = new ArrayList<>();
    }

    public Invoice(String idCliente, double tax) {
        this();
        this.date = new Date();
        this.idCliente = idCliente;
        this.tax = tax;

    }

    public static int getCounterId() {
        return counterId;
    }

    public static void setCounterId(int counterId) {
        Invoice.counterId = counterId;
    }

    public Integer getIdInvoice() {
        return idInvoice;
    }

    public void setIdInvoice(Integer idInvoice) {
        this.idInvoice = idInvoice;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
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
                idInvoice + " | " +
                        date + " | " +
                        tax + " | "+
                        total + " | ";
    }


    public void setIdsProductNews(String[] idsProduct) {
        for(String string : idsProduct){
            this.addIdsProducts(Integer.parseInt(string));
        }
    }
}
