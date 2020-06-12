package com.dgb.view;

import com.dgb.model.Product;
import com.dgb.utils.Constants;
import com.dgb.utils.Utils;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;

import java.util.List;
import java.util.Scanner;

public class ProductView {
    public static int page, rowSet;
    Scanner scanner = new Scanner(System.in);
    CellStyle cellCenterStyle = new CellStyle(CellStyle.HorizontalAlign.center);
    CellStyle cellLeftStyle = new CellStyle(CellStyle.HorizontalAlign.left);
    CellStyle cellRightStyle = new CellStyle(CellStyle.HorizontalAlign.right);

    public void displayAllProduct(List<Product> products) {
        int col = 5;
        Table table = new Table(col);
        for (int i = 0; i < col; i++) {
            table.setColumnWidth(i, 29, 32);
        }
        table.addCell(Constants.ID, cellCenterStyle);
        table.addCell(Constants.NAME, cellCenterStyle);
        table.addCell(Constants.QTY, cellCenterStyle);
        table.addCell(Constants.UNIT_PRICE, cellCenterStyle);
        table.addCell(Constants.IMP_DATE, cellCenterStyle);
        for (int i = 0; i < rowSet; i++) {

            table.addCell(products.get(i).getId() + "", cellCenterStyle);
            table.addCell(products.get(i).getName(), cellCenterStyle);
            table.addCell(products.get(i).getQty() + "", cellCenterStyle);
            table.addCell(products.get(i).getPrice() + "", cellCenterStyle);
            table.addCell(products.get(i).getImpDate() + "", cellCenterStyle);
        }
        Table tableFooter = new Table(2, BorderStyle.HEAVY_TOP_AND_BOTTOM);
        for (int i = 0; i < 2; i++) {
            tableFooter.setColumnWidth(i, 74, 80);
        }
        page=products.size()/rowSet;
        tableFooter.addCell("Page: 1 of "+page, cellLeftStyle);
        tableFooter.addCell("Total record: " + products.size(), cellRightStyle);
        System.out.println(table.render());
        System.out.println(tableFooter.render());
    }

    public Product addProduct(int id){
        System.out.println(Constants.PRODUCT_ID+id);
        String name =scanner.nextLine();
        double unitPrice =Utils.inputDouble(Constants.PRODUCT_NAME);
        int qty=Utils.inputInteger(Constants.PRODUCT_QTY);
        return new Product(name,qty,unitPrice);
    }


}
