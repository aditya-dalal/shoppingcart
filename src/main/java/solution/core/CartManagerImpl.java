package solution.core;

import solution.data.CartStore;
import solution.models.Product;

public class CartManagerImpl implements CartManager {

    private CartStore cartStore;
    private ProductManager productManager;

    public CartManagerImpl(CartStore cartStore, ProductManager productManager) {
        this.cartStore = cartStore;
        this.productManager = productManager;
    }

    @Override
    public String createCart() {
        Cart cart = new ShoppingCart(this);
        cartStore.add(cart);
        return cart.getId();
    }

    @Override
    public Cart getCart(String cartId) {
        if(cartId == null)
            return null;
        return cartStore.getCart(cartId);
    }

    @Override
    public Product getProduct(String productId) {
        if(productId == null)
            return null;
        return productManager.getProduct(productId);
    }

}
