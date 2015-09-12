package store;

import java.util.ArrayList;
import java.util.List;

public class Store {
	
	private List<Items> inventory;
	
	public Store() {
		inventory = new ArrayList<Items>();
		initialize();
	}
	
	private void initialize() {
		inventory.add(new Items("Soap", 3.99));
		inventory.add(new Items("Ramen", 0.99));
		inventory.add(new Items("Apples", 1.99));
		inventory.add(new Items("Peaches", 1.99));
		inventory.add(new Items("Paper Towels", 2.99));
		inventory.add(new Items("Ham", 3.00));
		inventory.add(new Items("Bread", 4.99));
		inventory.add(new Items("Soda", 1.50));
		inventory.add(new Items("Shampoo", 3.99));
		inventory.add(new Items("MouthWash", 3.99));		
	}
	
	public List<Items> getInventory() {
		return inventory;
	}
	
}
