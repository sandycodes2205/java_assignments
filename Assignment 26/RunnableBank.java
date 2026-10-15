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

class DepositTask implements Runnable {
    Bank bank;

    DepositTask(Bank bank) {
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

class WithdrawTask implements Runnable {
    Bank bank;

    WithdrawTask(Bank bank) {
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

public class RunnableBank {
    public static void main(String[] args) {
        Bank bank = new Bank();

        Thread t1 = new Thread(new DepositTask(bank));
        Thread t2 = new Thread(new WithdrawTask(bank));

        t1.start();
        t2.start();
    }
}