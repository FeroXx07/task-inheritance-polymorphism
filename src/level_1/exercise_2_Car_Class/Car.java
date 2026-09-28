package level_1.exercise_2_Car_Class;

public class Car {
    private static final String BRAND = "Cupra";
    private static String model;
    private final int power;

    // Only static and non-static final can be initialized through constructor.
    public Car(String model, int power) {
        this.power = power;
        Car.model = model;
    }

    public static void brake(){
        System.out.println("El vehicle està frenant");
    }

    public void accelerate(){
        System.out.println("El vehicle està accelerant");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + BRAND + '\'' +
                "model='" + model + '\'' +
                "power='" + power + '\'' +
                '}';
    }
}
