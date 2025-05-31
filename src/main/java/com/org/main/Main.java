package com.org.main;

import com.org.main.optionsmenu.*;
import com.org.sisinventory.customer.controller.CustomerController;
import com.org.sisinventory.customer.model.Customer;
import com.org.sisinventory.customer.repository.*;
import com.org.sisinventory.customer.view.MainManagement;
import com.org.sisinventory.customer.view.ViewCrudCliente;
import com.org.sisinventory.service.*;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        iRepositoryCustomer repoCopy = new iRepositoryCustomer();
        List<Customer> customerList = repoCopy.list();
        CustomerController customerController = new CustomerController(repoCopy);
        ViewCrudCliente viewCrudCliente = new ViewCrudCliente(customerController);


        int option, optionSubMenu;

        do {
            ShowMainMenu.menuPrincipal();
            do {

                option = ValidateNumbers.capturarEntero("Dígite la opción a realizar: ");

                if (option < ConstantMain.EXIT || option > ConstantMain.INVOICE_MANAGEMENT) {
                    System.out.println("Digíte un valor entre 0 y 4");
                }

            } while (option < ConstantMain.EXIT || option > ConstantMain.INVOICE_MANAGEMENT);

            if (option == ConstantMain.EXIT) {
                break;
            }

            switch (option) {

                case ConstantMain.CUSTOMER_MANAGEMENT:

                    MainManagement.MenuCustomerManagement(viewCrudCliente, option);
                    break;

                case ConstantMain.SUPPLIER_MANAGEMENT:

                    break;

                case ConstantMain.PRODUCT_MANAGEMENT:
                    break;
                case ConstantMain.INVOICE_MANAGEMENT:
                    break;

            }

        } while (option != ConstantMain.EXIT);

    }


}