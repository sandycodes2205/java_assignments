class Bank {
    int balance = 1000;

    synchronized void deposit(int amount) {
        balance += amount;
        System.out.println("Deposited: " + amount);
        System.out.println("Balance: " + balance);
    }

    synchronized void withdraw(int amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println("Withdrawn: " + amount);
            System.out.println("Balance: " + balance);
        } else {
            System.out.println("Insufficient balance!");
        }
    }
}

class DepositThread extends Thread {
    Bank bank;

    DepositThread(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            bank.deposit(500);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

class WithdrawThread extends Thread {
    Bank bank;

    WithdrawThread(Bank bank) {
        this.bank = bank;
    }

    public void run() {
        for (int i = 1; i <= 3; i++) {
            bank.withdraw(300);
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println(e);
            }
        }
    }
}

public class BankTransactions {
    public static void main(String[] args) {
        Bank bank = new Bank();

        DepositThread t1 = new DepositThread(bank);
        WithdrawThread t2 = new WithdrawThread(bank);

        t1.start();
        t2.start();
    }
}
