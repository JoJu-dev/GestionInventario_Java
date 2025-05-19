package com.org.sisinventarios.suplier.repository;

import com.org.sisinventarios.invoice.model.Invoice;
import com.org.sisinventarios.repository.Repository;
import com.org.sisinventarios.suplier.model.Supplier;

import java.util.List;

public class iRepositorySuplier implements Repository<Supplier> {

    @Override
    public List<Supplier> list() {
        return null;
    }

    @Override
    public Supplier listId(Integer id) {
        return null;
    }

    @Override
    public void save(Supplier supplier) {

    }

    @Override
    public void delete(Integer id) {

    }
}
