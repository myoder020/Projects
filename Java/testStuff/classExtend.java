public class classExtend extends myClass {

    public classExtend() {
        System.out.println("now in the subclass classExtend");
    }

    public void doMoreStuff(int temp) {
        System.out.println("in doMoreStuff");
        doStuff(temp);
    }
}
