public class Vehicle {
    String name = "Car";
    int speed = 80;
    class Details {
        void display() {
            System.out.println("Vehicle Name: " + name);
            System.out.println("Speed: " + speed + " km/h");
        }
    }
    public static void main(String[] args) {

        Vehicle v = new Vehicle();

        Details d = v.new Details();
        d.display();

        Runnable action = new Runnable() {
            public void run() {
                System.out.println("Vehicle is moving.");
            }
        };

        action.run();
    }
}