import java.util.ArrayList;
import java.util.Scanner;

public class CourseRegistration {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<String> courses = new ArrayList<>();

        int choice;

        do {
            System.out.println("\n1. Add Course");
            System.out.println("2. Remove Course");
            System.out.println("3. View Courses");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter course name: ");
                    String course = sc.nextLine();
                    courses.add(course);
                    System.out.println("Course added.");
                    break;

                case 2:
                    System.out.print("Enter course name to remove: ");
                    course = sc.nextLine();
                    courses.remove(course);
                    System.out.println("Course removed.");
                    break;

                case 3:
                    StringBuffer sb = new StringBuffer();
                    sb.append("Registered Courses:\n");

                    for (String c : courses) {
                        sb.append(c).append("\n");
                    }

                    System.out.println(sb);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 4);

        sc.close();
    }
}