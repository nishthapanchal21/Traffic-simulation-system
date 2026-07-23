public abstract class Vehicle {
    
    protected String id;
    protected double speed;
    protected double maxSpeed;
    protected boolean isMoving;
    protected int waitingTime;
    
    public Vehicle(String id, double maxSpeed) {
        this.id = id;
        this.maxSpeed = maxSpeed;
        this.speed = 0;
        this.isMoving = false;
        this.waitingTime = 0;
    }
    
    public String getId() {
        return id;
    }
    
    public double getSpeed() {
        return speed;
    }
    
    public void increaseSpeed() {
        if(speed + 5 <= maxSpeed) {
            speed = speed + 5;
            isMoving = true;
        }
    }
    
    public void decreaseSpeed() {
        if(speed - 5 >= 0) {
            speed = speed - 5;
        }
        if(speed == 0) {
            isMoving = false;
        }
    }
    
    public void stop() {
        speed = 0;
        isMoving = false;
    }
    
    public void increaseWaitingTime() {
        waitingTime++;
    }
    
    public int getWaitingTime() {
        return waitingTime;
    }
    
    public void resetWaitingTime() {
        waitingTime = 0;
    }
    
    public abstract String getType();
}