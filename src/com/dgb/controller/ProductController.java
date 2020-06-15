package com.dgb.controller;

import com.dgb.model.Product;
import com.dgb.model.ProductCrud;
import com.dgb.model.ProductCrudImp;
import com.dgb.utils.Constants;
import com.dgb.utils.Utils;
import com.dgb.view.MsgView;
import com.dgb.view.ProductView;

import java.util.List;

public class ProductController {
    ProductCrudImp productCrudImpl;
    ProductView productView;
    PageController pageController;

    public ProductController() {
        productCrudImpl = new ProductCrudImp();
        productView = new ProductView();
        pageController= new PageController();
    }
    public void displayProduct() {
        pageController.totalRecord();
        productView.displayAllProduct(productCrudImpl.read(ProductView.currentPage,ProductView.rowSet));
    }

    public void insertProduct(){
        List<Product> products=productCrudImpl.read(ProductView.currentPage,ProductView.rowSet);
        int id=0;
        for(Product product:products){
            if(product.getId()>id)
                id=product.getId();
        }
        Product product = productView.addProduct(id+1);
        if (product!=null) {
            Product productInserted = productCrudImpl.write(product);
            if(productInserted!=null){
                productView.showProduct(productInserted);
                MsgView.showMessage(Constants.INSERT_DATA_SUCCESS);
            }else
                MsgView.showMessage(Constants.INSERT_DATA_FAIL);
        }
        else
            MsgView.showMessage(Constants.INSERT_DATA_FAIL);
        Utils.pressKeyEnter(Constants.PRESS_KEY_ENTER);
    }
    public void readProduct(){
        int id=productView.readProductView();
        if (id!=0) {
            Product product = productCrudImpl.readByID(id);
            if(product!=null){
                productView.showProduct(product);
                //MsgView.showMessage(Constants.PRODUCT_IS_FOUND);
            }else
                MsgView.showMessage(Constants.PRODUCT_NOT_FOUND);
        }else
            MsgView.showMessage(Constants.PRODUCT_NOT_FOUND);
    }
}
