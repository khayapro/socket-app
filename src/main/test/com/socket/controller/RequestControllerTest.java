package com.socket.controller;

import com.socket.controllers.RequestController;
import com.socket.interfaces.RequestHandler;
import com.socket.model.Request;
import com.socket.utils.FacesMessageFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

/**
 * Created by khayapro on 2016/04/11
 */
@RunWith(MockitoJUnitRunner.class)
public class RequestControllerTest {

    @InjectMocks
    private RequestController controller;

    @Mock
    private Request request;
    @Mock
    private RequestHandler handler;
    @Mock
    private FacesMessageFactory messageFactory;

    @Test
    public void testAddRequest() throws Exception {
        controller.addRequest();
        verify(handler, times(1)).handleMessage(request);
    }

    @Test(expected = Exception.class)
    public void testAddRequestException() throws Exception {
        controller.addRequest();
        verify(handler, times(1)).handleMessage(request);
    }

}