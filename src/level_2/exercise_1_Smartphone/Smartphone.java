package level_2.exercise_1_Smartphone;

public class Smartphone extends Phone implements Camera, Clock{
    public Smartphone(String brand, String model) {
        super(brand, model);
    }

    @Override
    public void takePicture() {
        System.out.println(this + " is currently taking a picture.");
    }
    @Override
    public void engageAlarm() { System.out.println(this + " has engaged the alarm.");}
}
