package com.org.sisinventory.invoice.view;


import com.org.main.optionsmenu.ConstantMain;
import com.org.main.optionsmenu.ShowMainMenu;
import com.org.sisinventory.customer.controller.CustomerController;
import com.org.sisinventory.customer.model.Customer;
import com.org.sisinventory.customer.view.ViewCrudCliente;
import com.org.sisinventory.invoice.controller.InvoiceController;
import com.org.sisinventory.invoice.model.Invoice;
import com.org.sisinventory.product.controller.ProductController;
import com.org.sisinventory.product.model.Product;
import com.org.sisinventory.product.view.ViewCrudProduct;
import com.org.sisinventory.service.ValidateNumbers;

import java.util.ArrayList;
import java.util.List;

public class ViewCrudInvoice {

    // echale un ojo a como calcular el total del producto que se esta comprando, y si podes suma la cantidad.
    //ve si podes crear el array de ids para codigo fuera de la funcion y asi capturar la cantidad vendida por cada producto 1 tortillas vendidad 2
    InvoiceController invoiceController;

    public ViewCrudInvoice(InvoiceController invoiceController) {

        this.invoiceController = invoiceController;
    }

    public void viewList(ProductController productController,CustomerController customerController) {
        if (this.invoiceController.listInvoiceController().isEmpty()) {
            System.out.println("Lista de facturas esta vacia");
        } else {
            System.out.println("Datos Factura");

            for (Invoice invoice : this.invoiceController.listInvoiceController()) {
                System.out.println("ID " + invoice.getIdInvoice() + "\n " + "Fecha" + invoice.getDate() + "\n" +
                        " Total Factura " + invoice.getTotal() + " \n\n");

                Customer customer = customerController.SearchCustomerIDController(Integer.valueOf(invoice.getIdCliente()));
                System.out.println("Datos del Cliente");
                System.out.println("CUI "+ invoice.getIdCliente() +"\n" + "Nombre: Cliente" + customer.getName() + customer.getLastName() +"\n\n");

                System.out.println("Productos Comprados.");
                if (invoice.getProducts().length <= 0) {
                    System.out.println("No se han agregado productos a la factura");
                } else {
                    System.out.println("ID Producto" + " |" + "Nombre" + " | " + "Cantidad" + " | " + "Precio" + " | " + "Total");
                    for (int i = 0; i <= invoice.getProducts().length - 1; i++) {
                        Product product = productController.searchProductIDController(invoice.getProducts()[i]);
                        System.out.println("Producto ID " +product.getId() + " \n " +"Nombre "+ product.getName() + " \n " + " Precio " + product.getSalePrice()+"\n\n");
                    }
                }
            }
        }

    }

    public void viewSaveInvoice(CustomerController customerController, ViewCrudCliente viewCrudCliente, ProductController productController, ViewCrudProduct viewCrudProduct) {
        Integer idCustomer = 0;
        System.out.println("LISTA DE CLIENTES");
        viewCrudCliente.listCustomerView();
        double tax = 0.0, total = 0, impuesto = 0;
        Integer idProduct = 0, cantidad = 0;

        List<Integer> idsProduct = new ArrayList<>();
        do {
            idCustomer = ValidateNumbers.capturarEntero("Ingrese el identificador del Cliente");
            if (idCustomer <= 0) {
                System.out.println("El identificador debe de ser un número entero positivo");
                idCustomer = 0;
                continue;
            }

            Customer customer = customerController.SearchCustomerIDController(idCustomer);

            if (customer != null) {
                break;
            } else {
                System.out.println("No existe un cliente con el número especifico");
            }
            ShowMainMenu.continuar();
        } while (idCustomer <= 0);


        do {
            System.out.println("LISTA DE PRODUCTOS");
            viewCrudProduct.listView();
            idProduct = ValidateNumbers.capturarEntero("Ingrese Identificador de producto");

            if ((idProduct == ConstantMain.EXIT) && (!idsProduct.isEmpty())) {
                break;
            }

            if (idProduct <= 0) {
                System.out.println("El identificador debe de ser un número entero positivo");
                idProduct = 0;
                continue;
            }


            Product product = productController.searchProductIDController(idProduct);

            if (product != null) {
                if (product.getAmount() > 0) {
                    do {

                        cantidad = ValidateNumbers.capturarEntero("Digite la cantidad a comprar de este producto");

                        if (cantidad <= 0) {
                            System.out.println("La cantidad debe de ser un número entero positivo");
                            cantidad = 0;
                            continue;
                        }

                        if (cantidad > product.getAmount()) {
                            System.out.println("MENSAJE: No hay cantidad suficiente de este producto. Cantidad disponible: " + product.getAmount());
                            continue;
                        }
                        break;
                    } while (true);
                    ShowMainMenu.continuar();
                    product.setAmount(product.getAmount() - cantidad);//este set amount hay que agregarlo a la lista de producto
                    total += product.getSalePrice() * cantidad;

                    idsProduct.add(idProduct);

                } else {
                    System.out.println("Este producto no cuenta con existencias.");
                }

            } else {
                System.out.println("No existe un producto con el ID especificado.");
            }
            System.out.println("Si ya no desea agregar productos precione  --->  0");


        } while (true);
        do {
            impuesto = ValidateNumbers.capturaNumeroReal("Digite el impuesto para esta factura");

            if (impuesto <= 0) {
                System.out.println("MENSAJE: El impuesto debe ser un número positivo.");
                continue;
            }

            if (impuesto > 100) {
                System.out.println("MENSAJE: El impuesto especificado no es un valor válido. Debe estar entre 1 y 100.");
                continue;
            }
         ShowMainMenu.continuar();
            break;
        } while (true);

        Invoice invoice = new Invoice(String.valueOf(impuesto), impuesto / 100.0);
        //  idsProduct.forEach(id -> invoice.addIdsProducts(id));
        for (Integer id : idsProduct) {
            invoice.addIdsProducts(id);
        }
        invoice.setTotal(total);

        invoiceController.saveInvoiceController(invoice);
    }

    //Print Customer data
    private Customer printCustomerForInvoice(List<Customer> customerList, Integer idCustomer) {
        Customer resultado = null;
        for (Customer c : customerList) {
            if (c.getID().equals(idCustomer)) {
                resultado = c;
                break;
            }
        }

        return null;
    }

    //Print Product Data
    private void printProductForInvoice(List<Product> productList, Integer idProduct) {
        for (Product p : productList) {
            if (p.getId().equals(idProduct)) {
                p.printProductForInvoice();
                break;
            } else {
                System.out.println("No se encontro ningun Producto agregado a la factura");
            }
        }
    }
}
