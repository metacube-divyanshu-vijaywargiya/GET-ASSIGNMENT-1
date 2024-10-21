package shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {
	//this map will store item and their quantity
	private Map<Item, Integer> cartItems;
	
	public ShoppingCart() {
		cartItems = new HashMap<>();
	}
	
	//Adding item in cart	
	public void addToCart(Item item , Integer quantity) {
		if(quantity <= 0) {
			System.out.println("Quantity must be greater than 0");
			return;
		}
		
		if(cartItems.containsKey(item)) {
		//if item already in cart then just increase its quantity
			cartItems.put(item, cartItems.get(item)+quantity);
		}else {
			cartItems.put(item, quantity);
		}
	}
	
	
	//Show the quantity of particular item
	public Integer displayQty(Item item) {
		return cartItems.getOrDefault(item, 0);
	}
	
	//to update quantity of an item in cart
	public void updateQty(Item item, Integer quantity) {
		if(cartItems.containsKey(item)){
			cartItems.put(item, quantity);
		}else {
			System.out.println("Item not present in cart.");
		}
	}
	
	//Delete item from cart
	public void deleteItem(Item item) {
		cartItems.remove(item);
	}
	
	//total bill of whole cart
	public double displayBill() {
		double total = 0;
		for(Map.Entry<Item, Integer> entry : cartItems.entrySet()) {
			total += entry.getKey().getPrice() * entry.getValue();
 		}
		return total;
	}
}
