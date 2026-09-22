package level_1.exercise_1_InstrumentsMusicals;

public class StringInstrument extends Instrument {
    public StringInstrument(String name, double price) {
        super(name, price);
    }

    @Override
    public void play() {
        System.out.println("Està sonant un instrument de corda");
    }
}
