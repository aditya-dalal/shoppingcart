package solution.core;

import solution.models.Product;

/**
 * Created by aditya.dalal on 17/12/17.
 */
public interface Cart {
    String getId();
    boolean add(Product product, int quantity);
    double getCartPrice();
}
