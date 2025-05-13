package Shoppingcart;
import java.util.Scanner;
import java.util.ArrayList;


public class Main {
	
	static final ArrayList<User> userDB = new ArrayList<User>();
	static ArrayList<Product> productDB = new ArrayList<Product>();
	static ArrayList<Shop> allShops = new ArrayList<>();

	
	static User currentUser;
	static Cart cart;
	static Shop currentShop;
	
	static Scanner scan = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		initData(); 
		System.out.println("Choose a shop: ");
		
		

		for (int i = 0; i < allShops.size(); i++) {
			System.out.println((i+1) + ". " + allShops.get(i).name);
		
		}
		int shopChoice = scan.nextInt();
		scan.nextLine();
		currentShop = allShops.get(shopChoice - 1);
		
		if (shopChoice == 1) {
		    currentShop = allShops.get(0);
		} else if (shopChoice == 2) {
		    currentShop = allShops.get(1);
		}
	

		boolean isLoggedin;
		
		do {
			isLoggedin = doLogin();    //log in first
		} while (isLoggedin == false);
		
		
		System.out.print("Login success! Welcome, " + currentUser.userId);
		
		//Main menu
		while (true) {
			System.out.println(" ========== MAIN MENU ===========");
			System.out.println("1. View Cart");
			System.out.println("2. View Rank");
			System.out.println("3. View Products");
			System.out.println("4. Checkout");
			System.out.println("0. Exit.");
			
			System.out.println("Enter your choice: ");
			int choice = scan.nextInt();
			scan.nextLine();

			if (choice == 0) {
				System.out.println("Exit.");
				break;
			} else if (choice == 1) {
				cart.showCart();
			} else if (choice == 2) {
				System.out.println("Rank information is coming soon!");
			} else if (choice == 3) {
			    showProducts();

			    System.out.print("Enter product number: ");
			    int productNumber = scan.nextInt();
			    scan.nextLine();

			    Product selectedProduct = productDB.get(productNumber - 1);

			    System.out.print("Enter quantity: ");
			    int qty = scan.nextInt();
			    scan.nextLine();

			    cart.addItem(selectedProduct, qty);
			    System.out.println("Added " + qty + " x " + selectedProduct.name);
			} else if (choice == 4) {
			    System.out.println("\n===== CHECKOUT =====");

			    double itemTotal = 0;

			    for (int i = 0; i < cart.items.size(); i++) {
			        CartItem item = cart.items.get(i);
			        double lineTotal = item.product.price * item.quantity;
			        itemTotal += lineTotal;
			        System.out.println((i + 1) + ". " + item.product.name + " - " + item.product.price + " AUD - " + item.quantity + " = " + lineTotal + " AUD");
			    }

			    double shippingFee = 5.0;
			    double voucherDiscount = 1.0;  
			    double rankDiscount = 0.5;     //50% off shipping (Silver)

			    double shippingAfterDiscount = shippingFee * (1 - rankDiscount);

			    System.out.println("SHIP : 3-5 days = " + shippingFee + " AUD");
			    System.out.println("VOUCHER : AAA = -" + voucherDiscount + " AUD");
			    System.out.println("RANK SILVER : -50% ship = " + shippingAfterDiscount + " AUD");

			    double total = itemTotal + shippingAfterDiscount - voucherDiscount;
			    System.out.println("TOTAL : " + total + " AUD");
			
			} else {
				System.out.println("INVALID OPTION!!!! ");
			}
		}
	}
private static void showProducts() {
	for (int i = 0; i < productDB.size(); i++) {
		System.out.println((i+1) +". " + productDB.get(i).name +" : " + productDB.get(i).price + "aud.");
	}
}
	
	
	
	private static void initData() {
		    Shop shop1 = new Shop("Shop 1");
		    shop1.addProduct(new Product("Flower", 3));
		    shop1.addProduct(new Product("Toy", 5));
		    shop1.addProduct(new Product("Phone", 100));
		    shop1.addProduct(new Product("Chair", 25));
		    
		    shop1.addUser(new User("1", "1"));  

		    Shop shop2 = new Shop("Shop 2");
		    shop2.addProduct(new Product("Tree", 50));
		    shop2.addProduct(new Product("Bubble Tea", 20));
		    
		    shop2.addUser(new User("2", "2"));

		    allShops.add(shop1);
		    allShops.add(shop2);
	
	}
	


	private static boolean doLogin() {
		// user input username + password
		System.out.print("Enter ID: ");
		String userId = scan.nextLine();

		// Enter Password
		System.out.print("Enter Password: ");
		String userPassword = scan.nextLine();
		
		for (User u : currentShop.users) {
			if (u.userId.equals(userId) && u.password.equals(userPassword)) {
				currentUser = u;
				cart = new Cart();
				
				return true;
			}
		}
		System.out.println ("Login falied. Try again!!!!");
		return false;
	}

}

		