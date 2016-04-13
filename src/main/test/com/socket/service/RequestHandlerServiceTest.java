package com.socket.service;

import com.socket.interfaces.Converter;
import com.socket.interfaces.ISocket;
import com.socket.model.Event;
import com.socket.model.EventType;
import com.socket.model.Request;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.xml.bind.JAXBException;

import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by khayapro on 2016/04/11
 */
@RunWith(MockitoJUnitRunner.class)
public class RequestHandlerServiceTest {

    @InjectMocks
    private RequestHandlerService service;
    @Mock
    private Converter converter;
    @Mock
    private ISocket socket;

    private Request request;

    @Before
    public void init(){
        final Event event = new Event();
        event.setDeviceId(1234L);
        event.setDeviceSerial("123458SER");
        event.setDeviceVersion("12345VER");
        event.setTransType("TransType");
        event.setUserPin(12345567L);
        request = new Request(EventType.Authentication, event);
    }


    @Test
    public void testHandleMessage() throws Exception {
        service.handleMessage(request);
        verify(converter, times(1)).convertToXml(request);
        verify(socket, times(1)).sendMessage(anyString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHandleMessageIllegalArgs() throws JAXBException {
        service.handleMessage(null);
    }












}