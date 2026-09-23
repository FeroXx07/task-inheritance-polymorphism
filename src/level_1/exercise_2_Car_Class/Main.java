package level_1.exercise_2_Car_Class;

public class Main {

    static void main(String[] args) {
        Car.brake();
        Car carA = new Car("formentor", 1300);

        carA.accelerate();

        System.out.println(carA);

        Car carB = new Car("raval", 1000);

        // Both will have the same model since it is static
        System.out.println(carB);
        System.out.println(carA);
    }
}
