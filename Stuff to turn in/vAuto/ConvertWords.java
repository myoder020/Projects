/**
 * Created by Yoder on 7/9/2014.
 */

/*Problem Description:
PP 1.4: In the programming language of your choice, write a program that parses a sentence and replaces each
word with the following: first letter, number of distinct characters between first and last character, and last letter.
For example, Smooth would become S3h. Words are separated by spaces or non-alphabetic characters and these separators
should be maintained in their original form and location in the answer.
*/

/*
Notes: This program takes a senctence from the command line.
 I made the assumption that by non-alphabetic characters it meant everything that wasn't a letter. IE all special
 characters and numbers. I wrote my program around that assumption and because of that I forgot to take into consideration
 about words where numbers are used so something like 20,000 will not work on my program.
 */

public class ConvertWords {

    int[] distinct;
    String delims[];

    public static void main(String[] args) {
        ConvertWords s = new ConvertWords();
        String sentence = "";
        for(String word : args)
            sentence += word + " ";
        System.out.println(sentence);
        String[] n2 = sentence.split("[^a-zA-Z]");
        String[] seps = s.getDelims(sentence);

        for(int i = 0; i < n2.length; i++) {
            s.countDistinct(n2[i], seps[i]);
        }
    }

    public void countDistinct(String word, String delim) {
        int temp = 0;
        distinct = new int[256];
        String sub = getSub(word);
        if(word.length() > 2) {
            for (int i = 0; i < sub.length(); i++) {
                if (sub.charAt(i) != distinct[sub.charAt(i)]) {
                    distinct[sub.charAt(i)] = sub.charAt(i);
                    temp++;
                }
            }
            word = word.replaceFirst(sub, Integer.toString(temp));
        }
        printWord(word, delim);
    }

    public String getSub(String word) {
        if(word.length() > 2) {
            String sub = word.substring(1, word.length() - 1);
            return sub;
        }
        else
            return word;
    }

    public String[] getDelims(String sentence) {
        delims = new String[1024];
        String temp = sentence.replaceAll("[a-zA-Z]", "");
        for(int i = 0; i < temp.length(); i++)
            delims[i] = temp.charAt(i) + "";
        delims[temp.length()-1] = "";
        return delims;
    }

    public void printWord(String word, String delim) {
        if(word.length() == 2)
            System.out.print(word.charAt(0) + "0" + word.charAt(1) + delim);
        else
            System.out.print(word + delim);
    }
}
