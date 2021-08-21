public class Operations {
    private static int accBalance = 1000;

    protected void balance(){
        System.out.println("Current balance: " + accBalance);
    }

    protected synchronized void withdraw(int amount){
        if(amount>accBalance){
            System.out.println("Insufficient funds to withdraw.");
            try{
                System.out.println("Waiting for amount to get deposited.");
                Thread.sleep(5000);
                wait();

            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        accBalance -= amount;
        balance();
        System.out.println("Withdraw Successful.");
    }
    protected synchronized void deposit(int amount){
        accBalance += amount;
        System.out.println("Deposit Successful.");
        balance();
        notify();

    }
}
