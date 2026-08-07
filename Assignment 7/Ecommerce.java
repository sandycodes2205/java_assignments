interface Product {
    void display();
}

class ProductDetails {
    String name;
    int price;
}

class Electronic extends ProductDetails implements Product {

    Electronic(String n, int p) {
        name = n;
        price = p;
    }

    public void display() {
        System.out.println("Electronic Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Clothing extends ProductDetails implements Product {

    Clothing(String n, int p) {
        name = n;
        price = p;
    }

    public void display() {
        System.out.println("Clothing Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

class Grocery extends ProductDetails implements Product {

    Grocery(String n, int p) {
        name = n;
        price = p;
    }

    public void display() {
        System.out.println("Grocery Product");
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
    }
}

public class Ecommerce {
    public static void main(String[] args) {

        Electronic e = new Electronic("Laptop", 60000);
        Clothing c = new Clothing("T-Shirt", 800);
        Grocery g = new Grocery("Rice", 120);

        e.display();
        System.out.println();

        c.display();
        System.out.println();

        g.display();
    }
}