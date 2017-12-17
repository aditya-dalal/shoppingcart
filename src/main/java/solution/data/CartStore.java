package solution.data;

import solution.core.Cart;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.dalal on 17/12/17.
 */
public class CartStore {

    private Map<String, Cart> carts;

    public CartStore() {
        this.carts = new HashMap<>();
    }

    public void add(Cart cart) {
        if(cart == null)
            return;
        carts.put(cart.getId(), cart);
    }

    public Cart getCart(String cartId) {
        if(cartId == null)
            return null;
        return carts.get(cartId);
    }
}
