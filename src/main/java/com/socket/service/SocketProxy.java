package com.socket.service;

import com.socket.interfaces.ISocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Asynchronous;
import javax.ejb.Singleton;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Single instance of this class for handling everything message sent
 * and responses. This class is thread save and can handles concurrency.
 * Created by khayapro on 2016/04/11
 */
@Singleton
public class SocketProxy implements ISocket {

    private Logger log = LoggerFactory.getLogger(SocketProxy.class);
    private static final String SERVER_HOST = "196.37.22.179";
    private static final int PORT = 9011;

    @Override

    @Asynchronous
    public void sendMessage(final String xmlMessage) {
        if(xmlMessage == null)
            throw new IllegalArgumentException("cannot send null xml message");

        //Opening socket connection to the server, declare as follows to close connection implicitly
        try (final Socket socket = new Socket(SERVER_HOST, PORT);
             final PrintWriter pw = new PrintWriter(socket.getOutputStream(), true)){

            //writing xml into the open stream
            pw.write(xmlMessage);
            displayResponse(socket);
        } catch (IOException e) {
            log.error("Exception occur on server socket connection : ", e);
        }
    }


    @Asynchronous
    public void displayResponse(final Socket socket) {
        if(socket == null)
            throw new IllegalArgumentException("Socket connection is null");

        //getting inputStream and wrapping it into a buffered with more & "friendly" api
        try(final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            socket.setSoTimeout(10000); //timeout if taking long to read

            //Reading response line by line
            String response;
            while ((response = reader.readLine()) != null) {
                log.info("Received server response : " + response);
            }
        } catch (IOException e) {
            log.error("Failed to read response from server : ", e);
        }
    }
}
