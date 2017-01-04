package finantix.assignment.part5;

public abstract class Observer {
    protected String title;
    protected Publisher publisher;

    public abstract void updateState();
}
