package com.org.sisinventory.product.view;

import com.org.main.optionsmenu.ConstantMain;
import com.org.main.optionsmenu.ShowMainMenu;
import com.org.sisinventory.service.ValidateNumbers;

public class MainManagementProduct {

    public static void MenuCustomerManagement(ViewCrudProduct viewCrudProduct, int option) {
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
                    viewCrudProduct.saveProductView();
                    break;

                case ConstantMain.SEARCHID:
                    viewCrudProduct.listSearchProductID();
                    break;

                case ConstantMain.UPDATE:
                    viewCrudProduct.updateProductView();
                    break;
                case ConstantMain.DELETE:
                    viewCrudProduct.deleteProductView();
                    break;
                case ConstantMain.LIST:
                    viewCrudProduct.listView();
                    break;
            }


        } while (option < ConstantMain.EXIT || option > ConstantMain.LIST);
    }
}
