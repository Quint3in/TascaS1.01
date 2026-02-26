public class Main {
  public static void main(String[] args) {
    Car car1 = new Car(125);
    Car car2 = new Car(150);
    Car.model = "gt86";

    System.out.println(Car.brand);

    System.out.println(car1.model);
    // El ide ya me avisa de que llamarlo a través de una instáncia es inútil porque es estático

    System.out.println("Cotxe1 potencia:" + car1.getPower());
    System.out.println("Cotxe2 potencia:" + car2.getPower());
    Car.brake();
    car1.accelerate();
    car2.accelerate();
  }
}
