public class TrafficLight {
    
    private String id;
    private String currentColor;
    private Road road;
    private TrafficStrategy strategy;
    private int timeInCurrentState;
    private String strategyName;
    
    public TrafficLight(String id, Road road) {
        this.id = id;
        this.road = road;
        this.currentColor = "RED";
        this.timeInCurrentState = 0;
        this.strategyName = "Not Set";
    }
    
    public void setStrategy(TrafficStrategy strategy) {
        this.strategy = strategy;
        if(strategy instanceof FixedTimeStrategy) {
            this.strategyName = "FIXED TIME";
        } else if(strategy instanceof AdaptiveStrategy) {
            this.strategyName = "ADAPTIVE";
        }
    }
    
    public String getStrategyName() {
        return strategyName;
    }
    
    public void forceGreen() {
        if(!currentColor.equals("GREEN")) {
            currentColor = "GREEN";
            System.out.println("EMERGENCY OVERRIDE: Light forced to GREEN! ");
        }
    }
    
    public void update() {
        if(strategy != null) {
            String newColor = strategy.determineLightColor(this, road);
            
            if(!newColor.equals(currentColor)) {
                currentColor = newColor;
                timeInCurrentState = 0;
                
                if(currentColor.equals("GREEN")) {
                    System.out.println("\n LIGHT TURNED GREEN!");
                } else {
                    System.out.println("\n LIGHT TURNED RED! ");
                }
            }
        }
        timeInCurrentState++;
    }
    
    public String getCurrentColor() {
        return currentColor;
    }
    
    public String getId() {
        return id;
    }
    
    public boolean isGreen() {
        return currentColor.equals("GREEN");
    }
    
    public boolean isRed() {
        return currentColor.equals("RED");
    }
}