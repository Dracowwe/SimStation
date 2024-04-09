package SimStation;

import mvc.*;

public class ResumeCommand extends Command  {
    Model model;
    public ResumeCommand(Model model) {
        super(model);
    }

    @Override
    public void execute() throws Exception {
        Simulation sim = (Simulation)model;
        //sim.resume();
    }
}
