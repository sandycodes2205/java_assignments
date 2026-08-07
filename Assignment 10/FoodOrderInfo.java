abstract class FoodOrder {

    abstract void calculateBill();
}

class DineInOrder extends FoodOrder {

    int bill = 500;

    void calculateBill() {
        System.out.println("Dine-In Bill = " + bill);
    }
}

class TakeAwayOrder extends FoodOrder {

    int bill = 450;

    void calculateBill() {
        System.out.println("Take Away Bill = " + bill);
    }
}

public class FoodOrderInfo {
    public static void main(String[] args) {

        DineInOrder d = new DineInOrder();
        TakeAwayOrder t = new TakeAwayOrder();

        d.calculateBill();
        t.calculateBill();
    }
}