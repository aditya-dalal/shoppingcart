package solution.models;

import org.junit.Test;
import org.junit.experimental.categories.Category;
import solution.groups.UnitTests;

import static org.junit.Assert.assertEquals;

@Category(UnitTests.class)
public class ItemTest {

    @Test
    public void testNewItem() {
        Item item = new Item("abc", 2);
        assertEquals("abc", item.getProductId());
        assertEquals(2, item.getQuantity());
    }

    @Test
    public void testSetQuantity() {
        Item item = new Item("abc", 2);
        item.setQuantity(3);
        assertEquals(3, item.getQuantity());
    }
}
