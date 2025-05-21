package com.org.sisinventory.customer.repository;


import com.org.sisinventory.customer.model.Customer;
import com.org.sisinventory.repository.Repository;

import java.util.List;

public class iRepositoryCustomer implements Repository<Customer> {
    @Override
    public List<Customer> list() {
        return null;
    }

    @Override
    public Customer listId(Integer id) {
        return null;
    }

    @Override
    public void save(Customer client) {

    }

    @Override
    public void delete(Integer id) {

    }
}
