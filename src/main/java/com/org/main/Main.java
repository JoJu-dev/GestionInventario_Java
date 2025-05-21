package com.org.principal;

import com.org.principal.optionsmenu.*;
import com.org.sisinventarios.client.model.Client;
import com.org.sisinventarios.invoice.model.Invoice;
import com.org.sisinventarios.product.model.Product;
import com.org.sisinventarios.suplier.model.Supplier;

import java.util.ArrayList;
import java.util.List;

public class Main {
    private static final int SALIR = 0;

    public static void main(String[] args) {
        List<Client> clientList = new ArrayList<>();
        List<Supplier> supplierList = new ArrayList<>();
        List<Product> productList = new ArrayList<>();
        List<Invoice> invoiceList = new ArrayList<>();

        int opcion;

        do {
            ShowMainMenu.menuPrincipal();
           do {

               opcion = ValidarNumeros.capturarEntero("Dígite la opción a realizar: ");

           }while(opcion < SALIR  || opcion > 4);
        } while (opcion != SALIR);

    }
}