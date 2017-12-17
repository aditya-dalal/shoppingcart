package solution.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import solution.TestData;
import solution.data.CartStore;
import solution.groups.UnitTests;
import solution.models.Product;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@Category(UnitTests.class)
public class CartManagerImplTest {

    CartManager cartManager;
    @Mock
    CartStore cartStore;
    @Mock
    ProductManager productManager;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.cartManager = new CartManagerImpl(cartStore, productManager);
    }

    @Test
    public void testCreateCart() {
        String cartId = cartManager.createCart();
        assertNotEquals("", cartId);
        assertNotNull(cartId);
    }

    @Test
    public void testGetCart() {
        Cart cart = new ShoppingCart(cartManager);
        when(cartStore.getCart(cart.getId())).thenReturn(cart);
        assertEquals(cart, cartManager.getCart(cart.getId()));

    }

    @Test
    public void testGetCartForNullCartId() {
        assertNull(cartManager.getCart(null));
    }

    @Test
    public void testGetCartForInvalidCartId() {
        assertNull(cartManager.getCart("abc"));
    }

    @Test
    public void testGetProduct() {
        Product product = TestData.getProduct();
        when(productManager.getProduct(product.getId())).thenReturn(product);
        assertEquals(product, cartManager.getProduct(product.getId()));
    }

    @Test
    public void testGetProductForNullProductId() {
        assertNull(cartManager.getProduct(null));
    }

    @Test
    public void testGetProductForInvalidProductId() {
        assertNull(cartManager.getProduct("abc"));
    }
}
