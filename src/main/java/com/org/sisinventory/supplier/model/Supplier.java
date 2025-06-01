package com.org.sisinventory.supplier.model;

public class Supplier {
    private Integer id;
    private String name;
    private String telephone;
    private String address;

    public Supplier(Integer id, String name, String telephone, String address) {
        this.id = id;
        this.name = name;
        this.telephone = telephone;
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return  id + " | " +
                name + " | " +
                telephone + " | " +
                address + " | \n" ;
    }
}
