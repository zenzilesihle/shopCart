package service;

import model.Product;
import org.junit.Assert;
import org.junit.Test;

import static util.Formatter.formatPrice;

public class ShoppingCartTest {
    private ShoppingCart shoppingCart;

    @Test
    public void testAddProduct() {
        shoppingCart = new ShoppingCart();
        Product product = new Product("Dove", 39.99);

        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);

        Assert.assertEquals(5, shoppingCart.getProducts().size());
        assertProductPrice(shoppingCart);
        Assert.assertTrue(199.95 == shoppingCart.calculatePrice());
    }

    @Test
    public void testAddSameProductType() {
        shoppingCart = new ShoppingCart();
        Product product = new Product("Dove", 39.99);

        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);

        Assert.assertEquals(5, shoppingCart.getProducts().size());
        assertProductPrice(shoppingCart);

        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);
        shoppingCart.addProduct(product);

        Assert.assertEquals(8, shoppingCart.getProducts().size());
        assertProductPrice(shoppingCart);
        Assert.assertTrue(319.92 == shoppingCart.calculatePrice());
    }

    private void assertProductPrice(ShoppingCart shoppingCart) {
        shoppingCart.getProducts().forEach(item ->
                Assert.assertTrue(item.getPrice() == 39.99)
        );
    }
}
