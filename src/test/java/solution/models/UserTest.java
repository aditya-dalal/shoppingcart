package solution.models;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.experimental.categories.Category;
import solution.groups.UnitTests;

@Category(UnitTests.class)
public class UserTest {

    @Test
    public void testNewUser() {
        User user = new User("user1", "abc");
        assertEquals("abc", user.getCartId());
    }
}
