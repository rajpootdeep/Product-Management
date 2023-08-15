package com.product;

import java.util.List;

import com.product.Model.Product;
import com.product.Service.ProductService;

public class Main {
    public static void main(String[] args) {

        ProductService service = new ProductService();

        // Product p1=new Product("Asus Vivobook", "Laptop", "Brown Table" , 2025 );

        // service.addProduct(new Product("Asus Vivobook", "Laptop", "Brown Table", 2025));
        // service.addProduct(new Product("HP Probook", "Laptop", "On Bed", 2023));






        List<Product> products = service.getAllProducts();

        for (Product p : products)
        System.out.println(p);

        System.out.println("=====================================================");
        System.out.println("A particular product info : ");

        Product ps = service.getProduct("HP Probook");
        System.out.println(ps);

        // System.out.println("=====================================================");

        // System.out.println("Searched by a partucalar text : ");
        // List<Product> prods = service.getProductWithText("bed");

        // for (Product p : prods) {
        // System.out.println(p);
        // }

    }
}