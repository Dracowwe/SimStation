package SimStation;

import mvc.*;
import java.awt.*;

public abstract class Agent implements Runnable {

    protected String name;
    protected Thread myThread;
    protected Heading heading;
    //protected Manager manager;
    private boolean suspended, stopped;
    public int xc, yc;
    protected Simulation world;
    private Point oldPoint;

    public Agent(String name) {
        this.name = name;
        suspended = false;
        stopped = false;
        myThread = null;
    }

    //public void setManager(Manager m) { manager = m; }
    public String getName() { return name; }
    public synchronized String toString() {
        String result = name;
        if (stopped) result += " (stopped)";
        else if (suspended) result += " (suspended)";
        else result += " (running)";
        return result;
    }
    // thread stuff:
    public synchronized void stop() {
        stopped = true;
        onExit();
    }
    public synchronized boolean isStopped() { return stopped; }

    public synchronized void suspend() {
        suspended = true;
        onInterrupted();
    }
    public synchronized boolean isSuspended() { return suspended;  }

    public synchronized void resume() {
        suspended = false;
        notify();
        onStart();
    }
    // wait for me to die:
    public synchronized void join() {
        try {
            if (myThread != null) myThread.join();
        } catch(InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
    // wait for notification if I'm not stopped and I am suspended
    private synchronized void checkSuspended() {
        try {
            while(!stopped && suspended) {
                wait();
                suspended = false;
            }
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }


    public void run() {
        myThread = Thread.currentThread();
        checkSuspended();
        onStart();
        while (!isStopped()) {
            try {
                update();
                Thread.sleep(1000);
                checkSuspended();
            } catch(InterruptedException e) {
                System.out.println(e.getMessage());
            }
        }
        onExit();
    }

    public abstract void update();

    public void move(int steps) {
        /*
        for (int i = 0; i < steps; i++) {
            oldPoint = new Point(xc, yc);


            xc += heading.getXOffset();
            yc += heading.getYOffset();
            world.changed(name, oldPoint, new Point(xc, yc)); // Call world.changed with old and new points
        }

         */
    }

    protected void onStart() {}
    protected void onInterrupted() {}
    protected void onExit() {}


    public Heading getHeading() { return heading; }
}
