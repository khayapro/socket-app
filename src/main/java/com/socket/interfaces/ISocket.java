package com.socket.interfaces;

import java.net.Socket;

/**
 * Created by khayapro on 2016/04/11
 */
public interface ISocket {

    /**
     * Sending message to socket to be processed.
     * @param xmlMessage - message to be processed
     */
    void sendMessage(final String xmlMessage);

    /**
     * Display any server response based on the open connection
     * @param socket - currently open socket connection
     */
    void displayResponse(final Socket socket);
}
