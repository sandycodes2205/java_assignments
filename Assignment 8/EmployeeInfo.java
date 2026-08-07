class Employee {
    String name = "Rahul";
    int id = 101;
}

class Manager extends Employee {
    String department = "Sales";

    void display() {
        System.out.println("Employee Name: " + super.name);
        System.out.println("Employee ID: " + super.id);
        System.out.println("Department: " + department);
    }
}

public class EmployeeInfo {
    public static void main(String[] args) {

        Manager m = new Manager();
        m.display();
    }
}