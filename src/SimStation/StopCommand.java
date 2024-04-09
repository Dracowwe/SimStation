package SimStation;

import mvc.*;

public class StopCommand extends Command {
    Model model;
    public StopCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Simulation sim = (Simulation)model;
        sim.stop();
    }
}