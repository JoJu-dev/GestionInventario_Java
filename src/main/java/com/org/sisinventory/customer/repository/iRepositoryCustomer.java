package com.org.sisinventory.customer.repository;
import com.org.sisinventory.customer.model.Customer;
import com.org.sisinventory.repository.RepositoryCopy;

import java.util.ArrayList;
import java.util.List;

public class iRepositoryCustomer implements RepositoryCopy<Customer> {

    private  List<Customer> dataSource = new ArrayList<>();


    @Override
    public List<Customer> list() {

        return dataSource;

    }

    @Override
    public Customer searchCustomer(String id) {
        Customer resultado = null;
        for (Customer customer : this.dataSource) {
            if (customer.getID() != null && customer.getID().equals(id)) {
                resultado = customer;
                break;
            }
        }

        return resultado;
    }

    @Override
    public void save(Customer customer) {

        this.dataSource.add(customer);
    }

    @Override
    public void update(Customer customer) {
        Customer client = searchCustomer(customer.getID());
        if (client != null){
            if(!customer.getName().equals("x")){
                client.setName(customer.getName());
            }
            if (!customer.getLastName().equals("x")){
                client.setLastName(customer.getLastName());
            }
            if (!customer.getTelephone().equals("x")){
                client.setTelephone(customer.getTelephone());
            }
            if (!customer.getAddress().equals("x")){
                client.setAddress(customer.getAddress());
            }
           if (!customer.getEmail().equals("x")) {
               client.setEmail(customer.getEmail());
           }
        }
    }

    @Override
    public void delete(String id) {
        this.dataSource.remove(searchCustomer(id));
        //para eliminar cliente debe de verificar que no exista factura, si existe factura no se elimina cliente.
    }

}
