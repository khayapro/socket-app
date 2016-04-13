package com.socket.controllers;

import com.socket.interfaces.RequestHandler;
import com.socket.model.Event;
import com.socket.model.EventType;
import com.socket.model.Request;
import com.socket.utils.FacesMessageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.inject.Model;
import javax.inject.Inject;
import javax.inject.Named;
import javax.xml.bind.JAXBException;

/**
 * Created by khayapro on 2016/04/11
 */
@Model
@Named(value = "controller")
public class RequestController {

    private Logger log = LoggerFactory.getLogger(RequestController.class);
    @Inject
    private Event event;
    @Inject
    private RequestHandler handler;
    @Inject
    private FacesMessageFactory messageFactory;

    /**
     * Handling request from the ui - form
     */
    public void addRequest(){
        final Request request = new Request(EventType.Authentication, event);
        try {
            handler.handleMessage(request);
            messageFactory.showSuccessMessage("Submitted successfully.");
        } catch (JAXBException e) {
           log.error("Failed to add request, ", e);
            messageFactory.showErrorMessage("Failed to add request");
        }
    }

    public Event getEvent() {
        return event;
    }
}
