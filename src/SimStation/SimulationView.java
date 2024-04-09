package SimStation;

import mvc.*;
import javax.swing.*;


public class SimulationView extends View {
    public SimulationView(Model model) {
        super(model);
        Simulation sim = (Simulation)model;

    }

    @Override
    public void update() {
        super.update();
        Simulation sim = (Simulation)model;

        repaint();
    }
}
