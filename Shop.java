package Shoppingcart;

import java.util.ArrayList;
public class Shop {
    public String name;
    public ArrayList<Product> products = new ArrayList<>();
    public ArrayList<User> users = new ArrayList<>();

    public Shop(String name) {
        this.name = name;
    }

    public void addProduct(Product p) {
        products.add(p);
    }

    public void addUser(User u) {
        users.add(u);
    }
}

