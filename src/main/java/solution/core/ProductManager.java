package solution.core;

import solution.models.Product;

public interface ProductManager {
    Product getProduct(String productId);
    boolean addProduct(Product product);
}
