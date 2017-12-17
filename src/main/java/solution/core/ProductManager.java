package solution.core;

import solution.models.Product;

/**
 * Created by aditya.dalal on 17/12/17.
 */
public interface ProductManager {
    Product getProduct(String productId);
    boolean addProduct(Product product);
}
