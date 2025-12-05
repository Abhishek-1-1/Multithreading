public class BankAccount {
    private int balance=400;

    public int getBalance() {
        return balance;
    }

    public synchronized void withdraw(int amount){     // synchronized keyword use
        System.out.println(Thread.currentThread().getName() + " is attempting withdraw ");
        if(amount<= balance){
            System.out.println(Thread.currentThread().getName() + " proceeding with transaction ");
            try{
                Thread.sleep(2000);
            }catch (InterruptedException e){

            }
            balance-=amount;
            System.out.println(Thread.currentThread().getName() + " withdraw successful , new balance - " + getBalance());
        }else{
            System.out.println("balance not sufficient");
        }
    }


}
