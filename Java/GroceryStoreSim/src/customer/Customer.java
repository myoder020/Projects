package customer;

import store.Items;

public class Customer {
	
	private Cart cart;
	
	public Customer() {
		this.cart = new Cart();
	}
	
	public Cart getCart() {
		return cart;
	}
	
	public void addToCart(Items item) {
		cart.addItem(item);
	}
	
}
