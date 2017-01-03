package finantix.assignment.part5;

public abstract class Observer {
    protected String topic;
    protected Subject subject;

    public abstract void update();
}
