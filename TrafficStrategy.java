public interface TrafficStrategy {
    String determineLightColor(TrafficLight light, Road road);
}