package shoppingcart;

public class ShoppingCartTesting {

	public static void main(String[] args) {
		//we manually creating items
		Item item1 = new Item("101", "Laptop", "New Best Gaming Laptop", 1592.00);		
		Item item2 = new Item("102", "Mouse", "New Best Gaming Mouse", 159.00);
		Item item3 = new Item("103", "Keyboard", "New Best Gaming Keyboard", 192.00);
		
		//now we are creating a shopping cart
		ShoppingCart cart = new ShoppingCart();
		
		
		//adding to cart
		cart.addToCart(item1, 1);
		cart.addToCart(item2, 2);
		
		//we can display quantity of specific item in cart
		System.out.println("Quantity of " + item1.getName() + " : "+ cart.displayQty(item1));
		System.out.println("Quantity of " + item2.getName() + " : "+ cart.displayQty(item2));
		System.out.println("Quantity of " + item3.getName() + " : "+ cart.displayQty(item3));
		
		//Update quantity
		cart.updateQty(item1, 7);
		System.out.println("New Updated Quantity of " + item1.getName() + " : "+ cart.displayQty(item1));
		
		//Displaying total bill
		System.out.println("Total bill of cart : " + cart.displayBill());
		
		//Deleting an item from cart
		cart.deleteItem(item2);
		System.out.println("Total bill of cart after removal of " + item2.getName() + " : "+ cart.displayBill());
	}

}
