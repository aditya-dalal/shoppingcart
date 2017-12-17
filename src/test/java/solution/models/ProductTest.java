package solution.models;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import solution.groups.UnitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

@Category(UnitTests.class)
public class ProductTest {

    @Test
    public void testNewProduct() {
        Product product = new Product("abc", 1.23);
        assertEquals(1.23, product.getPrice(), 0.001);
        assertNotNull(product.getId());
        assertNotEquals("", product.getId());
    }
}
