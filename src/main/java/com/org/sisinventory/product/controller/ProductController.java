package com.org.sisinventory.product.controller;


import com.org.sisinventory.product.model.Product;
import com.org.sisinventory.product.repository.iRepositoryProduct;

import java.util.List;

public class ProductController{

    iRepositoryProduct iRepositoryProduct;

    public ProductController(iRepositoryProduct iRepositoryProduct) {

        this.iRepositoryProduct = iRepositoryProduct;
    }
    //Ver lista de productos
    public List<Product> productListController(){
        return iRepositoryProduct.list();
    }

    public List<Product> listController (){
       return iRepositoryProduct.list();
    }

    public Product searchProductIDController(Integer idProduct){
        return iRepositoryProduct.searchID(idProduct);
    }

    public void saveProductController(Product product){

        iRepositoryProduct.save(product);
    }

    public void updateProductController(Product product){
        iRepositoryProduct.update(product);
    }

    public void deleteProductController(Product product){
        iRepositoryProduct.delete(product);
    }


}
