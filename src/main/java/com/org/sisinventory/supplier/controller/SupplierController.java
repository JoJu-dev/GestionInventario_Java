package com.org.sisinventory.supplier.controller;
import com.org.sisinventory.supplier.model.Supplier;
import com.org.sisinventory.supplier.repository.iRepositorySupplier;

import java.util.List;

public class SupplierController {

    iRepositorySupplier repository;


    public SupplierController(iRepositorySupplier repository) {

        this.repository = repository;
    }

    public List<Supplier> listController() {
        return repository.list();
    }


    public Supplier searchIDController(Integer id) {

        return this.repository.searchID(id);
    }

    public void saveSupplierController(Integer identification, String name, String telephopone, String addres) {

        Supplier supplier = new Supplier(identification, name, telephopone, addres);

        repository.save(supplier);
    }

    public void updateSupplierController(Integer identification, String name, String telephopone, String addres) {

        Supplier supplier = new Supplier(identification, name, telephopone, addres);

        repository.save(supplier);
    }

    public void deleteSupplierController(Supplier supplier){
        repository.delete(supplier);
    }
}
