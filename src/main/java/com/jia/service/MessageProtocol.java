package com.jia.service;

/**
 * Created by jialianqing on 2017/5/19 0019.
 */
public class MessageProtocol {
    public String handleProtocolMessage(String messageText) {
        String responseText;
        if ("MyProtocolMessage".equalsIgnoreCase(messageText)) {
            responseText = "I recognize your protocol message";
        } else {
            responseText = "Unknown protocol message: " + messageText;
        }

        return responseText;
    }
}
