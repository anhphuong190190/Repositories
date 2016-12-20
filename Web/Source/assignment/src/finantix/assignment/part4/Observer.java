package finantix.assignment.part4;

public abstract class Observer {
    protected String topic;
    protected Subject subject;

    public abstract void update();
}
