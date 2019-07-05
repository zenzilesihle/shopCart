package service;

import model.Product;
import org.junit.Assert;
import org.junit.Test;

import static util.Formatter.formatPrice;

public class ShoppingCartTest {

    @Test
    public void testAddProduct() {
        ShoppingCart shoppingCart = new ShoppingCart();
        Product product = new Product("Dove", 39.99);

        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);

        Assert.assertEquals(5, shoppingCart.getProducts().size());
        assertProductPrice(shoppingCart);
        Assert.assertTrue(formatPrice(199.95) == shoppingCart.calculatePrice());
    }

    private void assertProductPrice(ShoppingCart shoppingCart) {
        shoppingCart.getProducts().forEach(item ->
                Assert.assertTrue(item.getPrice() == 39.99)
        );
    }
}
