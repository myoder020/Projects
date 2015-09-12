package palin;

import java.util.Scanner;

public class PalindromeCheckerTester {

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);
		String line = "yes";
		PalimdromeChecker pc = new PalimdromeChecker();

		while (line.equals("Yes".toLowerCase())) {
			System.out.println("Enter a word to see if it's a palindrome");
			line = in.nextLine().toLowerCase();
			pc.setText(line);
			pc.check();
			System.out.println("Would you like to continue??\n" + 
			      "Enter Yes to Continue or No to Stop");
			line = in.nextLine().toLowerCase();
		}

	}

}
