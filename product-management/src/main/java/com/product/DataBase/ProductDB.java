package com.product.DataBase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.product.Model.Product;

public class ProductDB {

    Connection conn = null;

    public ProductDB() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3308/productmanagement", "root", "Deep");
        } catch (SQLException e) {

            e.printStackTrace();
        }
    }

    public void save(Product p) {
        String query = "insert into product (name, type, place, warranty) values (?,?,?,?)";

        try {

            PreparedStatement pst = conn.prepareStatement(query);

            pst.setString(1, p.getName());
            pst.setString(2, p.getType());
            pst.setString(3, p.getPlace());
            pst.setInt(4, p.getWarranty());
            pst.execute();

        } catch (SQLException e) {

            e.printStackTrace();
        }

    }

    public List<Product> getAll() {

        List<Product> product = new ArrayList<>();
        String query = "select name, type,place, warranty from product";
        try {
            PreparedStatement pst = conn.prepareStatement(query);

            ResultSet res = pst.executeQuery();

            while (res.next()) {

                Product p = new Product();
                p.setName(res.getString(1));
                p.setPlace(res.getString(3));
                p.setWarranty(res.getInt(4));
                p.setType(res.getString(2));
                product.add(p);
            }
        } catch (SQLException e) {

            e.printStackTrace();
        }

        return product;
    }

    public Product getMyObject(String name) {
        String query = "Select * from product where name=?";
        Product p = new Product();
        try {
            PreparedStatement pst = conn.prepareStatement(query);
            pst.setString(1, name);
            ResultSet res = pst.executeQuery();
            while (res.next()) {

                p.setName(res.getString(1));
                p.setPlace(res.getString(3));
                p.setWarranty(res.getInt(4));
                p.setType(res.getString(2));
            }

        } catch (SQLException e) {

            e.printStackTrace();
        }

        return p;
    }

}
