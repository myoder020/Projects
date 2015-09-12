package palin;

import java.util.Stack;
import java.util.StringTokenizer;

public class PalimdromeChecker {

    private String text;
    private int end, begin, middle, i;

    public PalimdromeChecker() {

    }

    public void check() {
        end = text.length() - 1;
        begin = 0;
        middle = end/2;
        for (i = 0; i < middle; i++) {
            if (text.charAt(begin) == text.charAt(end)) {
                end--;
                begin++;
            } else {
                break;
            }
        }
        if(middle == i)
            System.out.println("Word was a palindrome");
        else
            System.out.println("Word was not a palindrome");

    }

    public void setText(String text) {
        this.text = text;
    }

}
