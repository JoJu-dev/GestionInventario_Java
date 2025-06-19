package com.org.sisinventory.invoice.repository;

import com.org.sisinventory.invoice.model.Invoice;
import com.org.sisinventory.repository.Repository;

import java.util.ArrayList;
import java.util.List;

public class iRepositoryInvoice implements Repository<Invoice> {

    List<Invoice> dataSource = new ArrayList<>();

    @Override
    public List<Invoice> list() {
        return this.dataSource;
    }

    @Override
    public Invoice searchID(Integer idInvoice ) {

        Invoice resultado = null;
        for(Invoice i: this.dataSource){
            if (i.getIdInvoice() == idInvoice){
                resultado = i;
                break;
            }
        }
        return resultado;
    }

    @Override
    public void save(Invoice invoice) {
        this.dataSource.add(invoice);
    }

    @Override
    public void update(Invoice invoice) {
        Invoice bill = searchID(invoice.getIdInvoice());
        if (bill.getIdInvoice() !=null){
            bill.setIdCliente(invoice.getIdCliente());
            bill.setTax(invoice.getTax());
        }
    }

    @Override
    public void delete(Invoice invoice) {

        dataSource.remove(invoice);

    }
}
