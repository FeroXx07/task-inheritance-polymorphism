package level_1.exercise_2_Car_Class;

public class Car {

    // Only static and non-static final can be initialized through constructor.
    public Car(String model, String power) {
        this.power = power;
        Car.model = model;
    }

    private static final String brand = "Cupra";
    private static String model;
    private final String power;

    public static void brake(){
        System.out.println("El vehicle està frenant");
    }

    public void accelerate(){
        System.out.println("El vehicle està accelerant");
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                "model='" + model + '\'' +
                "power='" + power + '\'' +
                '}';
    }
}
