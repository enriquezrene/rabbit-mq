package com.enriquezrene.rabbit.mq.consumer;

/**
 * Created by rene on 31/10/16.
 */
public class Receiver {


    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
    }

}
