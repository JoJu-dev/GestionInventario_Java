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
    public Invoice searchID(Integer t) {
        return null;
    }

    @Override
    public void save(Invoice invoice) {

    }

    @Override
    public void update(Invoice invoice) {

    }

    @Override
    public void delete(Invoice id) {

    }
}
