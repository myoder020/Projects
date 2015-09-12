package count;

import java.util.Scanner;

public class VowelCounterTester {
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String line = "Yes";
		VowelCounter vc;
		
		while(line.equals("Yes")) {
			line = in.nextLine();
			System.out.println("You entered " + line);
			vc = new VowelCounter(line);
			vc.countVowels();
			System.out.println(vc.toString());
			
		}
		

	}

}
