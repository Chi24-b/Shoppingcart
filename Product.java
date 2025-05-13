package Shoppingcart;

import java.text.DecimalFormat;

public class Product {
	
	String name;
	double price;
public Product() {
	
}
	public Product(String name, double price) {
	    this.name = name;
	    this.price = price;
	    }
	
	public void showPrice() {
		DecimalFormat fmt = new DecimalFormat("0.0a");
		System.out.println(name + ": " + fmt.format(price) + " aud.");
	}
	}

