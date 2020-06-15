package com.dgb.model;

import com.dgb.utils.Constants;
import com.dgb.utils.DBCon;
import com.dgb.utils.SQLConstants;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductCrudImp implements ProductCrud {

    @Override
    public List<Product> read(int offset,int limit) {
        DBCon con = new DBCon();
        List<Product> products = new ArrayList<>();
        try {
            Statement stmt = con.openCon().createStatement();
            ResultSet rs = stmt.executeQuery(SQLConstants.SELECT(SQLConstants.TB_PRODUCT,SQLConstants.FIELD_ID,offset,limit));
            while (rs.next()) {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                double price = rs.getDouble(4);
                Date date = rs.getDate(5);
                Product product = new Product(id, name, qty, price, date);
                products.add(product);
            }
            con.closeCon();
            return products;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public Product write(Product product) {
        DBCon con = new DBCon();
        String[] value = {product.getId() + "", product.getName(), product.getQty() +
                "", product.getPrice() + "", product.getImpDate() + ""};
        String insertSQL = SQLConstants.INSERT(SQLConstants.TB_PRODUCT, SQLConstants.TB_PRODUCT_FIELD, value);
        try {
            Statement stmt = con.openCon().createStatement();
            int i = stmt.executeUpdate(insertSQL);
            if (i == 1)
                return product;
            con.closeCon();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int count() {
        DBCon con = new DBCon();
        try {
            Statement stmt=con.openCon().createStatement();
            ResultSet rs=stmt.executeQuery(SQLConstants.COUNT(SQLConstants.TB_PRODUCT));
            rs.next();
            return rs.getInt(1);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return 0;
    }

    public Product readByID(int findID){
        DBCon con = new DBCon();
        Product product;
        String sql = SQLConstants.SELECT_BY_ID(findID,SQLConstants.TB_PRODUCT);
        try {
            Statement stmt = con.openCon().createStatement();
            ResultSet rs=stmt.executeQuery(sql);
            if (rs.next()){
                int id = rs.getInt(1);
                String name = rs.getString(2);
                int qty = rs.getInt(3);
                double price = rs.getDouble(4);
                Date date = rs.getDate(5);
                product = new Product(id, name, qty, price, date);
                return product;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

}
