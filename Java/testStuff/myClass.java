public class myClass {

   static int temp = 1;

   public myClass() {
       System.out.println("this is the superclass");
       System.out.println("this is instance " + temp++);
   }

   public void doStuff(int x) {
       System.out.println("in the doStuff method");
       System.out.println("the value passed is " + x);
   }
}





    
