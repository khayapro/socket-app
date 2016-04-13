package com.socket.utils;

import com.socket.interfaces.Converter;
import com.socket.model.Request;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;

/**
 * Created by khayapro on 2016/04/11
 */
public class RequestConverter implements Converter {

    @Override
    public String convertToXml(final Request request) throws JAXBException {
        if(request == null)
            throw new IllegalArgumentException("Cannot convert a null request");

        return convert(request);
    }

    private String convert(final Request request) throws JAXBException {
        final JAXBContext context = JAXBContext.newInstance(Request.class); //indicating class used in context.
        final Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        final StringWriter sw = new StringWriter();
        marshaller.marshal(request, sw);
        return sw.toString();
    }
}
