public class Truck extends Vehicle {
    
    public Truck(String id) {
        super(id, 40.0);
    }
    
    @Override
    public String getType() {
        return "Truck";
    }
}