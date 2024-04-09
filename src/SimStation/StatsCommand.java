package SimStation;

import mvc.*;

public class StatsCommand extends Command {
    Model model;
    public StatsCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Simulation sim = (Simulation)model;
        sim.stats();
    }
}