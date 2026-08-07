abstract class Payment {

    abstract void pay();
}

class CreditCard extends Payment {

    void pay() {
        System.out.println("Payment made using Credit Card.");
    }
}

class UPI extends Payment {

    void pay() {
        System.out.println("Payment made using UPI.");
    }
}

public class PaymentSystem {
    public static void main(String[] args) {

        CreditCard c = new CreditCard();
        UPI u = new UPI();

        c.pay();
        u.pay();
    }
}