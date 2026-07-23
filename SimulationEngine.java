import java.util.ArrayList;
import java.util.Iterator;

public class SimulationEngine extends Thread {
    
    private TrafficLight trafficLight;
    private ArrayList<Vehicle> vehicles;
    private Road road;
    private boolean isRunning;
    private int totalVehiclesPassed;
    private int totalWaitTime;
    private int time;
    
    public SimulationEngine(TrafficLight trafficLight, ArrayList<Vehicle> vehicles, Road road) {
        this.trafficLight = trafficLight;
        this.vehicles = vehicles;
        this.road = road;
        this.isRunning = true;
        this.totalVehiclesPassed = 0;
        this.totalWaitTime = 0;
        this.time = 0;
    }
    
    @Override
    public void run() {
        System.out.println("     SIMULATION STARTED!");
        System.out.println("   ================================");
        
        while(isRunning && time < 15) {
            
            try {
                time++;
                
                checkAndPrioritizeEmergency();
                
                trafficLight.update();
                
                showStatus();
                processVehicles();
                
                if(time % 3 == 0) {
                    addNewVehicle();
                }
                
                Thread.sleep(1000);
                
            } catch(InterruptedException e) {
                System.out.println("Simulation stopped!");
                break;
            }
        }
        
        isRunning = false;
        System.out.println("\n   ================================");
        System.out.println("    SIMULATION FINISHED!");
        showResults();
    }
    
    private void checkAndPrioritizeEmergency() {
        boolean hasEmergencyVehicle = false;
        EmergencyVehicle emergencyVehicle = null;
        
        for(Vehicle v : vehicles) {
            if(v instanceof EmergencyVehicle) {
                hasEmergencyVehicle = true;
                emergencyVehicle = (EmergencyVehicle) v;
                break;
            }
        }
        
        if(hasEmergencyVehicle) {
            System.out.println("\n  EMERGENCY VEHICLE DETECTED! ");
            System.out.println(" " + emergencyVehicle.getId() + " needs to pass!");
            System.out.println(" FORCING GREEN LIGHT FOR EMERGENCY!");
            
            trafficLight.forceGreen();
        }
    }
    
    private void showStatus() {
        System.out.println("\n   Time: " + time + "/15 seconds");
        System.out.println("   Light: " + trafficLight.getCurrentColor());
        System.out.println("   Waiting: " + vehicles.size() + " vehicles");
        System.out.println("   Passed: " + totalVehiclesPassed + " vehicles");
        
        for(Vehicle v : vehicles) {
            if(v instanceof EmergencyVehicle) {
                System.out.println(" EMERGENCY VEHICLE WAITING: " + v.getId());
                break;
            }
        }
    }
    
    private void processVehicles() {
        ArrayList<EmergencyVehicle> emergencyVehicles = new ArrayList<EmergencyVehicle>();
        for(Vehicle v : vehicles) {
            if(v instanceof EmergencyVehicle) {
                emergencyVehicles.add((EmergencyVehicle) v);
            }
        }
        
        for(EmergencyVehicle ev : emergencyVehicles) {
            if(trafficLight.isGreen()) {
                totalWaitTime = totalWaitTime + ev.getWaitingTime();
                totalVehiclesPassed++;
                System.out.println("EMERGENCY " + ev.getId() + " PASSED FIRST! (Waited " + ev.getWaitingTime() + " sec)");
                vehicles.remove(ev);
                road.removeVehicle();
            }
        }
        
        Iterator<Vehicle> iterator = vehicles.iterator();
        while(iterator.hasNext()) {
            Vehicle v = iterator.next();
            
            if(trafficLight.isGreen()) {
                if(v.getWaitingTime() > 0) {
                    totalWaitTime = totalWaitTime + v.getWaitingTime();
                    totalVehiclesPassed++;
                    System.out.println(" " + v.getId() + " (" + v.getType() + ") passed! (Waited " + v.getWaitingTime() + " sec)");
                    iterator.remove();
                    road.removeVehicle();
                } else {
                    v.increaseWaitingTime();
                }
            } 
            else {
                v.increaseWaitingTime();
            }
        }
        
        road.setVehicleCount(vehicles.size());
    }
    
    private void addNewVehicle() {
        int random = (int)(Math.random() * 10);
        String id = "V" + (totalVehiclesPassed + vehicles.size() + 1);
        
        if(random < 6) { 
            vehicles.add(new Car(id));
            System.out.println(" New Car arrived: " + id);
        } else if(random < 8) { 
            vehicles.add(new Truck(id));
            System.out.println(" New Truck arrived: " + id);
        } else { 
            vehicles.add(new EmergencyVehicle(id));
            System.out.println("   NEW EMERGENCY VEHICLE ARRIVED: " + id);
            System.out.println(" THIS VEHICLE WILL GET PRIORITY!");
        }
        
        road.addVehicle();
    }
    
    private void showResults() {
        System.out.println("\n RESULTS:");
        System.out.println("   Vehicles Passed: " + totalVehiclesPassed);
        System.out.println("   Total Wait Time: " + totalWaitTime + " seconds");
        
        if(totalVehiclesPassed > 0) {
            int avgWait = totalWaitTime / totalVehiclesPassed;
            System.out.println("   Average Wait Time: " + avgWait + " seconds");
            
            if(avgWait < 3) {
                System.out.println(" EXCELLENT! Low waiting time!");
            } else if(avgWait < 7) {
                System.out.println(" GOOD! Reasonable traffic flow!");
            } else {
                System.out.println(" CONGESTION! High waiting time!");
            }
        }
    }
    
    public String getStatistics() {
        String stats = "=== TRAFFIC REPORT ===\n";
        stats = stats + "Strategy: " + trafficLight.getStrategyName() + "\n";
        stats = stats + "Duration: " + time + "/15 seconds\n";
        stats = stats + "Vehicles Passed: " + totalVehiclesPassed + "\n";
        stats = stats + "Total Wait Time: " + totalWaitTime + " seconds\n";
        if(totalVehiclesPassed > 0) {
            stats = stats + "Average Wait: " + (totalWaitTime / totalVehiclesPassed) + " seconds\n";
        }
        stats = stats + "=====================";
        return stats;
    }
}