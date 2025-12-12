import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantExample {
    private final Lock lock =new ReentrantLock();

    // here both methods depends on each other but ReentrantLock() lock handles this it allows
    // multiple entry for same thread and to acquire lock, no of lock should match number of unlocks.
    public void outerMethod(){
        lock.lock();
        try {
            innerMethod();
        }finally {
            lock.unlock();
        }
    }
    public void innerMethod(){
        lock.lock();
        try {
            System.out.println("inner method");
        }finally {
            lock.unlock();
        }
    }
    public static void main(String[] args) {
        ReentrantExample reentrantExample=new ReentrantExample();
        reentrantExample.outerMethod();
    }
}
