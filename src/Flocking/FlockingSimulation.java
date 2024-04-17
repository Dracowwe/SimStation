package Flocking;

import SimStation.*;
import mvc.*;

class Bird extends Agent {
    int speed = 0;

    public Bird() {
        super("Bird");
        heading = Heading.random();
        speed = Utilities.rng.nextInt(5) + 1;
    }

    public void update() {
        //Bird neighbor = world.getNeighbor(neighbor, 6); // test multiple different radius's
        //heading = neighbor.heading;
        //int steps = neighbor.speed;
        //move(steps);
    }

}


class FlockingFactory extends SimStationFactory {
    public Model makeModel() { return new FlockingSimulation(); }
    public String getTitle() { return "Flocking Simulator";}
}

public class FlockingSimulation extends Simulation {

    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Bird());
    }

    @Override
    public String[] getStats() {
        String[] stats = new String[5];
        //stats[0] = "birds @ speed 1 = " + Bird.speed;
        stats[1] = "birds @ speed 2 = " + 2;
        stats[2] = "birds @ speed 3 = " + 3;
        stats[3] = "birds @ speed 4 = " + 4;
        stats[4] = "birds @ speed 5 = " + 5;
        return stats;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new FlockingFactory());
        panel.display();
    }

}
