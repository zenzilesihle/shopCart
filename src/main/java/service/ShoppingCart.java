package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;

import static util.Formatter.formatPrice;

public class ShoppingCart {
    private List<Product> products;
    private double totalPrice;

    public ShoppingCart() {
        products = new ArrayList<>();
        totalPrice = 0.00;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculatePrice() {
        for (Product product : products) {
            totalPrice += product.getPrice();
        }
        return formatPrice(totalPrice);
    }

    public List<Product> getProducts() {
        return products;
    }
}
