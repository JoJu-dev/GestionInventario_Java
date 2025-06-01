package com.org.sisinventory.customer.view;

import com.org.main.optionsmenu.ConstantMain;
import com.org.main.optionsmenu.ShowMainMenu;
import com.org.sisinventory.service.ValidateNumbers;

public class MainManagementCustomer {

    public static void MenuCustomerManagement(ViewCrudCliente viewCrudCliente, int option) {
        int optionSubMenu;
        do {

            do {
                ShowMainMenu.Submenu("CLIENTES");
                optionSubMenu = ValidateNumbers.capturarEntero("Digite la Opcion a realizar de clientes.");

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
                    viewCrudCliente.savedCustomerView();
                    break;

                case ConstantMain.SEARCHID:
                    viewCrudCliente.searchIDCustomerView();
                    break;

                case ConstantMain.UPDATE:
                    viewCrudCliente.UpdateCustomerView();
                    break;
                case ConstantMain.DELETE:
                    viewCrudCliente.removeCustomerView();
                    break;
                case ConstantMain.LIST:
                    viewCrudCliente.listCustomerView();
                    break;
            }


        } while (option < ConstantMain.EXIT || option > ConstantMain.LIST);
    }
}
