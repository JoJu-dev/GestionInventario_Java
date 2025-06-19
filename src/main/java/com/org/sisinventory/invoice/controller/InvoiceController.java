package com.org.sisinventory.invoice.controller;

import com.org.sisinventory.invoice.model.Invoice;
import com.org.sisinventory.invoice.repository.iRepositoryInvoice;

import java.util.List;

public class InvoiceController {

    iRepositoryInvoice repoInvoice;

   public InvoiceController(iRepositoryInvoice repoInvoice){
        this.repoInvoice = repoInvoice;
    }

    public List<Invoice> listInvoiceController(){

            return repoInvoice.list();


    }

    public Invoice  searchIDInvoiceController(Integer id){

        return this.repoInvoice.searchID(id);

    }

    public void saveInvoiceController(Invoice invoice){
       this.repoInvoice.save(invoice);
    }

    public void deleteInvoiceController(Invoice invoice){
       this.repoInvoice.delete(invoice);
    }

}
