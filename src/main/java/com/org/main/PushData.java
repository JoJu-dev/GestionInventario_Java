package com.org.main;

import com.org.sisinventory.Report.ReadDataInventory;
import com.org.sisinventory.customer.controller.CustomerController;
import com.org.sisinventory.invoice.controller.InvoiceController;
import com.org.sisinventory.product.controller.ProductController;
import com.org.sisinventory.supplier.controller.SupplierController;

public class PushData {

    public static void PushData(CustomerController customerController, InvoiceController invoiceController, ProductController productController, SupplierController supplierController){
        ReadDataInventory.CustomerInverntaryDataRead(customerController);
        ReadDataInventory.InvoiceInverntaryDataRead(invoiceController);
        ReadDataInventory.ProductInventoryDataRead(productController);
        ReadDataInventory.SupplierInventoryData(supplierController);
    }

}
