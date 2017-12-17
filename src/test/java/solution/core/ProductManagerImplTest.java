package solution.core;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import solution.TestData;
import solution.data.ProductStore;
import solution.groups.UnitTests;
import solution.models.Product;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;


@Category(UnitTests.class)
public class ProductManagerImplTest {

    ProductManager productManager;
    @Mock
    ProductStore productStore;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        productManager = new ProductManagerImpl(productStore);
    }

    @Test
    public void testAddProduct() {
        assertTrue(productManager.addProduct(TestData.getProduct()));
    }

    @Test
    public void testAddNullProduct() {
        assertFalse(productManager.addProduct(null));
    }

    @Test
    public void testGetProduct() {
        Product product = TestData.getProduct();
        when(productStore.getProduct(product.getId())).thenReturn(product);
        assertEquals(product, productManager.getProduct(product.getId()));
    }

    @Test
    public void testGetProductForNullProductId() {
        assertNull(productManager.getProduct(null));
    }

    @Test
    public void testGetProductForInvalidProductId() {
        assertNull(productManager.getProduct("abc"));
    }
}
