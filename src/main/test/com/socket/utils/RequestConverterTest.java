package com.socket.utils;

import com.socket.model.Event;
import com.socket.model.EventType;
import com.socket.model.Request;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import static org.fest.assertions.Assertions.assertThat;

/**
 * Created by khayapro on 2016/04/11
 */
@RunWith(MockitoJUnitRunner.class)
public class RequestConverterTest {

    @Mock
    private JAXBContext context;
    @Mock
    private Marshaller marshaller;
    @InjectMocks
    private RequestConverter converter;

    private Request request;

    @Before
    public void init() throws JAXBException {
        final Event event = new Event();
        event.setDeviceId(1234L);
        event.setDeviceSerial("123458SER");
        event.setDeviceVersion("12345VER");
        event.setTransType("TransType");
        event.setUserPin(12345567L);
        request = new Request(EventType.Authentication, event);

    }


    @Test(expected = IllegalArgumentException.class)
    public void testConvertToXmlIllegalArg() throws Exception {
        converter.convertToXml(null);
    }

    @Test
    public void testContextToXml() throws JAXBException {
        final String xml = converter.convertToXml(request);
        System.out.println(xml);
        assertThat(xml).isNotEmpty();
    }
}