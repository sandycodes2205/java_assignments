interface Printable {
    void print();
}

class Student implements Printable {

    public void print() {
        System.out.println("Student Details Printed.");
    }
}

class Employee implements Printable {

    public void print() {
        System.out.println("Employee Details Printed.");
    }
}

public class PrintableClass {
    public static void main(String[] args) {

        Student s = new Student();
        Employee e = new Employee();

        s.print();
        e.print();
    }
}