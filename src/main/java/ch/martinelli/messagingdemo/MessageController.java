package ch.martinelli.messagingdemo;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping(path = "messages")
public class MessageController {

    private final JmsTemplate jmsTemplate;

    public MessageController(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    @PostMapping
    public void sendMessage() {
        jmsTemplate.send(
                "HelloQueue1",
                session -> session.createTextMessage("Hello1 at " + LocalDateTime.now()));

        jmsTemplate.send(
                "HelloQueue2",
                session -> session.createTextMessage("Hello2 at " + LocalDateTime.now()));
    }
}
