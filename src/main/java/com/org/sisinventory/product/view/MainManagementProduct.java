package com.org.sisinventory.product.view;

import com.org.main.optionsmenu.ConstantMain;
import com.org.main.optionsmenu.ShowMainMenu;
import com.org.sisinventory.invoice.controller.InvoiceController;
import com.org.sisinventory.service.ValidateNumbers;
import com.org.sisinventory.supplier.model.Supplier;

import java.util.List;

public class MainManagementProduct {

    public static void MenuProductManagement(ViewCrudProduct viewCrudProduct, int option, List<Supplier>supplierList, InvoiceController invoiceController) {
        int optionSubMenu;
        do {

            do {
                ShowMainMenu.Submenu("PRODUCTOS");
                optionSubMenu = ValidateNumbers.capturarEntero("Digite la Opcion a realizar de Productos.");


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
                    viewCrudProduct.saveProductView(supplierList);
                    break;

                case ConstantMain.SEARCHID:
                    viewCrudProduct.listSearchProductID();
                    break;

                case ConstantMain.UPDATE:
                    viewCrudProduct.updateProductView();
                    break;
                case ConstantMain.DELETE:
                    viewCrudProduct.deleteProductView(invoiceController);
                    break;
                case ConstantMain.LIST:
                    viewCrudProduct.listView();
                    break;
            }


        } while (option != ConstantMain.EXIT);




    }
}
