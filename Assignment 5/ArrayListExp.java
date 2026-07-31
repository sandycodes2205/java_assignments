import java.util.ArrayList;
import java.util.Vector;

public class ArrayListExp {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Mango");

        System.out.println("ArrayList Elements:");
        for (String item : list) {
            System.out.println(item);
        }

        Vector<Integer> vector = new Vector<>();
        vector.add(10);
        vector.add(20);
        vector.add(30);

        System.out.println("\nVector Elements:");
        for (int num : vector) {
            System.out.println(num);
        }

        StringBuffer str = new StringBuffer("Java");
        str.append(" Programming");

        System.out.println("\nStringBuffer Output:");
        System.out.println(str);
    }
}