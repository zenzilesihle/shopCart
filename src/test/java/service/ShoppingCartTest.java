package service;

import model.Product;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static util.Formatter.formatTaxCalculationMoney;
import static util.Formatter.formatTotalPriceMoney;

public class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @Before
    public void init() {
        shoppingCart = new ShoppingCart();
    }

    @Test
    public void testAddProduct() {
        Product product = new Product("Dove", 39.99);

        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);

        double totalPrice = shoppingCart.calculateTotalPrice();

        Assert.assertEquals(5, shoppingCart.getAllProducts().size());
        assertProductPrice(shoppingCart.getAllProducts(), 39.99);
        Assert.assertTrue(199.95 == totalPrice);
    }

    @Test
    public void testAddSameProductType() {
        Product product = new Product("Dove", 39.99);

        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);

        Assert.assertEquals(5, shoppingCart.getAllProducts().size());
        assertProductPrice(shoppingCart.getAllProducts(), 39.99);

        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);

        Assert.assertEquals(8, shoppingCart.getAllProducts().size());
        assertProductPrice(shoppingCart.getAllProducts(), 39.99);
        Assert.assertTrue(319.92 == shoppingCart.calculateTotalPrice());
    }

    @Test
    public void testCalculateTaxRate() {
        Product dove = new Product("Dove", 39.99);
        Product axeDeo = new Product("Axe Deo", 99.99);

        shoppingCart.addProduct(dove);
        shoppingCart.addProduct(dove);
        shoppingCart.addProduct(axeDeo);
        shoppingCart.addProduct(axeDeo);

        Assert.assertEquals(2, shoppingCart.getSpecificProducts("Axe Deo").size());
        assertProductPrice(shoppingCart.getSpecificProducts("Axe Deo"), 99.99);
        Assert.assertEquals(2, shoppingCart.getSpecificProducts("Dove").size());
        assertProductPrice(shoppingCart.getSpecificProducts("Dove"), 39.99);


        shoppingCart.calculateTotalPrice();
        double taxAmount = shoppingCart.calculateTaxAmount(12.50);
        double fullAmount = shoppingCart.applyTaxOnTotal(12.50);

        Assert.assertTrue(35.00 == taxAmount);
        Assert.assertTrue(314.96 == fullAmount);
    }

    @Test
    public void testUtil() {
        Assert.assertTrue(formatTotalPriceMoney(29.95) == 29.95);
        Assert.assertTrue(formatTotalPriceMoney(29.957) == 29.96);
        Assert.assertTrue(formatTotalPriceMoney(29.923) == 29.92);
        Assert.assertTrue(formatTotalPriceMoney(1.99 + 0.99) == 2.98);

        Assert.assertTrue(formatTaxCalculationMoney(29.99989) == 30.00);
        Assert.assertTrue(formatTaxCalculationMoney(29.92) == 29.92);
    }

    private void assertProductPrice(List<Product> products, double price) {
        products.forEach(item ->
                Assert.assertTrue(item.getPrice() == price)
        );
    }

    @After
    public void finalize() {
        shoppingCart = null;
    }

}
