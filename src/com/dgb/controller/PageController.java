package com.dgb.controller;

import com.dgb.model.Product;
import com.dgb.model.ProductCrudImp;
import com.dgb.utils.Constants;
import com.dgb.utils.Utils;
import com.dgb.view.ProductView;

import java.util.List;

public class PageController {
    ProductView productView;
    ProductCrudImp productCrudImp;

    public PageController(){
        productView=new ProductView();
        productCrudImp=new ProductCrudImp();
    }

    public void gotoPage(){
        int pageNum = Utils.inputInteger(Constants.ENTER+Constants.PAGE_NUMBER);
        ProductView.currentPage=pageNum;
        int offset=(pageNum-1)*ProductView.rowSet;
        productView.displayAllProduct(productCrudImp.read(offset,ProductView.rowSet));
    }
    public void totalRecord(){
        ProductView.totalRecord=productCrudImp.count();
    }
}
