class Calculator {

    static int count = 0;

    void add(int a, int b) {
        System.out.println("Sum of two integers = " + (a + b));
        count++;
    }

    void add(int a, int b, int c) {
        System.out.println("Sum of three integers = " + (a + b + c));
        count++;
    }

    void add(double a, double b) {
        System.out.println("Sum of two double values = " + (a + b));
        count++;
    }

    static void showCount() {
        System.out.println("Total methods called = " + count);
    }
}

public class MethodOverloading {
    public static void main(String[] args) {

        Calculator obj = new Calculator();

        obj.add(10, 20);
        obj.add(5, 10, 15);
        obj.add(12.5, 7.5);

        Calculator.showCount();
    }
}