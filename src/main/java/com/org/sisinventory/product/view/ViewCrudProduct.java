package com.org.sisinventory.product.view;

import com.org.sisinventory.product.controller.ProductController;
import com.org.sisinventory.product.model.Product;
import com.org.sisinventory.service.ValidateNumbers;




public class ViewCrudProduct {

    ProductController productController;

    public ViewCrudProduct(ProductController productController) {
        this.productController = productController;
    }

    public void listView() {
        if (productController.listController().isEmpty()) {
            System.out.println("Aun no existe producto en el almacen");
        } else {
            productController.listController().forEach(System.out::println);
        }
    }

    public void listSearchProductID() {
        int id = ValidateNumbers.capturarEntero("Introduzca el id del producto");

        Product product = productController.searchProductIDController(id);

        if (product != null) {
            System.out.println(product);
        } else {
            System.out.println("Producto no encontrado");
        }
    }

    public void saveProductView() {
        int idProduct = 0;
        do {
            idProduct = ValidateNumbers.capturarEntero("Ingrese id de  Producto");

            if (idProduct <= 0) {
                System.out.println("El identificador debe de ser un número entero positivo");
                idProduct = 0;
                continue;
            }

            Product prod = productController.searchProductIDController(idProduct);

            if (prod != null) {
                System.out.println("Ya existe otro producto con el número de ID: %s. \n" + idProduct);
                idProduct = 0;
            }

        } while (idProduct <= 0);
        String name = ValidateNumbers.capturarCadenaCaracteres("Ingrese nombre de producto");
        String description = ValidateNumbers.capturarCadenaCaracteres("Ingrese descripción de producto");
        Double purcharsePrice = 0.0;
        do {
            purcharsePrice = ValidateNumbers.capturaNumeroReal("Agrege precio de Compra del producto");

            if (purcharsePrice <= 0.0) {
                System.out.println("El precio de compra debe de ser un número positivo");
                purcharsePrice = 0.0;
                continue;
            }
        } while (purcharsePrice <= 0.0);
        Double salePrice = 0.0;
        do {
            salePrice = ValidateNumbers.capturaNumeroReal("Agrege precio de venta del producto");

            if (salePrice <= 0.0) {
                System.out.println("El precio de compra debe de ser un número positivo");
                salePrice = 0.0;
                continue;
            }
        } while (salePrice <= 0.0);
        Integer amount = 0;
        do {
            amount = ValidateNumbers.capturarEntero("Agrege una cantidad del producto");

            if (amount <= 0) {
                System.out.println("La cantidad del producto debe de ser un número positivo");
                amount = 0;
                continue;
            }

        } while (amount <= 0);
        Integer amountMinStock = 0;
        do {
            amountMinStock = ValidateNumbers.capturarEntero("Agrege cantidad mínima de producto ");

            if (amountMinStock <= 0) {
                System.out.println("La cantidad mínima del producto debe de ser un número positivo");
                amountMinStock = 0;
                continue;
            }
        } while (amountMinStock <= 0);
        Integer idSupplier = 0;
        do {
            idSupplier = ValidateNumbers.capturarEntero("Agrege un id de proveedor de producto ");

            if (idSupplier <= 0) {
                System.out.println("El id de proveedor debe de ser un número positivo");
                idProduct = 0;
                continue;
            }

        } while (idSupplier <= 0);

        Product product = new Product(idProduct, name, description, purcharsePrice, salePrice, amount, amountMinStock, idSupplier);
        productController.saveProductController(product);

    }

    public void updateProductView() {
        int idProduct = 0;

        String IDProduct = null;
        do {
            idProduct = ValidateNumbers.capturarEntero("Ingrese id de  Producto");

            if (idProduct <= 0) {
                System.out.println("El identificador debe de ser un número entero positivo");
                idProduct = 0;
                continue;
            }

            Product prod = productController.searchProductIDController(idProduct);

            if (prod == null) {
                String name = ValidateNumbers.capturarCadenaCaracteres("Ingrese nombre de producto");
                String description = ValidateNumbers.capturarCadenaCaracteres("Ingrese descripción de producto");
                Double purcharsePrice = 0.0;
                do {
                    purcharsePrice = ValidateNumbers.capturaNumeroReal("Agrege precio de Compra del producto");

                    if (purcharsePrice <= 0.0) {
                        System.out.println("El precio de compra debe de ser un número positivo");
                        purcharsePrice = 0.0;
                        continue;
                    }
                } while (purcharsePrice <= 0.0);
                Double salePrice = 0.0;
                do {
                    salePrice = ValidateNumbers.capturaNumeroReal("Agrege precio de venta del producto");

                    if (salePrice <= 0.0) {
                        System.out.println("El precio de compra debe de ser un número positivo");
                        salePrice = 0.0;
                        continue;
                    }
                } while (salePrice <= 0.0);
                Integer amount = 0;
                do {
                    amount = ValidateNumbers.capturarEntero("Agrege una cantidad del producto");

                    if (amount <= 0) {
                        System.out.println("La cantidad del producto debe de ser un número positivo");
                        amount = 0;
                        continue;
                    }

                } while (amount <= 0);
                Integer amountMinStock = 0;
                do {
                    amountMinStock = ValidateNumbers.capturarEntero("Agrege cantidad mínima de producto ");

                    if (amountMinStock <= 0) {
                        System.out.println("La cantidad mínima del producto debe de ser un número positivo");
                        amountMinStock = 0;
                        continue;
                    }
                } while (amountMinStock <= 0);
                Integer idSupplier = 0;
                do {
                    idSupplier = ValidateNumbers.capturarEntero("Agrege un id de proveedor de producto ");

                    if (idSupplier <= 0) {
                        System.out.println("El id de proveedor debe de ser un número positivo");
                        idProduct = 0;
                        continue;
                    }

                } while (idSupplier <= 0);
                Product product = new Product(idProduct, name, description, purcharsePrice, salePrice, amount, amountMinStock, idSupplier);
                productController.updateProductController(product);
            }

        } while (idProduct <= 0);

    }
    public void deleteProductView(){
        int id = ValidateNumbers.capturarEntero("Introduzca el id del producto");

        Product product = productController.searchProductIDController(id);

        if (product != null) {
            productController.deleteProductController(product);
            System.out.println("Producto eliminado");
        } else {
            System.out.println("Producto no encontrado");
        }
    }



}
