package store;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class Clerk {
	
	private double sum;
	private NumberFormat formatter;
	
	public Clerk() {
		sum = 0.0;
		formatter = new DecimalFormat("#0.00");
	}
	
	public void ringUpItems(ArrayList<Items> items) {
		for(Items item : items) {
			sum += item.getPrice();
			System.out.println("The " + item.getName() + " is $" + formatter.format(item.getPrice()));
		}
		
		System.out.println("Your total is $" + formatter.format(sum));
	}
	
}
