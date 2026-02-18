public class Car {

    final static String brand = "Toyota";
    static String model;
    final double power;

    public Car(double power) {
        this.power = power;
    }

    static void brake() {
        System.out.println("El vehicle està frenant.");
    }
    private void accelerate() {
        System.out.println("El vehicle està accelerant.");
    }
}
