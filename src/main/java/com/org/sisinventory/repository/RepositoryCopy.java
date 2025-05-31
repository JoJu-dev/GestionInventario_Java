package com.org.sisinventory.repository;

import com.org.sisinventory.customer.model.Customer;

import java.util.List;

public interface RepositoryCopy<T> {

    List<T> list();

    Customer searchCustomer(String id);

     void save( T t);

     void update(T t);

    void delete (String id);
}

