public class ThreadStates extends Thread{
    @Override
    public void run() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        ThreadStates t1=new ThreadStates();
        System.out.println(t1.getState());
        t1.start();
        System.out.println(t1.getState());
        Thread.sleep(1000);
        System.out.println(t1.getState());
        t1.join();
        System.out.println(t1.getState());
    }
}
