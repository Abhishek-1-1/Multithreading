public class MultithreadingMoreMethods extends Thread {
    MultithreadingMoreMethods(String name){
        super(name);
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                System.out.println("Interrupted " + e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException{
        MultithreadingMoreMethods multithreadingMoreMethods1=new MultithreadingMoreMethods("t1");
        MultithreadingMoreMethods multithreadingMoreMethods2=new MultithreadingMoreMethods("t2");
        multithreadingMoreMethods1.start();
        multithreadingMoreMethods2.start();
        multithreadingMoreMethods1.interrupt();

    }
}
