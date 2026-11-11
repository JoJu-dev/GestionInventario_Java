package com.org.sisinventory.supplier.view;

import com.org.main.optionsmenu.ConstantMain;
import com.org.main.optionsmenu.ShowMainMenu;
import com.org.sisinventory.product.model.Product;
import com.org.sisinventory.service.ValidateNumbers;

import java.util.List;

public class MainManagementSupplier {

    public static void MenuCustomerManagement(ViewCrudSupplier viewCrudSupplier, int option, List<Product> productList) {
        int optionSubMenu;
        do {

            do {
                ShowMainMenu.Submenu("Proveedores");
                optionSubMenu = ValidateNumbers.capturarEntero("Digite la Opcion a realizar de Proveedores.");

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
                    viewCrudSupplier.saveSupplierView();
                    break;

                case ConstantMain.SEARCHID:
                    viewCrudSupplier.searchSupplierView();
                    break;

                case ConstantMain.UPDATE:
                    viewCrudSupplier.updateSupplierVie();
                    break;
                case ConstantMain.DELETE:
                    viewCrudSupplier.deleteSupplierView(productList);
                    break;
                case ConstantMain.LIST:
                    viewCrudSupplier.listSuppielView();
                    break;
            }


        } while (option != ConstantMain.EXIT);
    }
}
