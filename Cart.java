package Shoppingcart;
import java.text.DecimalFormat;
import java.util.ArrayList;

public class Cart {
   ArrayList<CartItem> items;
   
   public Cart() {
	   items = new ArrayList<>();
	   
   }
    
    public void addItem(Product product, int quantity) {
    	for (CartItem item : items) {
    		if (item.product.name.equals(product.name)) {
    			item.quantity += quantity;
    			return;
    		}
    		        }
    	items.add(new CartItem(product, quantity));

    		    }

    		    public void showCart() {
    		        double total = 0;
    		        DecimalFormat fmt = new DecimalFormat("0.0");
    		        
    		        System.out.println("\n Your Cart:");
    		        for (CartItem item : items) {
    		            double Linetotal = item.product.price * item.quantity;
    		            System.out.println("- " + item.product.name + " x" + item.quantity + " = $" + Linetotal);
    		            Linetotal += Linetotal;
    		        }
    		        System.out.println("Total: $" + fmt.format(total));
    		    }
    		}

    	
    	
    	
    
