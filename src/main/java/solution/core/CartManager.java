package solution.core;

import solution.models.Product;

/**
 * Created by aditya.dalal on 17/12/17.
 */
public interface CartManager {
    String createCart();
    Cart getCart(String cartId);
    Product getProduct(String productId);
}
