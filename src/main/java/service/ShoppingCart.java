package service;

import model.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static util.Formatter.formatTaxCalculationMoney;
import static util.Formatter.formatTotalPriceMoney;

public class ShoppingCart {
    private List<Product> products;
    private double totalPrice;
    private double taxAmount;
    private double totalAmountWithTax;

    public ShoppingCart() {
        products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public double calculateTotalPrice() {
        products.forEach(product ->
                totalPrice += product.getPrice()
        );
        return formatTotalPriceMoney(totalPrice);
    }

    public double calculateTaxAmount(double taxRate) {
        return taxAmount = formatTaxCalculationMoney(totalPrice * (taxRate / 100));
    }

    public double applyTaxOnTotal(double taxRate) {
        return totalAmountWithTax = formatTaxCalculationMoney(totalPrice + totalPrice * (taxRate / 100));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> getSpecificProducts(String name) {
        return products.stream()
                .filter(product -> product.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }
}
