package com.zy.base.starters.init;

import org.springframework.context.ApplicationEvent;

public class ApplicationInitializingEvent extends ApplicationEvent {

    public ApplicationInitializingEvent(Object source) {
        super(source);
    }
}
