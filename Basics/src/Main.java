import baseClasses.Thread1;
import baseClasses.Thread2;

public class Main {
    public static void main(String[] args) {

        // multithreading by extending Thread class
        Thread1 t1=new Thread1("t1");

        // multithreading by implementing runnable interface
        Thread2 thread2=new Thread2();
        Thread t2=new Thread(thread2,"t2"); // java predefined Thread class

        t1.start();
        t2.start();
    }
}