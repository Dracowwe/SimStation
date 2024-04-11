package PD;

import SimStation.*;
import mvc.*;

class Prisoner extends Agent {

    public Prisoner() {
        super();
        heading = Heading.random();
    }

    public void update() {
        heading = Heading.random();
        int steps = Utilities.rng.nextInt(10) + 1;
        move(steps);
    }

}


class PrisonerDilemmaFactory extends SimStationFactory {
    public Model makeModel() { return new PrisonerDilemmaSimulation(); }
    public String getTitle() { return "Prisoner's Dilemma Simulator";}
}

public class PrisonerDilemmaSimulation extends Simulation {

    public void populate() {
        for(int i = 0; i < 15; i++)
            addAgent(new Prisoner());
    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new PrisonerDilemmaFactory());
        panel.display();
    }

}
