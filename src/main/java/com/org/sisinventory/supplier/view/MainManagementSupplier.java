package com.org.sisinventory.supplier.view;

import com.org.main.optionsmenu.ConstantMain;
import com.org.main.optionsmenu.ShowMainMenu;
import com.org.sisinventory.customer.view.ViewCrudCliente;
import com.org.sisinventory.service.ValidateNumbers;

public class MainManagement {

    public static void MenuCustomerManagement(ViewCrudSupplier viewCrudSupplier, int option) {
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
                    viewCrudSupplier.saveSupplierVie();
                    break;

                case ConstantMain.SEARCHID:
                    viewCrudSupplier.searchSupplierView();
                    break;

                case ConstantMain.UPDATE:
                    viewCrudSupplier.updateSupplierVie();
                    break;
                case ConstantMain.DELETE:
                    viewCrudSupplier.deleteSupplierView();
                    break;
                case ConstantMain.LIST:
                    viewCrudSupplier.listSuppielView();
                    break;
            }


        } while (option < ConstantMain.EXIT || option > ConstantMain.LIST);
    }
}
