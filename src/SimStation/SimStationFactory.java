package SimStation;

import mvc.*;

public class SimStationFactory implements AppFactory {
    @Override
    public Model makeModel() {
        return new Simulation();
    }

    @Override
    public View makeView(Model model) {
        return new SimulationView(model);
    }

    @Override
    public String[] getEditCommands() {
        return new String[] {"Start", "Suspend", "Resume", "Stop", "Stats"};
    }

    @Override
    public Command makeEditCommand(Model model, String type, Object source) {
        switch(type) {
            case "Start": return new StartCommand(model);
            case "Suspend": return new SuspendCommand(model);
            case "Resume": return new ResumeCommand(model);
            case "Stop": return new StopCommand(model);
            case "Stats": return new StatsCommand(model);
            default: return null;
        }
    }

    @Override
    public String getTitle() {
        return "SimStation";
    }

    @Override
    public String[] getHelp() {
        return new String[]{
                "Start: starts the simulation",
                "Suspend: suspends the simulation",
                "Resume: resumes the simulation",
                "Stop: stops the simulation",
                "Stats: show stats of the simulation"
        };
    }

    @Override
    public String about() {
        return "SimStation 1.0, Copyright 2024 by Cyberdellic Designz";
    }
}