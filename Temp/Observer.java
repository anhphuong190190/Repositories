package com.finantix.epayment.config;

public abstract class Observer {
    protected String topic;
    protected Subject subject;

    public abstract void update();
}
