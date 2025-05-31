package com.org.sisinventory.repository;

import java.util.List;

public interface Repository<T> {

    List<T> list();

    T searchCustomer(List<T> t);

     T save(List<T> t);

    void delete (Integer id);
}

