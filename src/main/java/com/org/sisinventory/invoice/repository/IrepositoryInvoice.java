package com.org.sisinventory.invoice.repository;

import com.org.sisinventory.invoice.model.Invoice;
import com.org.sisinventory.repository.Repository;

import java.util.List;

public class IrepositoryInvoice implements Repository<Invoice> {
    @Override
    public List<Invoice> list() {
        return null;
    }

    @Override
    public Invoice listId(Integer id) {
        return null;
    }

    @Override
    public void save(Invoice invoice) {

    }

    @Override
    public void delete(Integer id) {

    }
}
