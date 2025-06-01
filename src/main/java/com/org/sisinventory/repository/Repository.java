package com.org.sisinventory.repository;

import java.util.List;

public interface Repository<T> {

    List<T> list();

    T searchID(Integer t);

     void save( T t);

     void update(T t);

    void delete (T id);
}

