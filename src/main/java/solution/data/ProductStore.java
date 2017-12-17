package solution.data;

import solution.models.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.dalal on 17/12/17.
 */
public class ProductStore {

    private Map<String, Product> products;

    public ProductStore() {
        this.products = new HashMap<>();
    }

    public void addProduct(Product product) {
        if(product == null)
            return;
        products.put(product.getId(), product);
    }

    public Product getProduct(String productId) {
        if (productId == null)
            return null;
        return products.get(productId);
    }
}
