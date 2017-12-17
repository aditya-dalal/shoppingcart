package solution.core;

import solution.models.Product;

public interface CartManager {
    String createCart();
    Cart getCart(String cartId);
    Product getProduct(String productId);
}
