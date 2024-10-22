package shoppingcart;

import java.util.ArrayList;
import java.util.Scanner;


public class ShoppingCartTesting {
	
	public static void main(String[] args) {
		ArrayList<Item> availableItems = new ArrayList();
		//we manually creating items
		availableItems.add(new Item("101", "Laptop", "New Best Gaming Laptop", 1592.00));		
		availableItems.add(new Item("102", "Mouse", "New Best Gaming Mouse", 159.00));
		availableItems.add(new Item("103", "Keyboard", "New Best Gaming Keyboard", 192.00));
		
		//now we are creating a shopping cart
		ShoppingCart cart = new ShoppingCart();
		
		Scanner scanner = new Scanner(System.in);
		boolean running = true;
		
		while(running) {
			//firstly we will show available items in inventory
			System.out.println("Available Items in inventory: ");
			for(Item item: availableItems) {
				System.out.println(item.getItemId()+" : "+item.getName());
			}
			
			
			//Display menu for several operations
			System.out.println("Choose an Option");
			System.out.println("1: Add Item to cart");
			System.out.println("2: Update Quantity in cart");
			System.out.println("3: Delete item from cart");
			System.out.println("4: View Cart");
			System.out.println("5: View total bill");
			System.out.println("6: Exit");
			
			
			int choice = scanner.nextInt();
			scanner.nextLine();
			
			
			switch(choice) {
				//Adding an item
				case 1:
					System.out.println("Enter Item id : ");
					String addItemId = scanner.nextLine();
					Item addItem = cart.findItemById(availableItems, addItemId);
					if(addItem != null) {
						System.out.println("Enter Quantity : ");
						int quantity = scanner.nextInt();
						cart.addItemToCart(addItem, quantity);
						System.out.println(addItem.getName() + " added to cart.");
					}else {
						System.out.println("Item not found.");
					}
					break;
					
				//Update item quantity
				case 2:
					System.out.println("Enter item id to update : ");
					String updateItemId = scanner.nextLine();
					Item updateItem = cart.findItemByIdInCart(updateItemId);
					if(updateItem != null) {
						System.out.println("Enter Quantity : ");
						int updatedQuantity = scanner.nextInt();
						cart.updateItemQuantity(updateItem, updatedQuantity);
						System.out.println(updateItem.getName() + " quantity updated.");
					}else {
						System.out.println("Item not found in Cart.");
					}
					break;
					
				//Delete an item from cart
				case 3: 
					System.out.println("Enter ItemId to delete : ");
					String deleteItemId = scanner.nextLine();
					Item deleteItem = cart.findItemById(availableItems, deleteItemId);
					if(deleteItem != null) {
						cart.deleteItemFromCart(deleteItem);
						System.out.println(deleteItem.getName() + " deleted from cart.");
					}else {
						System.out.println("Item not found.");
					}
					break;
				
				//View Cart
				case 4:
					cart.displayCart();
					break;
					
				//Total bill of cart
				case 5:
					System.out.println("Total bill : " + cart.displayTotalBill());
					break;
				
				//exiting
				case 6:
					running = false;
					System.out.println("Exiting....");
					break;
					
				default:
					System.out.println("Invalid option.");
			}	
		}		
		scanner.close();
	}
}
