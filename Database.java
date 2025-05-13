package Shoppingcart;

import java.util.ArrayList;

public class Database {

	// constant
	static final ArrayList<User> USER_DB = new ArrayList<User>();
	static final ArrayList<Product> PRODUCT_DB = new ArrayList<Product>();

	static {
		USER_DB.add(new User("1", "1"));
		USER_DB.add(new User("2", "2"));	

		PRODUCT_DB.add(new Product("Coffee", 5));
		PRODUCT_DB.add(new Product("Milk", 3));
	}

}
