package level_1.exercise_1_InstrumentsMusicals;

public class StringInstrument extends Instrument {
    {
        System.out.println("Non-Static block ejecutado dentro de StringInstrument");
        price = initPrice();
    }
    public StringInstrument(String name, double price) {
        super(name, price);
    }

    @Override
    public void play() {
        System.out.println("Està sonant un instrument de corda " + this);
    }

    private final double initPrice() {
        System.out.println("Non-Static (final) initializer method ejecutado dentro del inti block de StringInstrument");
        return 200;
    }
}
