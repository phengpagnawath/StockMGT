package com.dgb.utils;

import javax.print.DocFlavor;

public class SQLConstants {
    public static String SELECT(String tb,String oBy,int offset,int limit){
        return "Select * from " + tb + " order by "+ oBy + " offset " + offset +
                " limit "+ limit ;
    }

    public static String COUNT(String tb){
        return "Select count(*) from" + tb;
    }




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
        insertSql+=")";
        return insertSql;
    }
    public final static String TB_PRODUCT = "   products ";
    public final static String FIELD_ID="ID";
    public final static String[] TB_PRODUCT_FIELD ={"id","name", "qty", "price", "imp_date"};

    public static String SELECT_BY_ID(int id,String tb){
        return "Select * from "+ tb + "where id =" + id;
    };



}
