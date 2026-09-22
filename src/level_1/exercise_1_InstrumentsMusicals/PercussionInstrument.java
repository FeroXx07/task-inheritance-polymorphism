package level_1.exercise_1_InstrumentsMusicals;

public class PercussionInstrument extends Instrument {

    public PercussionInstrument(String name, double price) {
        super(name, price);
    }

    @Override
    public void play() {
        System.out.println("Està sonant un instrument de percussió");
    }
}
