/**
 * Created by Yoder on 7/8/2014.
 */
public class Person {
    String lastName;
    String firstName;
    Person father;

    public Person() {
        father = new Person();
    }

    public Person(String l, String f) {
        lastName = l;
        firstName = f;
    }

    public void setLastName(String l) {
        lastName = l;
    }

    public String getLastName() {
        return lastName;
    }

    public void setFirstName(String f) {
        firstName = f;
    }

    public String getFirstName() {
        return firstName;
    }
}
