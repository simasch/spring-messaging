package ch.martinelli.messagingdemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class HelloMessage2Receiver {

    private final static Logger LOGGER = LoggerFactory.getLogger(HelloMessage2Receiver.class);

    @JmsListener(destination = "HelloQueue2")
    public void receiveMessage(String message) {
        LOGGER.info(message);
    }
}
