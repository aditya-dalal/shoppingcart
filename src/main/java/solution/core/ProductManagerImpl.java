package solution.core;

import solution.data.ProductStore;
import solution.models.Product;

public class ProductManagerImpl implements ProductManager {

    private ProductStore productStore;

    public ProductManagerImpl(ProductStore productStore) {
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
