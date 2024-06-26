package RandomWalk;

import mvc.*;
import SimStation.*;

class Drunk extends Agent {

    public Drunk() {
        super("Drunk");
        heading = Heading.random();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}


class RandomWalkFactory extends SimStationFactory {
    public Model makeModel() { return new RandomWalkSimulation(); }
    public String getTitle() { return "Random Walks Simulator";}
}

public class RandomWalkSimulation extends Simulation {

    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Drunk());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new RandomWalkFactory());
        panel.display();
    }

}
