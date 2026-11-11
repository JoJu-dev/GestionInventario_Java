package com.org.sisinventory.invoice.view;

import com.org.main.optionsmenu.ConstantMain;
import com.org.main.optionsmenu.ShowMainMenu;
import com.org.sisinventory.customer.controller.CustomerController;
import com.org.sisinventory.customer.view.ViewCrudCliente;
import com.org.sisinventory.invoice.controller.InvoiceController;
import com.org.sisinventory.product.controller.ProductController;
import com.org.sisinventory.product.view.ViewCrudProduct;
import com.org.sisinventory.service.ValidateNumbers;

public class MainManagementInvoice {

    public static void MenuCustomerManagement(ViewCrudInvoice viewCrudInvoice, int option, CustomerController customerController, ViewCrudCliente viewCrudCliente,
                                              ProductController productController, ViewCrudProduct viewCrudProduct) {
        int optionSubMenu;
        do {

            do {
                ShowMainMenu.SubmenuInvoice("Facturas");
                optionSubMenu = ValidateNumbers.capturarEntero("Digite la Opcion a realizar de Facturas.");

                if (optionSubMenu < ConstantMain.EXIT || optionSubMenu > ConstantMain.LIST) {
                    System.out.println("Digíte un valor entre 0 y 4");
                    ValidateNumbers.continuar();
                }
            } while (optionSubMenu < ConstantMain.EXIT || optionSubMenu > ConstantMain.LIST);

            if (optionSubMenu == ConstantMain.EXIT) {
                break;
            }

            switch (optionSubMenu) {

                case ConstantMain.CREATE:
                    viewCrudInvoice.viewSaveInvoice(customerController,viewCrudCliente,productController,viewCrudProduct);
                    break;
                case ConstantMain.LIST_INVOICE:
                    viewCrudInvoice.viewList(productController,customerController);
                    break;
            }


        } while (option != ConstantMain.EXIT);
    }
}
