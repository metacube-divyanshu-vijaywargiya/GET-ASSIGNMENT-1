package shoppingcart;

public class Item {
	
	private String itemId;
	private String name;
	private String description;
	private double price;
	
	public Item(String itemId, String name, String description, double price) {
		this.itemId = itemId;
		this.name = name;
		this.description = description;
		this.price = price;
	}
	
	//Now we will create getters and setters here as they are private 
	public String getItemId() {
		return itemId;
	}
	
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	
	public double getPrice() {
		return price;
	}
	
	public void setPrice(double price) {
		this.price = price;
	}
}
