package com.socket.interfaces;

import com.socket.model.Request;

import javax.xml.bind.JAXBException;

/**
 * Created by khayapro on 2016/04/11
 */
public interface RequestHandler {

    /**
     * This method is responsible for sending a message to handler
     * @param message - message data object
     */
    void handleMessage(final Request message) throws JAXBException;
}
