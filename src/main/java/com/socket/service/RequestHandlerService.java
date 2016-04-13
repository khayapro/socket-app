package com.socket.service;

import com.socket.interfaces.Converter;
import com.socket.interfaces.ISocket;
import com.socket.interfaces.RequestHandler;
import com.socket.model.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.bind.JAXBException;

/**
 * Created by khayapro on 2016/04/11
 */
@Stateless
public class RequestHandlerService implements RequestHandler {

    private Logger log = LoggerFactory.getLogger(RequestHandlerService.class);
    @Inject
    private Converter converter;
    @Inject
    private ISocket socket;

    @Override
    public void handleMessage(final Request message) throws JAXBException {
        if(message == null)
            throw new IllegalArgumentException("Request message cannot be null");

        final String xml = converter.convertToXml(message);
        socket.sendMessage(xml);
        log.info("Sent request : " + message + "\n,  xml : " + xml);
    }
}
