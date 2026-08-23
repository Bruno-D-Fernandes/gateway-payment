package edu.merchantapi.messaging.producer;

import edu.merchantapi.config.rabbitmq.RabbitMQConfig;
import edu.merchantapi.messaging.eventsContract.PedidoCriadoEvent;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoEventProducer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public PedidoEventProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void publicarEventoCriado(PedidoCriadoEvent event){
        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCHANGE, "venda.criada", event);
    }


}
