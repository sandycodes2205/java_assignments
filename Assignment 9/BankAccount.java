class BankAccount {

    final int accountNumber = 123456;
    String accountHolder = "Rahul";
    double balance = 5000;

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {

        BankAccount obj = new BankAccount();
        obj.display();

        // obj.accountNumber = 789101; // Not allowed 
    }
}