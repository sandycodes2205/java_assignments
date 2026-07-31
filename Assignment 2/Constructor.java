class Student {
    int rollNo;
    String name;

    Student() {
        rollNo = 0;
        name = "NA";
    }

    Student(int r, String n) {
        rollNo = r;
        name = n;
    }

    Student(Student s) {
        rollNo = s.rollNo;
        name = s.name;
    }

    void display() {
        System.out.println("Roll No: " + rollNo);
        System.out.println("Name: " + name);
    }
}

public class Constructor {
    public static void main(String[] args) {

        Student s1 = new Student();
        System.out.println("Default Constructor:");
        s1.display();

        Student s2 = new Student(101, "Rahul");
        System.out.println("\nParameterized Constructor:");
        s2.display();

        Student s3 = new Student(s2);
        System.out.println("\nCopy Constructor:");
        s3.display();
    }
}