package br.com.fiap.Plusoft.chat;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

@Service
public class ChatMessageSender {

    private final SimpMessagingTemplate messagingTemplate;
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public ChatMessageSender(RabbitTemplate rabbitTemplate, SimpMessagingTemplate messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

    public void sendMessage(String message) {
        rabbitTemplate.convertAndSend("chat-queue", message);
        messagingTemplate.convertAndSend("/topic/messages", message);
    }
}
