public class StudentMain {
    String name;
    int rollNo;

    StudentMain() {
        name = "Not Assigned";
        rollNo = 0;
    }

    StudentMain(String n, int r) {
        name = n;
        rollNo = r;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollNo);
    }

    public static void main(String[] args) {
        StudentMain s1 = new StudentMain();
        StudentMain s2 = new StudentMain("Rahul", 101);

        System.out.println("Default Constructor:");
        s1.display();

        System.out.println("\nParameterized Constructor:");
        s2.display();
    }
}