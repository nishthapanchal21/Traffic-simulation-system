import java.util.*;

public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("   TRAFFIC SIMULATION SYSTEM");
        System.out.println("========================================");
        System.out.println();
        
        try {
            Road road = new Road("Main Street", 1000);
            
            System.out.println("Choose traffic light strategy:");
            System.out.println("   1. Fixed Time Strategy");
            System.out.println("   2. Adaptive Strategy");
            System.out.print("Enter 1 or 2: ");
            
            int choice = scanner.nextInt();
            TrafficStrategy strategy;
            
            if(choice == 1) {
                strategy = new FixedTimeStrategy();
                System.out.println("\n Selected: FIXED TIME STRATEGY");
            } else {
                strategy = new AdaptiveStrategy();
                System.out.println("\n Selected: ADAPTIVE STRATEGY");
            }
            
            // Create vehicles
            System.out.println("\n Creating vehicles...");
            ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
            vehicles.add(new Car("CAR001"));
            vehicles.add(new Car("CAR002"));
            vehicles.add(new Truck("TRK001"));
            vehicles.add(new EmergencyVehicle("AMB001"));
            
            System.out.println("   Created " + vehicles.size() + " vehicles:");
            for(int i = 0; i < vehicles.size(); i++) {
                Vehicle v = vehicles.get(i);
                System.out.println("      - " + v.getId() + " (" + v.getType() + ")");
            }
            
            // Create traffic light
            TrafficLight trafficLight = new TrafficLight("Signal1", road);
            trafficLight.setStrategy(strategy);
            
            // Start simulation
            System.out.println("\n Starting simulation for 15 seconds...\n");
            
            SimulationEngine engine = new SimulationEngine(trafficLight, vehicles, road);
            engine.start();
            
            try {
                engine.join();
            } catch(InterruptedException e) {
                System.out.println("Simulation interrupted!");
            }
            
            // Show results
            System.out.println("\n SIMULATION RESULTS:");
            System.out.println(engine.getStatistics());
            
            System.out.println("\n========================================");
            System.out.println("   SIMULATION COMPLETED!");
            System.out.println("========================================");
            
        } catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}