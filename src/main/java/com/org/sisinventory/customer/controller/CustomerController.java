package com.org.sisinventory.customer.controller;

import com.org.sisinventory.customer.model.Customer;
import com.org.sisinventory.customer.repository.iRepositoryCustomer;

import java.util.List;

public class CustomerController {

    iRepositoryCustomer irepoCopy ;


   public CustomerController(iRepositoryCustomer repo){
        this.irepoCopy = repo;
    }


    public List<Customer> listController(){

       return this.irepoCopy.list();
    }

    public Customer SearchCustomerIDController(Integer id){

        return this.irepoCopy.searchID(id);
    }
    public void SaveCustomerController(String identification, String name, String lastName, String telephoneNumbers, String address, String mail){

        Customer customer = new Customer(identification,name,lastName,telephoneNumbers,address,mail);
        irepoCopy.save(customer);

    }

    public void updateCustomerController(String identification,String name, String lastname, String telephopone, String addres, String mail){

       Customer customer = new Customer(identification,name,lastname,telephopone,addres,mail);

       irepoCopy.update(customer);

    }

    public void removeCustomerController(Customer customer){

       irepoCopy.delete(customer);

    }


}
