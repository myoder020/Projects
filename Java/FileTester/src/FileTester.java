/**
 * Created by Yoder on 6/28/2014.
 */
import java.io.*;


public class FileTester {

    public static void main(String[] args) {
        File f = new File("myFile.txt");
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(f));
            writer.write("writing to a file");
            writer.close();
        } catch (IOException ex) {
            System.out.println("Couldn't write to file");
            ex.printStackTrace();
        }

    }

}
