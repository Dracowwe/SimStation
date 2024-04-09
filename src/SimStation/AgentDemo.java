package SimStation;

public class AgentDemo {
    public static void main(String[] args) {
        Manager manager = new Manager();
        manager.add(new PiApproximator());
        manager.add(new PrimeGenerator());
        manager.add(new Divider(113));
        manager.controlLoop();
    }
}
