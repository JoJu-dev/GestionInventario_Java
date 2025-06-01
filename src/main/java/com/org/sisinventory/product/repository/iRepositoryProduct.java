package com.org.sisinventory.product.repository;

import com.org.sisinventory.product.model.Product;
import com.org.sisinventory.repository.Repository;


import java.util.ArrayList;
import java.util.List;

public class iRepositoryProduct implements Repository<Product> {

    List<Product> datasource = new ArrayList<>();



    @Override
    public List<Product> list() {
        return this.datasource;
    }

    @Override
    public Product searchID(Integer id) {
        Product result = null;
        for (Product product : this.datasource) {

            if (product.getId().equals(id)) {
                result = product;
            }
        }

        return result;
    }

    @Override
    public void save(Product product) {
        this.datasource.add(product);

    }

    @Override
    public void update(Product product) {
        Product productNew = searchID(product.getId());

        if (productNew != null) {
            productNew.setName(product.getName());
            productNew.setDescription(product.getDescription());
            productNew.setPurchasePrice(product.getPurchasePrice());
            productNew.setSalePrice(product.getSalePrice());
            productNew.setAmount(product.getAmount());
            productNew.setAmountMinStock(product.getAmountMinStock());
            productNew.setIdSuplier(product.getIdSuplier());
        }

    }

    @Override
    public void delete(Product product) {

        this.datasource.remove(product);

    }
}
