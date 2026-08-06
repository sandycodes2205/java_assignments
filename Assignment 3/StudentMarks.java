public class StudentMarks {
    public static void main(String[] args) {

        String mark1 = "75";
        String mark2 = "80";
        String mark3 = "90";

        Integer m1 = Integer.valueOf(mark1);
        Integer m2 = Integer.valueOf(mark2);
        Integer m3 = Integer.valueOf(mark3);

        int total = m1 + m2 + m3;

        System.out.println("Marks:");
        System.out.println("Subject 1 = " + m1);
        System.out.println("Subject 2 = " + m2);
        System.out.println("Subject 3 = " + m3);
        System.out.println("Total Marks = " + total);
    }
}