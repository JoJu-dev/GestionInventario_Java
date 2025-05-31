package com.org.main;

import com.org.sisinventory.customer.controller.CustomerController;
import com.org.sisinventory.customer.repository.iRepositoryCustomerCopy;
import com.org.sisinventory.customer.view.ViewCrudCliente;

public class Prueba {

    public static void main(String[] args) {
        iRepositoryCustomerCopy customerCopy = new iRepositoryCustomerCopy();
        CustomerController customerController = new CustomerController(customerCopy);
        ViewCrudCliente viewCrudCliente = new ViewCrudCliente(customerController);

        viewCrudCliente.savedCustomerView();
        viewCrudCliente.savedCustomerView();
      //  viewCrudCliente.listCustomerView();

       // System.out.println( viewCrudCliente.searchIDCustomerView("10"));

    }

}
