package SimStation;

// divide state by 3 until 0 reached
class Divider extends Agent {
    private int state;
    public Divider(int init) {
        super("Divider");
        state = init;
    }
    public void update() {
        if (state == 0) stop();
        state = state / 3;
        manager.println("state = " + state);
    }
}

