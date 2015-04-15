/**
 * Created by Yoder on 7/2/2014.
 */
public class RyanAndMonicaJob implements Runnable {

    BankAccount account = new BankAccount();
    int amount;

    public static void main(String[] args) {
        RyanAndMonicaJob theJob = new RyanAndMonicaJob();
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Ryan");
        two.setName("Monica");
        one.start();
        two.start();
    }

    public void run() {
        for( int x = 0; x < 10; x++) {
            synchronized(this) {
                makeWithdrawal(10);
            }
            if(account.getBalance() < 0) {
                System.out.println("Overdrawn");
            }
        }
    }

    class BankAccount {
        private int balance = 100;

        int getBalance() {
            return balance;
        }

        void withdraw(int amount) {
            balance = balance - amount;
        }
    }

    private void makeWithdrawal(int amount) {
        if(account.getBalance() >= amount) {
            System.out.println(Thread.currentThread().getName() + " is about to withdraw");
            try {
                System.out.println(Thread.currentThread().getName() + " is going to sleep");
                Thread.sleep(500);
            } catch(InterruptedException ex) {
                ex.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " woke up");
            account.withdraw(amount);
            System.out.println(Thread.currentThread().getName() + " completes the withdrawal");
        } else {
            System.out.println("Sorry, not enough for " + Thread.currentThread().getName());
        }
    }
}
