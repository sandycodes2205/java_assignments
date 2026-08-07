class Shape {
    void area() {
        System.out.println("Area of Shape");
    }
}

class Circle extends Shape {
    double radius = 5;

    void area() {
        double area = 3.14 * radius * radius;
        System.out.println("Area of Circle = " + area);
    }
}

class Rectangle extends Shape {
    int length = 8;
    int breadth = 4;

    void area() {
        int area = length * breadth;
        System.out.println("Area of Rectangle = " + area);
    }
}

public class ShapeArea {
    public static void main(String[] args) {

        Circle c = new Circle();
        Rectangle r = new Rectangle();

        c.area();
        r.area();
    }
}