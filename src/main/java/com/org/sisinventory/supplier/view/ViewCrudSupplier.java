package com.org.sisinventory.supplier.view;

import com.org.sisinventory.product.model.Product;
import com.org.sisinventory.service.ValidateNumbers;
import com.org.sisinventory.supplier.controller.SupplierController;
import com.org.sisinventory.supplier.model.Supplier;

import java.util.List;

public class ViewCrudSupplier {

    SupplierController supplierController;

    public ViewCrudSupplier(SupplierController supplierController) {

        this.supplierController = supplierController;
    }

    public void listSuppielView() {
        if (supplierController.listController().isEmpty()) {
            System.out.println("Lista aun no contiene ningún proveedor");
        } else {
            supplierController.listController().forEach(System.out::println);
        }
    }

    public void searchSupplierView() {
        int ID = ValidateNumbers.capturarEntero("Ingrese id de Proveedor");

        Supplier supplier = this.supplierController.searchIDController(ID);

        if (supplier != null){
            System.out.println(supplier);
        }else {
            System.out.println("Proveedor no encontrado, intente de nuevo");
        }
    }

    public void saveSupplierView(){
        Supplier supplier;
        int telephoneNumbers = 0;
        String identification = "";
        int IDNumbers;
        do {
            IDNumbers = ValidateNumbers.capturarEntero("Dígite un número entero");

            if (IDNumbers <= 0) {
                System.out.println("El identificador debe de ser un número entero positivo");
                IDNumbers = 0;
                continue;
            }

            supplier = supplierController.searchIDController(IDNumbers);  // irepoCopy.searchCustomer(identification);

            if (supplier != null) {
                System.out.println("Ya existe otro proveedor con el número de cédula: %s. \n" + identification);
                IDNumbers = 0;
            }

        } while (IDNumbers <= 0);

        String name = ValidateNumbers.capturarCadenaCaracteres("Dígite nombres de proveedor nuevo");

        do {
            telephoneNumbers = ValidateNumbers.capturarEntero("Dígite número de telefono");
            if (telephoneNumbers <= 0) {
                System.out.println("Número de teléfono debe de ser un valor positivo");
            }

            String address = ValidateNumbers.capturarCadenaCaracteres("Dígite dirección del Proveedor nuevo");


            supplierController.saveSupplierController(IDNumbers, name,String.valueOf(telephoneNumbers), address);


        } while (telephoneNumbers <= 0);

    }

    public void updateSupplierVie(){
        Supplier supplier;
        int telephoneNumbers = 0;
        String identification = "";
        int IDNumbers;
        do {
            IDNumbers = ValidateNumbers.capturarEntero("Dígite un número entero");

            if (IDNumbers <= 0) {
                System.out.println("El identificador debe de ser un número entero positivo");
                IDNumbers = 0;
                continue;
            }
            supplier = supplierController.searchIDController(IDNumbers);  // irepoCopy.searchCustomer(identification);

            if (supplier != null) {
                String name = ValidateNumbers.capturarCadenaCaracteres("Dígite nombres de proveedor nuevo");

                do {
                    telephoneNumbers = ValidateNumbers.capturarEntero("Dígite número de telefono");
                    if (telephoneNumbers <= 0) {
                        System.out.println("Número de teléfono debe de ser un valor positivo");
                    }

                    String address = ValidateNumbers.capturarCadenaCaracteres("Dígite dirección del cliente nuevo");


                    supplierController.updateSupplierController(IDNumbers, name,String.valueOf(telephoneNumbers), address);


                } while (telephoneNumbers <= 0);

            }

        } while (IDNumbers <= 0);

    }

    public void deleteSupplierView(List<Product> productList){
        int ID = ValidateNumbers.capturarEntero("Ingrese id de Proveedor");

        Supplier supplier = this.supplierController.searchIDController(ID);

        if (supplier != null){
            Product verifi = checkProveedorIDProdcuct(productList,ID);
            if (verifi != null) {
                System.out.println("El proveedor no se puede eliminar porque tiene productos en existencia");
            }else{
                System.out.println("Proveedor " + supplier.getName() + " eliminado");
                supplierController.deleteSupplierController(supplier);

            }

        }else {
            System.out.println("Proveedor no encontrado, intente de nuevo");
        }


    }

    //Método que verifica si el proveedor tiene productos en el inventario
    private Product checkProveedorIDProdcuct(List<Product> productList, Integer idProv){
        Product resultado = null;
        for (Product product: productList){
            if (product.getIdSuplier() == idProv){
                resultado = product;
            }
        }
        return resultado;


    }

}
