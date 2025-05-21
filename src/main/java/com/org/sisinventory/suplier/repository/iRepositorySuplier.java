package com.org.sisinventory.suplier.repository;

import com.org.sisinventory.repository.Repository;
import com.org.sisinventory.suplier.model.Supplier;

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
