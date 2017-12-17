package solution.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import solution.core.Cart;
import solution.core.CartManager;
import solution.core.ProductManager;
import solution.core.ShoppingCart;
import solution.groups.UnitTests;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@Category(UnitTests.class)
public class CartStoreTest {

    CartStore cartStore;
    @Mock
    CartManager cartManager;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.cartStore = new CartStore();
    }

    @Test
    public void testAddCart() {
        cartStore.add(getCart());
        assertEquals(1, cartStore.getSize());
    }

    @Test
    public void testAddCartForNullCart() {
        cartStore.add(null);
        assertEquals(0, cartStore.getSize());
    }

    @Test
    public void testGetCartForNullCart() {
        assertNull(cartStore.getCart(null));
    }

    @Test
    public void testGetCartForInvalidCart() {
        assertNull(cartStore.getCart("abc"));
    }

    @Test
    public void testGetCart() {
        Cart cart = getCart();
        cartStore.add(cart);
        assertEquals(cart, cartStore.getCart(cart.getId()));
    }

    private Cart getCart() {
        return new ShoppingCart(cartManager);
    }
}
