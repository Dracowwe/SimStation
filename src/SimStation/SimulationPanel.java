package SimStation;
import mvc.*;

import javax.swing.*;
import java.awt.*;
import java.util.Iterator;

class GridPanel extends JPanel {
    private int rows;
    private int cols;

    public GridPanel(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int cellWidth = getWidth() / cols;
        int cellHeight = getHeight() / rows;

        // Draw grid lines
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                g.setColor(Color.GRAY);
                g.drawRect(col * cellWidth, row * cellHeight, cellWidth, cellHeight);
            }
        }
    }
}


public class SimulationPanel extends AppPanel {
    public SimulationPanel(AppFactory factory) {
        super(factory);
        //controlPanel = new JPanel();

        JButton button = new JButton("Start");
        controlPanel.add(button);
        button.addActionListener(this);
        button = new JButton("Suspend");
        controlPanel.add(button);
        button.addActionListener(this);
        button = new JButton("Resume");
        controlPanel.add(button);
        button.addActionListener(this);
        button = new JButton("Stop");
        controlPanel.add(button);
        button.addActionListener(this);
        button = new JButton("Stats");
        controlPanel.add(button);
        button.addActionListener(this);

        GridPanel gridPanel = new GridPanel(1000, 1000);
        view.add(gridPanel);
    }

    @Override
    public void setModel(Model m) {
        super.setModel(m); // calling AppPanel.setModel(m)
        Simulation s = (Simulation)m;
        Iterator<Agent> it = s.iterator();

    }

    public static void main(String[] args) {
        AppPanel panel = new SimulationPanel(new SimStationFactory());
        panel.display();
    }

}
