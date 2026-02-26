public abstract class Instrument {

    String name;
    static double price = 50;

    public Instrument(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    static {
        System.out.println("mensaje estático antes de que suene el tambor");
    }
    {
        System.out.println("Clase instanciada");
    }

    abstract void play();

}
