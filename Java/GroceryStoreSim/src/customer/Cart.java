package customer;

import java.util.ArrayList;
import java.util.List;

import store.Items;

public class Cart<Items> {
	
	List<Items> items;
	
	public Cart() {
		items = new ArrayList<Items>();
	}
	
	public void addItem(Items item) {
		items.add(item);
	}
	
	public int getNumberItems() {
		return items.size();
	}
	
	public List<Items> getItems(){
		return items;
	}
	
}
