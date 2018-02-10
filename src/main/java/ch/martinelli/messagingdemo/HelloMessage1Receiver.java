package ch.martinelli.messagingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class HelloMessage1Receiver {

    private final static Logger LOGGER = LoggerFactory.getLogger(HelloMessage1Receiver.class);

    @JmsListener(destination = "HelloQueue1")
    public void receiveMessage(String message) {
        LOGGER.info(message);
    }
}
