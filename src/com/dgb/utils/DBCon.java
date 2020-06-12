package com.dgb.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBCon {
    Connection con;
    public DBCon() {

    }

    public Connection openCon(){
        try {
            Class.forName("org.postgresql.Driver");
            con = DriverManager.getConnection(Constants.URL, Constants.USER, Constants.PASSWORD);
            return con;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public void closeCon(){
        try {
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
