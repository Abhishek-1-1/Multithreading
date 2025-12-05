public class Main {
    public static void main(String[] args) {
        BankAccount sbi=new BankAccount();
        Runnable runnable=new Runnable() {
            @Override
            public void run() {
                sbi.withdraw(50);
            }
        };

        Thread t1=new Thread(runnable,"t1");
        Thread t2=new Thread(runnable,"t2");
        t1.start();
        t2.start();
    }
}