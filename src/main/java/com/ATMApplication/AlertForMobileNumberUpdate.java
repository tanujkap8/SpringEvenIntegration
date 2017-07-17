package com.ATMApplication;

import com.events.CustomEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;

public class AlertForMobileNumberUpdate implements ApplicationEventPublisherAware {

    ApplicationEventPublisher applicationEventPublisher;

    void alertUpdate() {
        CustomEvent customEvent = new CustomEvent(this);
        applicationEventPublisher.publishEvent(customEvent);
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    public String toString(){
        return "Mobile Updated";
    }
}
