import java.util.ArrayList;

public class Todoapp {
    public static void main(String[] args) {

        ArrayList<String> tasks = new ArrayList<>();

        tasks.add("Complete Java Assignment");
        tasks.add("Study DBMS");
        tasks.add("Go to Gym");

        StringBuffer sb = new StringBuffer();
        sb.append("To-Do List:\n");

        for (String task : tasks) {
            sb.append(task).append("\n");
        }

        System.out.println(sb);
    }
}