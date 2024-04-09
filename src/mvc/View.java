package mvc;

import javax.swing.*;

public class View extends JPanel implements Subscriber {
    protected Model model;

    public View(Model model) {
        this.model = model;
        model.subscribe(this); // Subscribe to the model
    }

    @Override
    public void update() {
        // Implement update method if needed
    }

    public void setModel(Model model) {
        this.model.unsubscribe(this); // Unsubscribe from the current model
        this.model = model;
        model.subscribe(this); // Subscribe to the new model
        // You may need to update the view based on the new model
    }
}
