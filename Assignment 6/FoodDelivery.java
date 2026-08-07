public class FoodDelivery {
    class Order {
        int orderId = 101;
        String item = "Pizza";
        void displayOrder() {
            System.out.println("Order ID: " + orderId);
            System.out.println("Food Item: " + item);
        }
    }
    public static void main(String[] args) {
        FoodDelivery app = new FoodDelivery();
        Order order = app.new Order();
        order.displayOrder();
        Runnable deliveryStatus = new Runnable() {
            public void run() {
                System.out.println("Delivery Status: Delivered Successfully.");
            }
        };

        deliveryStatus.run();
    }
}