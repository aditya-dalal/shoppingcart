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
    private double price;

    public ShoppingCart() {
        this.id = new Utils().getUUID();
        this.items = new HashMap<>();
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
        return this.price;
    }
}
