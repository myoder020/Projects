/**
 * Created by Yoder on 6/28/2014.
 */
import java.io.*;

public class ReadTest {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"));
            String line = null;
            line = reader.readLine();
            System.out.println(line);
            reader.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
