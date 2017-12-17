package solution.models;

import solution.utils.Utils;

public class Product {

    private String id;
    private String name;
    private double price;

    public Product(String name, double price) {
        this.id = new Utils().getUUID();
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return this.id;
    }

    public double getPrice() {
        return this.price;
    }

}
