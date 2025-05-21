package com.org.main;

import com.org.main.optionsmenu.*;
import com.org.sisinventory.customer.model.Customer;
import com.org.sisinventory.invoice.model.Invoice;
import com.org.sisinventory.product.model.Product;
import com.org.sisinventory.suplier.model.Supplier;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        List<Customer> clientList = new ArrayList<>();
        List<Supplier> supplierList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        List<Invoice> invoiceList = new ArrayList<>();

        int option, optionSubMenu;

        do {
            ShowMainMenu.menuPrincipal();
            do {

                option = ValidateNumber.capturarEntero("Dígite la opción a realizar: ");

                if (option < ConstantMain.EXIT || option > ConstantMain.INVOICE_MANAGEMENT) {
                    System.out.println("Digíte un valor entre 0 y 4");
                }

            } while (option < ConstantMain.EXIT || option > ConstantMain.INVOICE_MANAGEMENT);

            if (option == ConstantMain.EXIT) {
                break;
            }

            switch (option) {

                case ConstantMain.CUSTOMER_MANAGEMENT:

                    do {
                        ShowMainMenu.Submenu("CLIENTES");
                        optionSubMenu = ValidateNumber.capturarEntero("Digite la Opcion a realizar.");

                        if (optionSubMenu < ConstantMain.EXIT || optionSubMenu > ConstantMain.DELETE) {
                            System.out.println("Digíte un valor entre 0 y 4");

                            switch (optionSubMenu) {
                                case ConstantMain.CREATE:
                                    break;
                                case ConstantMain.SEARCH:
                                    break;
                                case ConstantMain.UPDATE:
                                    break;
                                case ConstantMain.DELETE:
                                    break;
                            }


                        }

                    } while (option < ConstantMain.EXIT || option > ConstantMain.DELETE);

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