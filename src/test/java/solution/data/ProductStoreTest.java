package solution.data;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import solution.TestData;
import solution.groups.UnitTests;
import solution.models.Product;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;


@Category(UnitTests.class)
public class ProductStoreTest {

    ProductStore productStore;

    @Before
    public void setup() {
        this.productStore = new ProductStore();
    }

    @Test
    public void testAddProduct() {
        productStore.addProduct(TestData.getProduct());
        assertEquals(1, productStore.getSize());
    }

    @Test
    public void testAddProductForNullProduct() {
        productStore.addProduct(null);
        assertEquals(0, productStore.getSize());
    }

    @Test
    public void testGetProductForNullProduct() {
        assertNull(productStore.getProduct(null));
    }

    @Test
    public void testGetProductForInvalidProduct() {
        assertNull(productStore.getProduct("abc"));
    }

    @Test
    public void testGetProduct() {
        Product product = TestData.getProduct();
        productStore.addProduct(product);
        assertEquals(product, productStore.getProduct(product.getId()));
    }

}
