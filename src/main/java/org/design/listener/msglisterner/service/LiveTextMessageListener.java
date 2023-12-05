package org.design.listener.msglisterner.service;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.jms.MessageListener;
import org.design.listener.msglisterner.AbstractTextMessageListener;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class LiveTextMessageListener extends AbstractTextMessageListener {

    @ConfigProperty(name = "live.queue")
    String queueName;

    @Inject
    Instance<LiveTextMessageConsumer> liveTextMessageConsumer;

    @Override
    protected String fetchQueue() {
        return queueName;
    }

    @Override
    protected MessageListener msgLister() {
        return liveTextMessageConsumer.get().consumeMessage();
    }
}
