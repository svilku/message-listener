package org.design.listener.msglisterner;

import io.quarkus.runtime.Shutdown;
import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;

public interface TextMessageListener {

    void consumesMessage(StartupEvent startupEvent);

    void onShutDown(ShutdownEvent shutdownEvent);
}
