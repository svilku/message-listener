package org.design.listener.config;

import io.smallrye.config.ConfigMapping;

import java.util.List;
import java.util.Map;
import java.util.Optional;

//This call will have values mapped through a connection factory like ibm connfactory, app.prop values
@ConfigMapping(prefix = "upstreamname")
public interface UpstreamMqConfig {
    enum Region {
        APAC, EMEA, AMERICAS
    }

    MQ mq();
    List<Region> regions();
    Map<Region, Config> getRegionalConfig();

    interface MQ {
        String host();
        int port();
        Optional<String> userId();
        Optional<String> password();
        Optional<String> sslCipherSuite();
        Optional<Boolean> mqcsp();
        Optional<String> sslPeerName();
        Optional<Certificate> ssl();
    }

    interface Certificate {
        Optional<String> trustStore();
        Optional<String> trustStorePass();
        Optional<String> keyStore();
        Optional<String> keyStorePass();
        Optional<String> preferTls();
        Optional<String> tlsProtocol();
        Optional<String> ibmCipherMapping();
    }

    interface Config {
        Decryption decryption();
        Consumer consumer();
    }

    interface Decryption {
        Optional<String> name();
        Optional<String> key();
        Optional<String> algorithm();
        Optional<String> transform();
        Optional<String> initVector();
    }

    interface Consumer {
        String qManager();
        String channel();
        String q();
    }

}
