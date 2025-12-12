import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    private final Lock lock=new ReentrantLock(true);
    public void loop(int st,int end){
        try {
            if (lock.tryLock(3000, TimeUnit.MILLISECONDS)) {
                for (int i = st; i <= end; i++) {
                    System.out.println(i);
                }
            }
        }catch (Exception e) {
            Thread.currentThread().interrupt();
        }
        finally{
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Main m =new Main();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                if(Thread.currentThread().getName().equals("t1"))
                    m.loop(1,5);
                else
                    m.loop(6,10);
            }
        };

        Thread thread1 = new Thread(runnable,"t1");
        Thread thread2 = new Thread(runnable,"t2");

        thread1.start();
        thread2.start();
    }
}