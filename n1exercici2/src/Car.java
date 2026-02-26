public class Car {

    static final String brand = "Toyota";
    static String model;
    private final double power;

    public Car(double power) {
        this.power = power;
    }

    public double getPower() {
        return power;
    }

    public static void brake() {
        System.out.println("El vehicle està frenant.");
    }
    public void accelerate() {
        System.out.println("El vehicle està accelerant.");
    }
}
