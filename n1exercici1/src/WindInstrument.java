public class WindInstrument extends Instrument{
    public WindInstrument(String name) {
        super(name);
    }

    @Override
    void play() {
        System.out.println("Està sonant un instrument de vent");
    }
}
