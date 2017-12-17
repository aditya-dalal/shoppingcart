package solution.core;

import solution.models.Product;

public interface Cart {
    String getId();
    boolean add(Product product, int quantity);
    double getCartPrice();
}
