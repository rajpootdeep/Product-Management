package com.product.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.product.DataBase.ProductDB;
import com.product.Model.Product;

public class ProductService {

    List<Product> products = new ArrayList<>();

    ProductDB db = new ProductDB();

    public void addProduct(Product p) {
        db.save(p);
    }

    public List<Product> getAllProducts() {
        return db.getAll();
    }

    public Product getProduct(String name) {

        // List<Product> pr= products.stream().filter(p ->
        // p.getName().equalsIgnoreCase(name)).collect(Collectors.toList());
        // return pr.get(0);


return db.getMyObject(name);



    }
    // for(Product p : products){
    // if(p.getName().equals(name))
    // return p;
    // }

    public List<Product> getProductWithText(String s) {
        List<Product> prods = new ArrayList<>();

        for (Product p : products) {

            if (p.getName().toLowerCase().contains(s) || p.getPlace().toLowerCase().contains(s)
                    || p.getType().toLowerCase().contains(s)) {
                prods.add(p);
            }
        }
        return prods;
    }

}