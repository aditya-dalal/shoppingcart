package solution;

import solution.core.*;
import solution.data.CartStore;
import solution.data.ProductStore;
import solution.models.Product;
import solution.models.User;

/**
 * Created by aditya.dalal on 17/12/17.
 */
public class Client {

    public static void main(String[] args) {
        CartStore cartStore = new CartStore();
        ProductStore productStore = new ProductStore();
        ProductManager productManager = new ProductManagerImpl(productStore);
        CartManager cartManager = new CartManagerImpl(cartStore, productManager);

        User user = new User("user1", cartManager.createCart());
        Product doveSoap = new Product("Dove Soap", 39.99);
        productManager.addProduct(doveSoap);
        Cart cart = cartManager.getCart(user.getCartId());

        cart.add(doveSoap, 5);
        System.out.println(cart.getCartPrice());
    }
}
