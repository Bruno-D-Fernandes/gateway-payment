package edu.stock.messaging.consumer;

import edu.stock.messaging.events.PedidoCriadoEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoCriadoConsumer {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public PedidoCriadoConsumer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @RabbitListener(queues = "estoque.queue")
    public void estoqueQueue(PedidoCriadoEvent event){



    }

}
