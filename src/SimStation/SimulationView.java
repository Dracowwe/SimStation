package SimStation;

import mvc.*;
import javax.swing.*;
import java.util.*;


public class SimulationView extends View {
    JList<Agent> agents;

    public SimulationView(Model model) {
        super(model);
        Simulation sim = (Simulation) model;
        Iterator<Agent> it = sim.iterator();
        while(it.hasNext()) {
            Thread t = new Thread(it.next());
            t.start(); // will call Agent.run
        }
    }

    @Override
    public void update() {
        super.update();
        Simulation sim = (Simulation) model;
        Iterator<Agent> it = ((Simulation) model).iterator();
        while(it.hasNext()) {
            Thread t = new Thread(it.next());
            t.start();
        }
        repaint();
    }
}

//add propertyChanged method that calls repaint(x, y, h, w) where (x, y) is the upper corner of a rectangle of height h and width w that contains oldPoint and newPoint
