package solution.models;

public class User {

    private String name;
    private String cartId;

    public User(String name, String cartId) {
        this.name = name;
        this.cartId = cartId;
    }

    public String getCartId() {
        return this.cartId;
    }
}
