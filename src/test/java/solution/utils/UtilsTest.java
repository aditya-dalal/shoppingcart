package solution.utils;

import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.categories.Category;
import solution.groups.UnitTests;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by aditya.dalal on 17/12/17.
 */

@Category(UnitTests.class)
public class UtilsTest {

    Utils utils;

    @Before
    public void setup() {
        this.utils = new Utils();
    }

    @Test
    public void testGetUUID() {
        assertNotEquals("", utils.getUUID());
    }

    @Test
    public void testGetUUIDNotNull() {
        assertNotNull(utils.getUUID());
    }
}
