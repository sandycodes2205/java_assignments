class Vehicle {
    String vehicleName = "Car";
    String vehicleNumber = "MH12AB1234";
}

class Insurance extends Vehicle {
    String policyType = "Comprehensive";

    void display() {
        System.out.println("Vehicle Name: " + super.vehicleName);
        System.out.println("Vehicle Number: " + super.vehicleNumber);
        System.out.println("Policy Type: " + policyType);
    }
}

public class VehicleInsurance {
    public static void main(String[] args) {

        Insurance obj = new Insurance();
        obj.display();
    }
}