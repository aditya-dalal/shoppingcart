package solution.core;

import solution.models.Item;
import solution.models.Product;
import solution.utils.Utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by aditya.dalal on 17/12/17.
 */
public class ShoppingCart implements Cart {

    private String id;
    private Map<String, Item> items;
    private CartManager cartManager;

    public ShoppingCart(CartManager cartManager) {
        this.id = new Utils().getUUID();
        this.items = new HashMap<>();
        this.cartManager = cartManager;
    }

    public String getId() {
        return this.id;
    }

    public boolean add(Product product, int quantity) {
        if(product == null || quantity < 1)
            return false;
        Item item = items.get(product.getId());
        if(item != null) {
            item.setQuantity(quantity);
            return true;
        }
        else {
            item = new Item(product.getId(), quantity);
            items.put(product.getId(), item);
            return true;
        }
    }

    public double getCartPrice() {
        double total = 0;
        for (Map.Entry<String, Item> itemEntry: items.entrySet()){
            Item item = itemEntry.getValue();
            int quantity = item.getQuantity();
            Product product = cartManager.getProduct(item.getProductId());
            total += quantity * product.getPrice();
        }
        return Math.round(total * 100.0)/100.0;
    }

}
