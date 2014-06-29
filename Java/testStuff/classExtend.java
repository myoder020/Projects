public class classExtend extends myClass {

    public classExtend() {
        System.out.println("now in the subclass classExtend");
    }

    public void doMoreStuff() {
        System.out.println("in doMoreStuff");
        super.doStuff(8);
    }
}
