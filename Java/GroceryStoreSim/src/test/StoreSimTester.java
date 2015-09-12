package test;

import java.util.ArrayList;
import java.util.Random;
import customer.Customer;
import store.*;

public class StoreSimTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Clerk clerk = new Clerk();
		Store store = new Store();
		Customer cust = new Customer();
		Random rand = new Random();
		Items item;
		int grab = 0;
		
		//create Customers
		
		
		//fill up cart
		while (grab < 10) {
			grab = rand.nextInt(12);
			
			if (grab <= 9) {
				item = store.getInventory().get(grab);
				cust.addToCart(item);
			}
		}
		
		clerk.ringUpItems((ArrayList<Items>)cust.getCart().getItems());

	}

}
