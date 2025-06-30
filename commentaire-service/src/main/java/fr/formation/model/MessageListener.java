package fr.formation.model;

// MessageListener.java
import fr.formation.config.RabbitMQConfig;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class MessageListener {
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(String message) {
        System.out.println("Message reçu : " + message);
    }
}