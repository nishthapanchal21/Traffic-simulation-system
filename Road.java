public class Road {
    
    private String name;
    private double length;
    private int vehicleCount;
    
    public Road(String name, double length) {
        this.name = name;
        this.length = length;
        this.vehicleCount = 0;
    }
    
    public String getName() {
        return name;
    }
    
    public double getLength() {
        return length;
    }
    
    public void addVehicle() {
        vehicleCount++;
    }
    
    public void removeVehicle() {
        if(vehicleCount > 0) {
            vehicleCount--;
        }
    }
    
    public void setVehicleCount(int count) {
        this.vehicleCount = count;
    }
    
    public int getVehicleCount() {
        return vehicleCount;
    }
    
    public void displayInfo() {
        System.out.println("Road: " + name + " | Length: " + length + "m | Vehicles: " + vehicleCount);
    }
}