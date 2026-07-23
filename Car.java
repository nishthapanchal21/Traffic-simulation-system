public class Car extends Vehicle {
    
    public Car(String id) {
        super(id, 60.0);
    }
    
    @Override
    public String getType() {
        return "Car";
    }
}