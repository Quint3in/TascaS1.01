public class PercussionInstrument extends Instrument {
    public PercussionInstrument(String name) {
        super(name);
    }

    @Override
    void play() {
        System.out.println("Està sonant un instrument de percussió");
    }
}
