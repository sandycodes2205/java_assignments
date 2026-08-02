public class InnerClass {

    class Student {
        void display() {
            System.out.println("This is an Inner Class.");
        }
    }

    public static void main(String[] args) {

        InnerClass outer = new InnerClass();
        Student s = outer.new Student();
        s.display();

        Runnable obj = new Runnable() {
            public void run() {
                System.out.println("This is an Anonymous Class.");
            }
        };

        obj.run();
    }
}