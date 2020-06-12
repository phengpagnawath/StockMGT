package com.dgb.controller;

import com.dgb.model.Product;
import com.dgb.model.ProductCrud;
import com.dgb.model.ProductCrudImp;
import com.dgb.view.ProductView;

import java.util.List;

public class ProductController {
    ProductCrudImp productCrudImpl;
    ProductView productView;

    public ProductController() {
        productCrudImpl = new ProductCrudImp();
        productView = new ProductView();
    }

    public void displayProduct() {
        productView.displayAllProduct(productCrudImpl.read());
    }

    public void insertProduct(){
        List<Product> products=productCrudImpl.read();
        int id=0;
        for(Product product:products){
            if(product.getId()>id)
                id=product.getId();
        }
        Product product = productView.addProduct(id);
        Product productInserted=productCrudImpl.write(product);
        System.out.println(productInserted);
    }
}
