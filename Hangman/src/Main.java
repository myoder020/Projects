import java.util.Scanner;

/**
 * Created by Yoder on 5/25/2015.
 */
public class Main {

    public static void main(String[] args) {

        Hangman hang = new Hangman();
        String play = "y";
        char temp;
        Scanner read = new Scanner(System.in);
        boolean status = false;
        while(play.toLowerCase().equals("y")) {
            while(hang.getGuesses() > 0) {
                temp = read.next().toCharArray()[0];
                status = hang.check(temp);
                System.out.println(hang.isValid(temp, status));
            }
            System.out.println("Do you want to play again?");
            play = read.next();
        }

    }

}
