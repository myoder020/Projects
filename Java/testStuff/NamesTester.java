/**
 * Created by Yoder on 7/7/2014.
 */
import java.util.*;
import java.io.*;

public class NamesTester {

    ArrayList<Names> names = new ArrayList<Names>();
    public static void main(String[] args) {
        File file = new File("./testFile.txt");
        NamesTester tester = new NamesTester();
        tester.parseFile(file);
        tester.printNames();
    }

    public void parseFile(File f) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(f));
            String line;
            while((line = reader.readLine()) != null)
                addNames(line);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void addNames(String l) {
        String[] firstLast = l.split("/");
        Names temp = new Names(firstLast[0], firstLast[1]);
        names.add(temp);
    }

    public void printNames() {
        for(Names name : names)
            System.out.println(name);
    }
}
