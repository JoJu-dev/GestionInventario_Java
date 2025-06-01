package com.org.sisinventory.supplier.repository;

import com.org.sisinventory.repository.Repository;
import com.org.sisinventory.supplier.model.Supplier;

import java.util.ArrayList;
import java.util.List;

public class iRepositorySupplier implements Repository<Supplier> {

    List<Supplier> dataSource = new ArrayList<>();

    @Override
    public List<Supplier> list() {
        return this.dataSource;
    }

    @Override
    public Supplier searchID(Integer id) {
        Supplier resultado = null;
        for (Supplier supplier : this.dataSource) {
            if (supplier.getId() == id) {
                resultado = supplier;
                break;
            }
        }

        return resultado;
    }

    @Override
    public void save(Supplier supplier) {
        this.dataSource.add(supplier);
    }

    @Override
    public void update(Supplier supplier) {
        Supplier provider = searchID(supplier.getId());

        if (provider != null) {

            provider.setName(supplier.getName());
            provider.setTelephone(supplier.getTelephone());
            provider.setAddress(supplier.getAddress());
        }
    }

    @Override
    public void delete(Supplier supplier) {
        this.dataSource.remove(supplier);
    }
}
