package solution.core;

import solution.models.Item;
import solution.models.Product;
import solution.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart implements Cart {

    private String id;
    private List<Item> items;
    private CartManager cartManager;
    private double taxRate;

    public ShoppingCart(CartManager cartManager) {
        this.id = new Utils().getUUID();
        this.items = new ArrayList<>();
        this.cartManager = cartManager;
    }

    public String getId() {
        return this.id;
    }

    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

    public double getTaxRate() {
        return this.taxRate;
    }

    public boolean add(Product product, int quantity) {
        if(product == null || quantity < 1)
            return false;
        Item item = getItem(product);
        if(item != null) {
            item.setQuantity(item.getQuantity() + quantity);
            return true;
        }
        else {
            item = new Item(product.getId(), quantity);
            items.add(item);
            return true;
        }
    }

    public double getCartPrice() {
        double total = 0;
        for (Item item: items){
            int quantity = item.getQuantity();
            Product product = cartManager.getProduct(item.getProductId());
            total += quantity * product.getPrice();
        }
        double tax = (taxRate / 100) * total;
        total += tax;
        return Math.round(total * 100.0)/100.0;
    }

    private Item getItem(Product product) {
        for(Item item: items){
            if(product.getId().equals(item.getProductId()))
                return item;
        }
        return null;
    }

}
