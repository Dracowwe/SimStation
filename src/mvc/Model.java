package mvc;

public abstract class Model extends Publisher implements Subscriber {
    protected boolean unsavedChanges = false;
    protected String fileName = null;

    public void changed() {
        unsavedChanges = true;
        notifySubscribers();
    }

    public void setUnsavedChanges(boolean b) {
        unsavedChanges = b;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fName) {
        fileName = fName;
    }

    public void update() {
        // Implement update method if needed
    }
}
