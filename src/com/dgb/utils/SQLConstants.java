package com.dgb.utils;

import javax.print.DocFlavor;

public class SQLConstants {
    public final static String SELECT = "SELECT * FROM";
    public static String INSERT(String tb,String[] tb_field,String[] tb_value){
        String insertSql;
        int i;
        insertSql="Insert into " + tb +"(";
        for(i=0;i<tb_field.length;i++) {
            insertSql += tb_field[i] ;
            if(i<tb_field.length-1)
                insertSql+=",";
        }
        insertSql+=") values (";
        for(i=0;i<tb_value.length;i++){
            insertSql += "'" + tb_value[i] + "'";
            if(i<tb_value.length-1)
                insertSql+=",";
        }
        insertSql+=",now())";
        return insertSql;
    }
    public final static String TB_PRODUCT = "   products ";
    public final static String[] TB_PRODUCT_FIELD ={"name", "qty", "price", "imp_date"};

}
