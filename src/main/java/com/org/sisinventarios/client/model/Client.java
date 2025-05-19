package com.org.sisinventarios.client.model;

public class Client {
    private String ID;
    private String name;
    private String lastName;
    private String telephone;
    private String address;
    private String email;

    public Client() {
    }

    public Client(String ID, String name, String lastName, String telephone, String address, String email) {
        this.ID = ID;
        this.name = name;
        this.lastName = lastName;
        this.telephone = telephone;
        this.address = address;
        this.email = email;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return
                ID + " | " +
                name + " | " +
                lastName + " | " +
                telephone + " | " +
                address + " | " +
                email + " '\n'  " ;
    }
}
