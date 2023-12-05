package org.design.listener.msglisterner.service;

import jakarta.jms.JMSException;
import jakarta.jms.Message;
import jakarta.jms.MessageListener;

import java.util.Objects;

public abstract class TextMessageConsumer {

    public MessageListener consumeMessage() {

        return (Message message) -> {
            try {
                if (Objects.isNull(message)) {
                    System.out.println("null message");
                    message.acknowledge();
                }
                processMessage(message);

            } catch (JMSException e) {
                e.printStackTrace();
            }
        };
    }

    protected abstract void processMessage(Message message) throws JMSException;
}
