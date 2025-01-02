package com.zy.base.starter.init;

import org.springframework.context.ApplicationEvent;

public class ApplicationInitializingEvent extends ApplicationEvent {

    public ApplicationInitializingEvent(Object source) {
        super(source);
    }
}
