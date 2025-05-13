package Shoppingcart;

public class CartItem extends Product {

	Product product;
	int quantity;
	
	public CartItem() {
		
	}
	     CartItem(String name, int price) {
	    	 super(name, price);
	    	
	    }
	     
	     CartItem(Product product) {
	    	 this.name = product.name;
	    	 this.price = product.price;
	    	 this.quantity = 1;
	    	 
	   
	    }
	     
	     CartItem(Product product, int quantity) {
	    	 this.product = product;
	    	 this.quantity = quantity;
	

}
	}


