package com.dgb.utils;

import com.dgb.view.ProductView;

import javax.print.DocFlavor;

public class SQLConstants {
    public static String SELECT(String tb,String oBy,int offset,int limit){
        String sql="Select * from " + tb + " order by "+ oBy + " offset " + offset +
                " limit "+ limit ;
        //System.out.println(sql);
        return sql;
    }
    public static String SEARCH_NAME(String tb,String field,String search,String oBy){
        //System.out.println("Select * from " + tb + "where lower("+ field +") like '%"+ search.toLowerCase() +"%' order by "+ oBy);
        return "Select * from " + tb + "where lower("+ field +") like '%"+ search.toLowerCase() +"%' order by "+ oBy
                +" offset " + ProductView.offset + " limit "+ ProductView.rowSet;
    }
    public static String SELECT_COUNT_NAME(String tb,String field,String search){
        return "Select Count(*) from " + tb + "where lower("+ field +") like '%"+ search.toLowerCase() +"%'";
    }



    public static String UPDATE(String tb,int id,String[] tb_field,String[] tb_value){
        String updateSQL;
        int i;
        updateSQL="Update " + tb + "set ";
        for(i=0;i<tb_field.length;i++){
            updateSQL+= tb_field[i] + "='"+tb_value[i]+"'";
            if(i<tb_field.length-1)
                updateSQL+=",";
        }
        updateSQL+=" where ID="+id;
        return updateSQL;
    }

    public static String COUNT(String tb){
        return "Select count(*) from" + tb;
    }

    public static String SELECT_MAX(String tb, String tb_field){
        return "Select Max(" + tb_field + ") from "+tb;
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
