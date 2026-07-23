public class AdaptiveStrategy implements TrafficStrategy {
    
    @Override
    public String determineLightColor(TrafficLight light, Road road) {
        
        int vehicleCount = road.getVehicleCount();
        
        if(vehicleCount > 5) {
            System.out.println("  [ADAPTIVE] Heavy traffic (" + vehicleCount + " vehicles) → GREEN");
            return "GREEN";
        }
        else if(vehicleCount >= 3) {
            System.out.println("  [ADAPTIVE] Moderate traffic (" + vehicleCount + " vehicles) → GREEN");
            return "GREEN";
        }
        else if(vehicleCount < 2 && vehicleCount > 0) {
            System.out.println("  [ADAPTIVE] Light traffic (" + vehicleCount + " vehicles) → RED");
            return "RED";
        }
        else {
            return "RED";
        }
    }
}