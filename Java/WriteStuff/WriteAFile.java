import java.io.*;

public class WriteAFile {
    public static void main(String[] args) {

        try {
            FileWriter writer = new FileWriter("foo.txt");
            writer.write("this is text that was written to a file called foo.txt");
            writer.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}

