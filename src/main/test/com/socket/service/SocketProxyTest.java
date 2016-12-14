package com.socket.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

/**
 * Created by khayapro on 2016/04/12
 */
@RunWith(MockitoJUnitRunner.class)
public class SocketProxyTest {

    @InjectMocks
    private SocketProxy socketProxy;

    @Test
    public void testSendMessage() throws Exception {
        socketProxy.sendMessage("xml message");
        //To complete
    }

    @Test
    public void testDisplayResponse() throws Exception {
        //To complete
    }
}