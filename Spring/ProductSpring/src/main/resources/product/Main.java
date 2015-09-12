package product;

import org.springframework.context.*;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Main {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new GenericXmlApplicationContext("beans.xml");
		
		Battery bat = (Battery) context.getBean("aaa");
		Disc disc = (Disc) context.getBean("cdrw");
		System.out.println(bat);
		System.out.println(disc);
		
	}

}
