package com.finantix.epayment.config;

public class Subscribe extends Observer {

    public Subscribe(String topic, Subject subject) {
        this.topic = topic;
        this.subject = subject;
        subject.attach(this);
    }

    @Override
    public void update() {
        System.out.println(topic + ": Consuming message " + subject.getState());
    }

}
