/**
 * Created by Yoder on 6/28/2014.
 */
import java.io.*;

public class ReadTest {

    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("myFile.txt"));
            String line;
            while((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            reader.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
