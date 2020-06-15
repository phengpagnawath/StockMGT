package com.dgb.model;

import javax.xml.crypto.Data;
import java.util.Date;

public class Product {
    private int id;
    private String name;
    private int qty;
    private double price;
    private Date impDate;

    public Product(int id, String name, int qty, double price) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.impDate = new Date();
    }

    public Product(int id, String name, int qty, double price, Date impDate) {
        this.id = id;
        this.name = name;
        this.qty = qty;
        this.price = price;
        this.impDate = impDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", qty=" + qty +
                ", price=" + price +
                ", impDate=" + impDate +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getImpDate() {
        return impDate;
    }

    public void setImpDate(Date impDate) {
        this.impDate = impDate;
    }
}
