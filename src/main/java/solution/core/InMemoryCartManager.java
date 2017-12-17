package solution.core;

import solution.data.CartStore;

/**
 * Created by aditya.dalal on 17/12/17.
 */
public class InMemoryCartManager implements CartManager {

    private CartStore cartStore;

    public InMemoryCartManager(CartStore cartStore) {
        this.cartStore = cartStore;
    }

    @Override
    public String createCart() {
        Cart cart = new ShoppingCart();
        cartStore.add(cart);
        return cart.getId();
    }

    @Override
    public Cart getCart(String cartId) {
        if(cartId == null)
            return null;
        return cartStore.getCart(cartId);
    }
}
