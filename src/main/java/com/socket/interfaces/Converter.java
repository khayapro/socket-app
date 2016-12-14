package com.socket.interfaces;

import com.socket.model.Request;

import javax.xml.bind.JAXBException;

/**
 * Created by khayapro on 2016/04/11
 */
public interface Converter {

    /**
     * Converts request into xml string and returned to client.
     * @param request - object to be converted
     * @return String
     */
    String convertToXml(final Request request) throws JAXBException;
}
