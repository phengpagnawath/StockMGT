package com.dgb.view;

import com.dgb.utils.Constants;
import com.dgb.utils.SQLConstants;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class MainView {
    CellStyle cellCenterStyle = new CellStyle(CellStyle.HorizontalAlign.center);

    public void mainView() {
        Table tableHeader = new Table(1, BorderStyle.BLANKS);
        tableHeader.setColumnWidth(0, 150, 160);
        tableHeader.addCell(Constants.WELCOME, cellCenterStyle);
        tableHeader.addCell(Constants.DGB_ROW1, cellCenterStyle);
        tableHeader.addCell(Constants.DGB_ROW2, cellCenterStyle);
        tableHeader.addCell(Constants.DGB_ROW3, cellCenterStyle);
        tableHeader.addCell(Constants.DGB_ROW4, cellCenterStyle);
        tableHeader.addCell(Constants.DGB_ROW5, cellCenterStyle);
        tableHeader.addCell(Constants.DGB_ROW6, cellCenterStyle);
        System.out.println(tableHeader.render());
        System.out.println(Constants.LINE);

    }




    public static void main(String[] args) {
        MainView mainView = new MainView();
        MenuView menuView=new MenuView();
        mainView.mainView();
        menuView.menuView();
    }
}
