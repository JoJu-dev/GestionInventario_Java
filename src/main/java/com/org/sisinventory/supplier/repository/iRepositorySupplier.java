package com.org.sisinventory.supplier.repository;

import com.org.sisinventory.customer.model.Customer;
import com.org.sisinventory.repository.Repository;
import com.org.sisinventory.supplier.model.Supplier;

import java.util.ArrayList;
import java.util.List;

public class iRepositorySuplier implements Repository<Supplier> {

    private List<Supplier> datasource = new ArrayList<>();

    @Override
    public List<Supplier> list() {
        return this.datasource;
    }

    @Override
    public Customer searchCustomer(String id) {
        return null;
    }

    @Override
    public void save(Supplier supplier) {

    }

    @Override
    public void update(Supplier supplier) {

    }

    @Override
    public void delete(String id) {

    }
}
