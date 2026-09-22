package level_1.exercise_1_InstrumentsMusicals;

import java.util.ArrayList;

public class Main {
    static void main(String[] args) {

        ArrayList<Instrument> instruments = new ArrayList<Instrument>();

        instruments.add(new WindInstrument("WindInstrument", 20.0));
        instruments.add(new StringInstrument("StringInstrument", 10.0));
        instruments.add(new PercussionInstrument("PercussionInstrument", 30.0));

        for (Instrument instrument : instruments) {
            instrument.play();
        }

        SampleBlockClass sampleBlockClass = new SampleBlockClass();
        System.out.println(sampleBlockClass);
    }
}
