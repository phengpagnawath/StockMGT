package com.dgb.view;

import com.dgb.utils.Constants;
import org.nocrala.tools.texttablefmt.CellStyle;
import org.nocrala.tools.texttablefmt.Table;



public class MsgView {
    static CellStyle cellCenterStyle = new CellStyle(CellStyle.HorizontalAlign.center);
    static CellStyle cellLeftStyle = new CellStyle(CellStyle.HorizontalAlign.left);
    static CellStyle cellRightStyle = new CellStyle(CellStyle.HorizontalAlign.right);

    public static void showMessage(String msg){
        Table tb= new Table(1);
        tb.setColumnWidth(0, 149, 160);
        tb.addCell(msg,cellCenterStyle);
        System.out.println(tb.render());
    }
}
