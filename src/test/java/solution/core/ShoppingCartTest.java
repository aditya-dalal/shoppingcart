package solution.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import solution.TestData;
import solution.groups.UnitTests;
import solution.models.Product;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


@Category(UnitTests.class)
public class ShoppingCartTest {

    ShoppingCart shoppingCart;
    @Mock
    CartManager cartManager;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        shoppingCart = new ShoppingCart(cartManager);
    }

    @Test
    public void testAddToCart() {
        assertTrue(shoppingCart.add(TestData.getProduct(), 5));
    }

    @Test
    public void testAddToCartForNullProduct() {
        assertFalse(shoppingCart.add(null, 5));
    }

    @Test
    public void testAddToCartForInvalidQuantity() {
        assertFalse(shoppingCart.add(TestData.getProduct(), 0));
    }

    @Test
    public void testAddExistingProduct() {
        Product product = TestData.getProduct();
        shoppingCart.add(product, 5);
        assertTrue(shoppingCart.add(product, 2));
    }

    @Test
    public void testGetCartPrice() {
        Product product = TestData.getProduct();
        Mockito.when(cartManager.getProduct(product.getId())).thenReturn(product);
        shoppingCart.add(product, 5);
        assertEquals(199.95, shoppingCart.getCartPrice(), 0.01);
    }

}
