package com.org.main;

import com.org.main.optionsmenu.ConstantMain;
import com.org.main.optionsmenu.ShowMainMenu;
import com.org.sisinventory.customer.controller.CustomerController;
import com.org.sisinventory.customer.repository.iRepositoryCustomer;
import com.org.sisinventory.customer.view.*;
import com.org.sisinventory.invoice.controller.InvoiceController;
import com.org.sisinventory.invoice.view.MainManagementInvoice;
import com.org.sisinventory.invoice.view.ViewCrudInvoice;
import com.org.sisinventory.product.controller.ProductController;
import com.org.sisinventory.product.repository.iRepositoryProduct;
import com.org.sisinventory.product.view.*;

import com.org.sisinventory.supplier.controller.SupplierController;
import com.org.sisinventory.supplier.repository.iRepositorySupplier;
import com.org.sisinventory.service.ValidateNumbers;
import com.org.sisinventory.supplier.view.MainManagementSupplier;
import com.org.sisinventory.supplier.view.ViewCrudSupplier;
import com.org.sisinventory.invoice.repository.iRepositoryInvoice;


public class Main {

    public static void main(String[] args) {

        iRepositoryCustomer repoCopy = new iRepositoryCustomer();
        CustomerController customerController = new CustomerController(repoCopy);
        ViewCrudCliente viewCrudCliente = new ViewCrudCliente(customerController);

        iRepositoryProduct repoProduct = new iRepositoryProduct();
        ProductController productController = new ProductController(repoProduct);
        ViewCrudProduct viewCrudProduct = new ViewCrudProduct(productController);

        iRepositorySupplier repoSupplier = new iRepositorySupplier();
        SupplierController supplierController = new SupplierController(repoSupplier);
        ViewCrudSupplier viewCrudSupplier = new ViewCrudSupplier(supplierController);

        iRepositoryInvoice repositoryInvoice = new iRepositoryInvoice();
        InvoiceController invoiceController = new InvoiceController(repositoryInvoice);
        ViewCrudInvoice viewCrudInvoice = new ViewCrudInvoice(invoiceController);


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

                case ConstantMain.CUSTOMER_MANAGEMENT ->
                        MainManagementCustomer.MenuCustomerManagement(viewCrudCliente, option);

                case ConstantMain.SUPPLIER_MANAGEMENT ->
                        MainManagementSupplier.MenuCustomerManagement(viewCrudSupplier, option, viewCrudProduct.productListView());

                case ConstantMain.PRODUCT_MANAGEMENT ->
                        MainManagementProduct.MenuProductManagement(viewCrudProduct, option, supplierController.listController(), invoiceController);

                case ConstantMain.INVOICE_MANAGEMENT -> {
                    if (customerController.listController().isEmpty() || productController.listController().isEmpty()) {
                        System.out.println("No se puede Acceder al Menu Facturación, no existen datos de clientes o productos");
                    } else {
                        MainManagementInvoice.MenuCustomerManagement(viewCrudInvoice, option, customerController, viewCrudCliente, productController, viewCrudProduct);

                    }
                    ShowMainMenu.continuar();
                }
            }

        } while (option != ConstantMain.EXIT);

    }


}