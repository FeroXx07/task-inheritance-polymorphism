package level_2.exercise_1_Smartphone;

public class Phone  {

    public Phone(String brand, String model) {
        this.brand = brand;
        this.model = model;
    }

    protected String brand;
    protected String model;

    public void makeCall(String phoneNumber){
        System.out.println("Making a call to the following number: " + phoneNumber);
    }

    @Override
    public String toString() {
        return "Phone{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}
