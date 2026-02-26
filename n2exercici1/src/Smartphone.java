public class Smartphone extends Phone implements Clock, Camera {

    public Smartphone(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void takePhoto() {
        Camera.super.takePhoto();
    }

    @Override
    public void ringAlarm() {
        Clock.super.ringAlarm();
    }

    @Override
    public void call(int number) {
        super.call(number);
    }
}
