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
    public List<Product> read() {
        DBCon con = new DBCon();
        List<Product> products = new ArrayList<>();
        try {
            Statement stmt = con.openCon().createStatement();
            ResultSet rs = stmt.executeQuery(SQLConstants.SELECT + SQLConstants.TB_PRODUCT);
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
        String[] value = {product.getName(), product.getQty() + "", product.getPrice() + ""};
        String insertSQL = SQLConstants.INSERT(SQLConstants.TB_PRODUCT, SQLConstants.TB_PRODUCT_FIELD, value);
        try {
            Statement stmt = con.openCon().createStatement();
            int i = stmt.executeUpdate(insertSQL);
            System.out.println(Constants.INSERT_DATA_SUCCESS + " " + i + "records");
            con.closeCon();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return product;
    }
}
