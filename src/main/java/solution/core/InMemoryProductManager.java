package solution.core;

import solution.data.ProductStore;
import solution.models.Product;

/**
 * Created by aditya.dalal on 17/12/17.
 */
public class InMemoryProductManager implements ProductManager {

    private ProductStore productStore;

    public InMemoryProductManager(ProductStore productStore) {
        this.productStore = productStore;
    }

    public boolean addProduct(Product product) {
        if(product == null)
            return false;
        productStore.addProduct(product);
        return true;
    }

    public Product getProduct(String productId) {
        if(productId == null)
            return null;
        return productStore.getProduct(productId);
    }
}
