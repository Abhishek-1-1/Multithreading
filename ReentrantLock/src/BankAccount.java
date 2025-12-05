import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BankAccount {

    private final Lock lock =new ReentrantLock();
    private int balance=400;

    public int getBalance() {
        return balance;
    }

//    public synchronized void withdraw(int amount){     // synchronized keyword use
        public void withdraw(int amount){

        try {
            System.out.println(Thread.currentThread().getName() + " is attempting to acquire lock");
            if (lock.tryLock(2, TimeUnit.SECONDS)) {
                System.out.println(Thread.currentThread().getName() + " acquired lock and is attempting withdraw ");
                if (amount <= balance) {
                    System.out.println(Thread.currentThread().getName() + " proceeding with transaction ");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt(); // good practice for
                    }finally {
                        lock.unlock();
                    }
                    balance -= amount;
                    System.out.println(Thread.currentThread().getName() + " withdraw successful , new balance - " + getBalance());
                } else {
                    System.out.println("balance not sufficient");
                }
            } else {
                System.out.println(Thread.currentThread().getName() + " could not acquire lock");
            }
        }catch (Exception e){
            Thread.currentThread().interrupt();
        }
    }


}
