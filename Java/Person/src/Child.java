/**
 * Created by Yoder on 7/8/2014.
 */
public class Child extends Person {

    int age;
    int height;
    Person guardian;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setGuardian(Person g) {
        guardian = g;
    }

    public Person getGuardian() {
        return guardian;
    }


}
