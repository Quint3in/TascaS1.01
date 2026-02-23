public class Main {
    public static void main(String[] args) {
        Smartphone telefon1 = new Smartphone("Samsung","A10");
        telefon1.call(777888999);
        telefon1.ringAlarm();
        telefon1.takePhoto();
        System.out.println(telefon1.getBrand());
        System.out.println(telefon1.getModel());
    }
}