package edu.merchantapi.messaging.consumer;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class EstoqueListener {

    @RabbitListener(queues = "merchant.estoque.update")
    public void EstoqueUpdateListener(){

    }

    @RabbitListener(queues = "merchant.queue")
    public void ItemListener(){

    }


}



