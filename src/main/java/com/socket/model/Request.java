package com.socket.model;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 * Created by khayapro on 2016/04/11
 */
@XmlRootElement(name = "request")
@XmlAccessorType(XmlAccessType.PROPERTY)
@XmlType(propOrder ={"eventType", "event"})
public class Request implements Serializable {

    private EventType eventType;
    private Event event;

    /** default / no-args constructor for jaxb */
    public Request(){
        super();
    }

    /** overloaded constructor - without jaxb */
    public Request(final EventType eventType, final Event event){
        this.eventType = eventType;
        this.event = event;
    }


    @XmlElement(name = "EventType")
    public EventType getEventType() {
        return eventType;
    }

    @XmlElement(name = "event")
    public Event getEvent() {
        return event;
    }

    public void setEventType(EventType eventType) {
        this.eventType = eventType;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    @Override
    public String toString() {
        return "Request{" +
                "eventType=" + eventType +
                ", event=" + event +
                '}';
    }
}
