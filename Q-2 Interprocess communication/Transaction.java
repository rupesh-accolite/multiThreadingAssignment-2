public class Transaction{
    public static void main(String[] args) {
        Operations operations = new Operations();
        operations.balance();
        System.out.println("Withdraw Initiated: ");
        new Thread(() -> operations.withdraw(1500)).start();
        System.out.println("Deposit Initiated: ");
        new Thread(() -> operations.deposit(1000)).start();
    }
}
