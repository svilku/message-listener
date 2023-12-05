package org.design.listener.msglisterner.service;

import jakarta.enterprise.context.Dependent;
import jakarta.jms.JMSException;
import jakarta.jms.Message;
import lombok.extern.slf4j.Slf4j;

@Dependent
@Slf4j
public class LiveTextMessageConsumer extends TextMessageConsumer {
    @Override
    protected void processMessage(Message message) throws JMSException {
        log.info("Live Message : [{}] received with id: {}", message.getBody(String.class), message.getJMSMessageID());
        message.acknowledge();
    }
}
