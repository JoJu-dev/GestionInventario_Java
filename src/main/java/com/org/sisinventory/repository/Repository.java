package com.org.sisinventory.repository;

import java.util.List;

public interface Repository<T> {

    List<T> list();

    T listId(Integer id);

    void  save(T t);

    void delete (Integer id);
}
