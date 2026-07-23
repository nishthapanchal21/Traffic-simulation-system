public class FixedTimeStrategy implements TrafficStrategy {
    
    @Override
    public String determineLightColor(TrafficLight light, Road road) {
        long currentTime = System.currentTimeMillis() / 1000;
        
        if((currentTime % 60) < 30) {
            return "GREEN";
        } else {
            return "RED";
        }
    }
}