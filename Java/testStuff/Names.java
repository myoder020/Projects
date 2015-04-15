/**
 * Created by Yoder on 7/7/2014.
 */
public class Names {
    private String first;
    private String second;

    public Names(String f, String s) {
        first = f;
        second = s;
    }

    public String getFirst() {
        return first;
    }

    public String getSecond() {
        return second;
    }

    public String toString() {
        return first + " " + second;
    }
}
