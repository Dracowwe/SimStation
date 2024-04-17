package Plague;

import SimStation.*;
import mvc.*;

class Host extends Agent {

    public Host() {
        super("Host");
        heading = Heading.random();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}


class PlagueFactory extends SimStationFactory {
    public Model makeModel() { return new PlagueSimulation(); }
    public String getTitle() { return "Plague Simulator";}
}

public class PlagueSimulation extends Simulation {
    public static int VIRULENCE = 50; // % chance of infection
    public static int RESISTANCE = 2; // % chance of resisting infection
    // etc.

    @Override
    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Host());
    }

    @Override
    public String[] getStats() {
        String[] stats = new String[3];
        //stats[0] = "# agents = " + Host.size();
        //stats[1] = "clock = " + clock;
        //stats[2] = "% infected = " + ;
        return stats;
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PlagueFactory());
        panel.display();
    }

}