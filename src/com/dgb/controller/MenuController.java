package com.dgb.controller;


import com.dgb.utils.*;
import com.dgb.view.MsgView;
import com.dgb.view.ProductView;

import java.util.Scanner;

public class MenuController {
    ProductController productController=new ProductController();
    PageController pageController = new PageController();
    public int row;

    public void menu(String choice) {
        ProductView.rowSet = FileIO.readFile();

        switch (choice.toLowerCase()) {
            case "*": {
                productController.displayProduct();
                break;
            }
            case "w":{
                productController.insertProduct();
                break;
            }
            case "r":{
                productController.readProduct();
                break;
            }
            case "u":{
                productController.updateProduct();
                break;
            }
            case "o":{
                row= Utils.inputInteger(Constants.SET_PAGE_ROW);
                FileIO.writeFile(row);
                System.out.println(MsgConstants.MSG_SUCCESS_SET_ROW);
                break;
            }
            case "g":{
                pageController.gotoPageNum();
                break;
            }
            case "f":{
                pageController.gotoFirstPage();
                break;
            }
            case "p":{
                pageController.gotoPrevious();
                break;
            }
            case "l":{
                pageController.gotoLast();
                break;
            }
            case "n":{
                pageController.gotoNext();
                break;
            }
            case "s":{
                productController.searchProduct();
                break;
            }
            case "e":{
                System.exit(0);
            }
            default:{
                MsgView.showMessage(Constants.INPUT_WRONG_TYPE);
            }
        }
        Utils.pressKeyEnter(Constants.PRESS_KEY_ENTER);
    }
}
