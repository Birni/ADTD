package com.adtd.web.Messaging;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;



@Component
public class Listener {


    private static final Logger LOGGER =
            LoggerFactory.getLogger(Listener.class);

    @JmsListener(destination = "testy.test")
    public void receive1(String message) {
        LOGGER.info("'subscriber1' received message='{}'", message);

    }

}

