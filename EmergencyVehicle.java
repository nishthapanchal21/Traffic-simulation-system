public class EmergencyVehicle extends Vehicle {
    
    private boolean sirenOn;
    
    public EmergencyVehicle(String id) {
        super(id, 80.0);
        this.sirenOn = true;
    }
    
    public void turnOnSiren() {
        sirenOn = true;
        System.out.println(" " + id + " siren ON!");
    }
    
    public boolean isSirenOn() {
        return sirenOn;
    }
    
    @Override
    public String getType() {
        return "Emergency";
    }
}