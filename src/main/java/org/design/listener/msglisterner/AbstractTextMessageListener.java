package org.design.listener.msglisterner;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import jakarta.jms.*;

public abstract class AbstractTextMessageListener implements TextMessageListener {

    @Inject
    ConnectionFactory connectionFactory;

    JMSContext jmsContext;
    JMSConsumer jmsConsumer;

    @Override
    public void consumesMessage(@Observes StartupEvent startupEvent) {
        jmsContext = connectionFactory.createContext(JMSContext.AUTO_ACKNOWLEDGE);
        Destination destination = jmsContext.createQueue(fetchQueue());
        jmsConsumer = jmsContext.createConsumer(destination);
        jmsConsumer.setMessageListener(msgLister());
    }

    public void onShutDown(@Observes ShutdownEvent shutdownEvent) {
        jmsContext.close();
        jmsConsumer.close();
    }

    protected abstract String fetchQueue();

    protected abstract MessageListener msgLister();
}
