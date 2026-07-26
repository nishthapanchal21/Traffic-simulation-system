# Smart Traffic Simulation System

A Java-based Smart Traffic Simulation System that demonstrates real-world traffic management using Object-Oriented Programming principles and the Strategy Design Pattern. The system simulates vehicles, traffic lights, emergency vehicle prioritization, and different traffic light control strategies.

---

## Features

- Simulates different types of vehicles
  - Car
  - Truck
  - Emergency Vehicle (Ambulance)

- Traffic Light Management
  - Fixed Time Strategy
  - Adaptive Strategy based on traffic density

- Emergency Vehicle Priority
  - Automatically detects emergency vehicles
  - Overrides traffic signal to GREEN
  - Allows emergency vehicles to pass first

- Road Management
  - Vehicle count tracking
  - Traffic density monitoring

- Real-time Simulation
  - 15-second traffic simulation
  - Random vehicle generation
  - Waiting time calculation
  - Performance statistics

---

# Project Structure

```
TrafficSimulation/
│
├── Main.java
├── SimulationEngine.java
├── Road.java
├── TrafficLight.java
├── TrafficStrategy.java
├── FixedTimeStrategy.java
├── AdaptiveStrategy.java
├── Vehicle.java
├── Car.java
├── Truck.java
├── EmergencyVehicle.java
└── TrafficException.java
```

---

# Technologies Used

- Java
- Object-Oriented Programming (OOP)
- Multithreading
- Strategy Design Pattern
- Collections (ArrayList)
- Exception Handling

---

# OOP Concepts Implemented

### ✔ Abstraction
- `Vehicle` is an abstract class.

### ✔ Inheritance
- `Car`
- `Truck`
- `EmergencyVehicle`
inherit from `Vehicle`.

### ✔ Polymorphism
- Method overriding using `getType()`.
- Different vehicle objects handled using the parent `Vehicle` reference.

### ✔ Encapsulation
- Private fields with controlled access through methods.

### ✔ Interface
- `TrafficStrategy` interface.
- Implemented by:
  - `FixedTimeStrategy`
  - `AdaptiveStrategy`

### ✔ Exception Handling
- Custom exception:
  - `TrafficException`

### ✔ Multithreading
- `SimulationEngine` extends `Thread` to run the traffic simulation independently.

---

# Traffic Light Strategies

## 1. Fixed Time Strategy

Traffic light changes every fixed interval regardless of traffic conditions.

Suitable for:
- Low traffic roads
- Simple intersections

---

## 2. Adaptive Strategy

Traffic light color is decided based on the number of vehicles waiting.

Benefits:
- Reduces congestion
- Improves traffic flow
- Dynamically adapts to traffic conditions

---

# Emergency Vehicle Handling

Whenever an emergency vehicle is detected:

- Emergency vehicle gets highest priority.
- Traffic light immediately switches to GREEN.
- Emergency vehicle passes before all other vehicles.
- Simulation continues normally afterward.

---

# Simulation Statistics

At the end of the simulation, the system displays:

- Selected Strategy
- Simulation Duration
- Vehicles Passed
- Total Waiting Time
- Average Waiting Time

---

# How to Run

### Compile

```bash
javac *.java
```

### Run

```bash
java Main
```

---

# Sample Output

```
========================================
TRAFFIC SIMULATION SYSTEM
========================================

Choose traffic light strategy:
1. Fixed Time Strategy
2. Adaptive Strategy

Selected: ADAPTIVE STRATEGY

Creating vehicles...

Simulation Started...

EMERGENCY VEHICLE DETECTED!

EMERGENCY OVERRIDE: Light forced to GREEN!

CAR001 passed!
TRK001 passed!
AMB001 passed first!

Simulation Finished!

Traffic Report
--------------
Strategy: ADAPTIVE
Vehicles Passed: 8
Average Wait Time: 2 seconds
```

---

# Learning Outcomes

This project demonstrates:

- Object-Oriented Programming
- Strategy Design Pattern
- Multithreading in Java
- Collections Framework
- Exception Handling
- Traffic simulation logic
- Real-time event handling

---

# Future Improvements

- GUI using JavaFX or Swing
- Multiple roads and intersections
- Vehicle pathfinding
- Traffic congestion visualization
- Database integration
- AI-based traffic prediction
- Real-time sensor simulation
- Performance analytics dashboard

---

# Author

**Nishtha Panchal**

B.Tech Computer Science Engineering

---

