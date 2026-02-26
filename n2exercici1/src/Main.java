public class Main {
    public static void main(String[] args) {
        Smartphone phone1 = new Smartphone("Samsung","A10");
        phone1.call(777888999);
        phone1.ringAlarm();
        phone1.takePhoto();
        System.out.println(phone1.getBrand());
        System.out.println(phone1.getModel());
    }
}