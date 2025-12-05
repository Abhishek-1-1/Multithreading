package synchronizedKeyword;

public class Counter {
    private int counter=0;

//    public void incrementCounter(){  // this will random output like 1803 , 1865,1600 because two threads can increment at same time
//        counter++;
//    }

    // example of synchronized method
    public synchronized void incrementCounter() {   // this will ensures now that counter will always be 2000
        counter++;
    }

    // example of synchronized block
//    public void incrementCounter(){
//        synchronized (this){
//            counter++;
//        }
//    }

    public int getCounter() {
        return counter;
    }

}
