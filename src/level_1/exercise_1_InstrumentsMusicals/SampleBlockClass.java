package level_1.exercise_1_InstrumentsMusicals;

public class SampleBlockClass {
    // - Static Initialization Blocks
    // - Static Initialization Methods
    // - Non-Static Initialization Blocks
    // - Non-Static Initialization Methods (Preferably final methods)

    public static String myVarA;
    public String myVarB = myVarNonStaticInitialization();

    @Override
    public String toString() {
        return "SampleBlockClass{" +
                "myVarA='" + myVarA + '\'' +
                "myVarB='" + myVarB + '\'' +
                '}';
    }

    // Can have any number of static initialization blocks, and they can appear anywhere in the class body
    static {
        myVarA = "myStaticVarA";
    }

    // This is especially useful if subclasses might want to reuse the initialization method.
    // The method is final because calling non-final methods during instance initialization can cause problems.
    protected final String myVarNonStaticInitialization(){
        return "myNonStaticVar";
    }
}
