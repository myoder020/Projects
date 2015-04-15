/**
 * Created by Yoder on 7/2/2014.
 */
public class RunThreads implements Runnable {
    public static void main(String[] args) {
        RunThreads runner = new RunThreads();
        Thread first = new Thread(runner);
        Thread second = new Thread(runner);
        first.setName("First thread");
        second.setName("Second thread");
        first.start();
        second.start();
    }

    public void run() {
        for(int i = 0; i < 10; i++) {
            String threadName = Thread.currentThread().getName();
            System.out.println(threadName);
        }
    }
}
