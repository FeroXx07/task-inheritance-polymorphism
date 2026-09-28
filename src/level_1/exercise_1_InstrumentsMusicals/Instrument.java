package level_1.exercise_1_InstrumentsMusicals;

public abstract class Instrument {

    protected String name;
    protected double price;

    public Instrument(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public abstract void play();

    @Override
    public String toString() {
        return "Instrument{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
