package com.dgb.view;

import com.dgb.controller.MenuController;
import com.dgb.utils.Constants;
import com.dgb.utils.Utils;
import org.nocrala.tools.texttablefmt.BorderStyle;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.ShownBorders;
import org.nocrala.tools.texttablefmt.Table;

public class MenuView {
    CellStyle cellCenterStyle = new CellStyle(CellStyle.HorizontalAlign.center);
    MenuController menuControl=new MenuController();

    public void menuView() {
        Table tableMenu = new Table(1, BorderStyle.CLASSIC, ShownBorders.SURROUND);
        tableMenu.setColumnWidth(0, 149, 160);
        tableMenu.addCell(Constants.MENU_VIEW1, cellCenterStyle);
        tableMenu.addCell(Constants.MENU_VIEW2, cellCenterStyle);
        System.out.println(tableMenu.render());
        String ch = Utils.inputString(Constants.COMMAND);
        menuControl.menu(ch);
        menuView();
    }

}
