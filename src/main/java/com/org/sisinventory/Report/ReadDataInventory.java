package com.org.sisinventory.Report;

import com.org.sisinventory.customer.controller.CustomerController;
import com.org.sisinventory.customer.model.Customer;
import com.org.sisinventory.invoice.controller.InvoiceController;
import com.org.sisinventory.invoice.model.Invoice;
import com.org.sisinventory.product.controller.ProductController;
import com.org.sisinventory.product.model.Product;
import com.org.sisinventory.supplier.controller.SupplierController;
import com.org.sisinventory.supplier.model.Supplier;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class ReadDataInventory {
    private static String[] HEADERS_CUSTOMER = {"identificador", "nombres", "apellidos", "telefono", "direccion", "correo"};
    private static String[] HEADERS_INVOICE = {"ID", "Fecha", "idCliente", "Impuesto", "total", "idsProductos"};
    private static String[] HEADERS_SUPPLIER = {"identificador", "nombres", "telefono", "direccion"};
    private static String[] HEADERS_PRODUCT = {"ID", "nombre","descripcion","precio compra", "precio venta","cantidad","cantidad minima","IDproveedor"};


    //READ DATA
    public static void CustomerInverntaryDataRead(CustomerController customerController) {

        Path ruteFile = Paths.get(ConstantReport.FILE_CSV_CUSTOMER); //obtenemos la ruta del archivo

        if (Files.exists(ruteFile)) { //pregunta si el archivo existe
            try {

                Reader reader = Files.newBufferedReader(ruteFile); // crea un lector de carácteres
                CSVParser csvParser = new CSVParser(reader,  CSVFormat.DEFAULT.builder().
                        setHeader(HEADERS_CUSTOMER).setDelimiter(ConstantReport.SEPARATOR).setSkipHeaderRecord(true).get());

                Customer customer;
                for (CSVRecord r : csvParser.getRecords()) {//getRecords emite la primera fila de encabezado al leer el archivo
                    customer = new Customer(r.get("identificador"), r.get("nombres"), r.get("apellidos"), r.get("telefono"), r.get("direccion"), r.get("correo"));
                    customerController.listController().add(customer);
                }

                csvParser.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
    public static void ProductInventoryDataRead(ProductController productController) {
        //List<Customer> customerList;
        Path ruteFile = Paths.get(ConstantReport.FILE_CSV_PRODUCT); //obtenemos la ruta del archivo

        if (Files.exists(ruteFile)) { //pregunta si el archivo existe
            try {

                Reader reader = Files.newBufferedReader(ruteFile); // crea un lector de carácteres
                CSVParser csvParser = new CSVParser(reader,  CSVFormat.DEFAULT.builder().
                        setHeader(HEADERS_PRODUCT).setDelimiter(ConstantReport.SEPARATOR).setSkipHeaderRecord(true).get());

                Product product;

                for (CSVRecord r : csvParser.getRecords()) {//getRecords emite la primera fila de encabezado al leer el archivo
                    product = new Product(Integer.parseInt(r.get("ID")),r.get("nombre"), r.get("descripcion"), Double.parseDouble(r.get("precio compra")),
                            Double.parseDouble(r.get("precio venta")), Integer.parseInt(r.get("cantidad")), Integer.parseInt(r.get("cantidad minima")), Integer.parseInt(r.get("IDproveedor")));
                    productController.listController().add(product);
                }
                csvParser.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    public static void InvoiceInverntaryDataRead(InvoiceController invoiceController) {

        Path ruteFile = Paths.get(ConstantReport.FILE_CSV_INVOICE);

        if (Files.exists(ruteFile)) {
            try {

                Reader reader = Files.newBufferedReader(ruteFile);
                CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT.builder().
                        setHeader(HEADERS_INVOICE).setDelimiter(ConstantReport.SEPARATOR).setSkipHeaderRecord(true).get());
                Invoice invoice;
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

                for (CSVRecord r : csvParser) {
                    invoice = new Invoice();
                    invoice.setIdCliente(r.get("ID"));
                   try{
                       invoice.setDate(simpleDateFormat.parse(r.get("Fecha")));
                   }catch (ParseException e){
                       e.printStackTrace();
                   }
                    invoice.setIdCliente(r.get("idCliente"));
                    invoice.setTax(Double.parseDouble(r.get("Impuesto")));
                    invoice.setTotal(Double.parseDouble(r.get("total")));
                    String[] idsProduct = StringUtils.split(r.get("idsProductos"), ","); //aca se utiliza la libreria Apache Commons Lang
                    invoice.setIdsProductNews(idsProduct);

                    invoiceController.listInvoiceController().add(invoice);
                }
                csvParser.close();
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Error: " + e.getMessage());
            }
        }

    }

    public static void SupplierInventoryData(SupplierController supplierController){
        Path file = Paths.get(ConstantReport.FILE_CSV_SUPPLIER);

        if (Files.exists(file)){
            try {
                Reader reader = Files.newBufferedReader(file);
                CSVParser csvParser = new CSVParser(reader,CSVFormat.DEFAULT.builder().setHeader(HEADERS_SUPPLIER).
                        setDelimiter(ConstantReport.SEPARATOR).setSkipHeaderRecord(true).get());
                Supplier supplier;
                for (CSVRecord r: csvParser){
                    supplier = new Supplier(Integer.parseInt(r.get("identificador")), r.get( "nombres"),r.get("telefono"),r.get("direccion"));
                    supplierController.listController().add(supplier);
                }
                csvParser.close();

            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error: " + e.getMessage());
            }
        }

    }
}
