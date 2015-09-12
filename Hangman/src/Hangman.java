import java.util.*;

/**
 * Created by Yoder on 5/25/2015.
 */
public class Hangman {

    private String word;
    private Map<Character, Integer> contains;
    private Stack<String> words;
    private String temp, partialWord;
    private String build;
    private char[] guess;
    private int place;
    private Queue<String> man;


    public Hangman () {
        man = new ArrayDeque<>();
        words = new Stack<>();
        contains = new HashMap<>();
        init();
        word = getNewWord();
        partialWord = "";
        build = "";
        guess = new char[word.length()];
        showIntro();
        showGuess();
    }

    public void showIntro() {
        System.out.println("Hello and welcome to hangman");
        System.out.println("Please try to guess the word");
        for(int i = 0; i < guess.length; i++) {
            guess[i] = '_';
        }
    }

    public void showGuess() {
        System.out.println(new String(guess));
    }

    public String getNewWord() {
        place = 0;
        if(!words.empty()) {
            temp = words.pop();
            for(Character c:temp.toCharArray())
                contains.put(c, place++);

            return temp;
        }

        return null;
    }

    public boolean check(char c) {
        if(contains.containsKey(c) == true)
            return true;

        return false;
    }

    private void init() {
        words.push("Hippo");
        words.push("Cat");
        words.push("Taco");
        words.push("Bird");
        man.add("________");
        man.add("|       O");
        man.add("|       |");
        man.add("|      /|\\");
        man.add("|       |");
        man.add("|      / \\ ");
    }

    public String isValid(char c, boolean valid) {
        if(valid == true) {
            guess[contains.get(c)] = c;
            partialWord = new String(guess);
            return partialWord;
        } else {
            return buildMan();
        }

    }

    private String buildMan() {
        build += man.remove() + "\n";
        return build;
    }

    public int getGuesses() {
        return man.size();
    }

}
