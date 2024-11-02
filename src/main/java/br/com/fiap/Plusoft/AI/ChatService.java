package br.com.fiap.Plusoft.AI;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.MessageChatMemoryAdvisor;
import org.springframework.ai.chat.memory.InMemoryChatMemory;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    final ChatClient chatClient;
    final RabbitTemplate rabbitTemplate;

    public ChatService(ChatClient.Builder chatClientBuilder, RabbitTemplate rabbitTemplate) {
        this.chatClient = chatClientBuilder
                .defaultSystem("""
                        Você é um assistente virtual que prevê a probabilidade de um novo cliente se tornar cliente da Plusoft.
                        Você irá analisar os dados do cliente e fornecer uma chance de conversão em percentual.
                        Forneça uma resposta clara e objetiva.
                        """)
                .defaultAdvisors(
                        new MessageChatMemoryAdvisor(new InMemoryChatMemory())
                )
                .build();
        this.rabbitTemplate = rabbitTemplate;
    }

    public String predictCustomer(String customerData) {
        // Envia os dados do cliente para uma fila para processamento
        rabbitTemplate.convertAndSend("customerQueue", customerData);
        return "Os dados do cliente foram enviados para análise.";
    }

    // Método para receber mensagens da fila
    @RabbitListener(queues = "customerQueue")
    public void receiveCustomerData(String customerData) {
        String prediction = chatClient
                .prompt()
                .user("Analisando os dados do cliente: " + customerData + ". Qual a probabilidade de conversão?")
                .call()
                .content();

        System.out.println("Previsão: " + prediction);
    }
}