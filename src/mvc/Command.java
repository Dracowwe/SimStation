package mvc;

public abstract class Command {
    protected Model model; // Change access modifier to protected

    public Command(Model model) {
        this.model = model;
    }

    public abstract void execute() throws Exception;
}
