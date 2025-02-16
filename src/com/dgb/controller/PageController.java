package com.dgb.controller;

import com.dgb.model.Product;
import com.dgb.model.ProductCrudImp;
import com.dgb.utils.Constants;
import com.dgb.utils.Utils;
import com.dgb.view.MsgView;
import com.dgb.view.ProductView;

public class PageController {
    ProductView productView;
    ProductCrudImp productCrudImp;
    public int pageNum = 1;
    public int limitPage;

    public PageController() {
        productView = new ProductView();
        productCrudImp = new ProductCrudImp();
        totalRecord();
    }

    public void setLimitPage() {
        if (ProductView.totalRecord % ProductView.rowSet == 0)
            limitPage = ProductView.totalRecord / ProductView.rowSet;
        else
            limitPage = ProductView.totalRecord / ProductView.rowSet + 1;
    }

    public void gotoPageNum() {
        pageNum = Utils.inputInteger(Constants.ENTER + Constants.PAGE_NUMBER);
        setLimitPage();
        if (pageNum >= 1 && pageNum < limitPage)
            gotoPage(pageNum);
        else if (pageNum < 1) {
            MsgView.showMessage(Constants.PAGE_CANNOT_DISPLAY);
        } else {
            MsgView.showMessage(Constants.OUT_OF_LIMIT);
            //gotoLast();
        }
    }

    public void gotoFirstPage() {
        pageNum = 1;
        gotoPage(pageNum);
    }

    public void gotoPrevious() {
        System.out.println(pageNum);
        if (pageNum == 1)
            MsgView.showMessage(Constants.ALREADY_FIRST_PAGE);
        else
            pageNum = pageNum - 1;
        gotoPage(pageNum);
    }

    public void gotoLast() {
        setLimitPage();
        pageNum = limitPage;
        gotoPage(pageNum);
    }

    public void gotoNext() {
        setLimitPage();
        if (pageNum < limitPage)
            pageNum = pageNum + 1;
        else
            MsgView.showMessage(Constants.ALREADY_LAST_PAGE);
        gotoPage(pageNum);
    }


    public void gotoPage(int pageNum) {

        ProductView.offset = pageNum;
        ProductView.currentPage = pageNum;
        ProductView.offset = (pageNum - 1) * ProductView.rowSet;
        //System.out.println(ProductView.offset +"=(" + pageNum + " -1)*"+ProductView.rowSet);
        productView.displayAllProduct(productCrudImp.read(ProductView.offset, ProductView.rowSet));
    }

    public void totalRecord() {
        ProductView.totalRecord = productCrudImp.count();
    }
    /*
    public void totalSearchRecord(String search){
        ProductView.totalRecord=productCrudImp.countBySearch(search);
    }
    */
}
