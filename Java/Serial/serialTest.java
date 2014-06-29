import java.io.*;

public class serialTest {

    public static void main(String[] args) {
        Integer one = 1;
        Integer two = 2;

        try {
            ObjectOutputStream os = new ObjectOutputStream(new FileOutputStream("int.ser"));
            os.writeObject(one);
            os.writeObject(two);
            os.close();
        } catch(IOException ex) {
            ex.printStackTrace();
        }

        System.out.println(one);
        System.out.println(two);

        one = null;
        two = null;

        System.out.println(one);
        System.out.println(two);

        try {
            ObjectInputStream is = new ObjectInputStream(new FileInputStream("int.ser"));
            Integer newO = (Integer) is.readObject();
            Integer newT = (Integer) is.readObject();
            System.out.println(newO);
            System.out.println(newT);
            is.close();
        } catch(Exception ex) {
            ex.printStackTrace();
        }
    }
}

