package com.dgb.controller;


import com.dgb.utils.*;
import com.dgb.view.ProductView;

import java.util.Scanner;

public class MenuController {
    ProductController productController=new ProductController();
    public int row;
    Scanner scanner=new Scanner(System.in);

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
            case "o":{
                row= Utils.inputInteger(Constants.SET_PAGE_ROW);
                FileIO.writeFile(row);
                System.out.println(MsgConstants.MSG_SUCCESS_SET_ROW);
                //ProductView.rowSet =row;
                break;
            }
            default:{
                System.exit(0);
            }
        }
    }
}
