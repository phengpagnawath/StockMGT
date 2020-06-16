package com.dgb.controller;

import com.dgb.model.Product;
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
        productView.displayAllProduct(productCrudImpl.read(ProductView.offset,ProductView.rowSet));
    }
    public void searchProduct(){
        String name = productView.searchName();
        //pageController.totalSearchRecord(name);
        List<Product> productSearch=productCrudImpl.searchByName(name);
        if(productSearch.size()>0) {
            ProductView.totalRecord = productCrudImpl.countBySearch(name);
            productView.displayAllProduct(productSearch);
        }else {
            MsgView.showMessage(Constants.PRODUCT_NAME_NOT_FOUND);
        }
    }

    public void insertProduct(){
        List<Product> products=productCrudImpl.read(ProductView.offset,ProductView.rowSet);
        int id = productCrudImpl.maxID()+1;
        Product product = productView.addProduct(id);
        if (product!=null) {
            Product productInserted = productCrudImpl.create(product);
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
        if (id>0) {
            Product product = productCrudImpl.readByID(id);
            if(product!=null){
                MsgView.showMessage(Constants.PRODUCT_UPDATED);
                productView.showProduct(product);
                //MsgView.showMessage(Constants.PRODUCT_IS_FOUND);
            }else
                MsgView.showMessage(Constants.PRODUCT_NOT_FOUND);
        }else
            MsgView.showMessage(Constants.PRODUCT_NOT_FOUND);
    }

    public void updateProduct(){
        int id=productView.readProductView();
        if(id>0){
            Product oldProduct = productCrudImpl.readByID(id);
            if (oldProduct!=null){
                MsgView.showMessage(Constants.UPDATE_PRODUCT);
                Product newProduct = productView.addProduct(id);
                if (newProduct!=null) {
                    Product product =productCrudImpl.update(newProduct);
                    if (product!=null) {
                        productView.showProduct(product);
                    }else
                        MsgView.showMessage(Constants.UPDATE_DATA_FAIL);
                }else
                    MsgView.showMessage(Constants.PRODUCT_NOT_FOUND);
            }else
                MsgView.showMessage(Constants.PRODUCT_NOT_FOUND);
        }else
            MsgView.showMessage(Constants.INPUT_INCORRECT);
    }
}
