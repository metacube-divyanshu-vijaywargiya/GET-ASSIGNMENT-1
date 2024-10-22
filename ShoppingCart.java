package shoppingcart;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;

public class ShoppingCart {
	//this map will store item and their quantity in cart
	public Map<Item, Integer> cartItems;
	
	public ShoppingCart() {
		cartItems = new HashMap<>();
	}
	
	//Adding item in cart	
	public void addItemToCart(Item item , Integer quantity) {
		try {
			if(item == null || quantity == null || quantity <= 0) {
				throw new IllegalArgumentException("Item or quantity cannot be null or invalid.");
			}
			if(cartItems.containsKey(item)) {
				//if item already in cart then just increase its quantity
				cartItems.put(item, cartItems.get(item)+quantity);
			}else {
				cartItems.put(item, quantity);
			}
		}catch(IllegalArgumentException e){
			System.out.println("Error adding item to cart : " + e.getMessage());
		}
	}
	
	
	//Show the quantity of particular item
	public Integer displayItemQuantity(Item item) {
		return cartItems.getOrDefault(item, 0);
	}
	
	//to update quantity of an item in cart
	public void updateItemQuantity(Item item, Integer quantity) {
		try {
			if(item == null || quantity == null || quantity <= 0) {
				throw new IllegalArgumentException("Item or quantity cannot be null or invalid.");
			}
			if(cartItems.containsKey(item)){
				cartItems.put(item, quantity);
			}else {
				System.out.println("Item not present in cart.");
			}
		}catch(IllegalArgumentException e) {
			System.out.println("Error Updating item to cart : " + e.getMessage());
		}
	}
	
	//Delete item from cart
	public void deleteItemFromCart(Item item) {
		if(item == null) {
			throw new IllegalArgumentException("Item cannot be null.");
		}else {			
		cartItems.remove(item);
		}
	}
	
	//total bill of whole cart
	public double displayTotalBill() {
		double total = 0;
		for(Map.Entry<Item, Integer> entry : cartItems.entrySet()) {
			total += entry.getKey().getPrice() * entry.getValue();
 		}
		return total;
	}
	
	//to find item in cart
	public Item findItemById(ArrayList<Item> Items, String ItemId) {
		try {
			if(ItemId == null) {
				throw new IllegalArgumentException("ItemId cannot be null.");
			}
			for(Item item : Items) {
				if(item.getItemId().equals(ItemId)) {
					return item;
				}
			}
			return null;
		}catch(IllegalArgumentException e) {
			System.out.println("Error while finding item : " + e.getMessage());
			return null;
		}
	}
	
	//to find item in cart
	public Item findItemByIdInCart(String ItemId) {
		try {
			if(ItemId == null) {
				throw new IllegalArgumentException("ItemId cannot be null.");
			}
			for(Item item : cartItems.keySet()) {
				if(item.getItemId().equals(ItemId)) {
					return item;
				}
			}
			return null;
		}catch(IllegalArgumentException e) {
			System.out.println("Error while finding item : " + e.getMessage());
			return null;
		}
	}
	
	public void displayCart() {
		if(cartItems.isEmpty()) {
			System.out.println("Your Cart is Empty.");
		}else {
			System.out.println("Your Cart : ");
			for(Map.Entry<Item, Integer> entry : cartItems.entrySet()) {
				Item item = entry.getKey();
				System.out.println("Item Name : " + item.getName() + " -> Quantity : " + entry.getValue() + " -> Price " + entry.getValue() * item.getPrice());
			}
			System.out.println("Cart's Total Bill : " + displayTotalBill());
		}
	}

}
