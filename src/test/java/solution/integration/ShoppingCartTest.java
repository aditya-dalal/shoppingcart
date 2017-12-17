package solution.integration;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import solution.core.*;
import solution.data.CartStore;
import solution.data.ProductStore;
import solution.groups.IntegrationTests;
import solution.models.Product;
import solution.models.User;
import static org.junit.Assert.assertEquals;

@Category(IntegrationTests.class)
public class ShoppingCartTest {

    private ProductManager productManager;
    private CartManager cartManager;
    private User user;
    private Product doveSoap;

    @Before
    public void setup() {
        productManager = new ProductManagerImpl(new ProductStore());
        cartManager = new CartManagerImpl(new CartStore(), productManager);
        doveSoap = new Product("Dove Soap", 39.99);
        productManager.addProduct(doveSoap);
        user = new User("user1", cartManager.createCart());
    }

    @Test
    public void testAddProductToShoppingCart() {
        Cart cart = cartManager.getCart(user.getCartId());
        cart.add(doveSoap, 5);
        assertEquals(199.95, cart.getCartPrice(), 0.001);
    }

    @Test
    public void testUpdateProductQuantityInShoppingCart() {
        Cart cart = cartManager.getCart(user.getCartId());
        cart.add(doveSoap, 5);
        cart.add(doveSoap, 3);
        assertEquals(319.92, cart.getCartPrice(), 0.001);
    }

}
