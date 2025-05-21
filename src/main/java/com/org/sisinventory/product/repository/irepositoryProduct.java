package com.org.sisinventory.product.repository;

import com.org.sisinventory.product.model.Product;
import com.org.sisinventory.repository.Repository;

import java.util.List;

public class irepositoryProduct implements Repository<Product> {
    @Override
    public List<Product> list() {
        return null;
    }

    @Override
    public Product listId(Integer id) {
        return null;
    }

    @Override
    public void save(Product product) {

    }

    @Override
    public void delete(Integer id) {

    }
}
