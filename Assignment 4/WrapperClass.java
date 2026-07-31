public class WrapperClass {
    public static void main(String[] args) {

        int num = 25;
        double value = 12.5;

        Integer obj1 = num;
        Double obj2 = value;

        System.out.println("Wrapper Integer: " + obj1);
        System.out.println("Wrapper Double: " + obj2);

        int n = obj1;
        double d = obj2;

        System.out.println("Primitive Integer: " + n);
        System.out.println("Primitive Double: " + d);

        int sum = obj1 + 10;
        double product = obj2 * 2;

        System.out.println("Sum = " + sum);
        System.out.println("Product = " + product);
    }
}