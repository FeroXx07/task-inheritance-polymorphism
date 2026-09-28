package level_1.exercise_1_InstrumentsMusicals;

public class WindInstrument extends Instrument {
    public WindInstrument(String name, double price) {
        super(name, price);
    }

    @Override
    public void play() {
        System.out.println("Està sonant un instrument de vent " + this);
    }

    public static void staticPlay() {System.out.println("Static method llamado de WindInstrument");}
}
