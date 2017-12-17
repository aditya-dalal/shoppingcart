package solution.models;

/**
 * Created by aditya.dalal on 17/12/17.
 */
public class Item {

    private String productId;
    private int quantity;

    public Item(String productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getQuantity() {
        return this.quantity;
    }

    public String getProductId() {
        return this.productId;
    }

}
