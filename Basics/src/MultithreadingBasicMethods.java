public class MultithreadingBasicMethods extends Thread {
    MultithreadingBasicMethods(String name){
        super(name); // giving name to thread , super is calling the constructor of parent class Thread  , more preferred
//        this.setName(name); // this is also same as super(name) above command but less preferred
    }
    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            try {
                Thread.sleep(300); //  Pauses the current thread for 300 milliseconds.
                System.out.println(Thread.currentThread().getName() + "-" + i);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        MultithreadingBasicMethods multithreadingMethods1=new MultithreadingBasicMethods("t1");
        multithreadingMethods1.start();
        multithreadingMethods1.join(); // now main method waits for multithreadingMethods1 to complete its work
        System.out.println("hello");
    }
}
