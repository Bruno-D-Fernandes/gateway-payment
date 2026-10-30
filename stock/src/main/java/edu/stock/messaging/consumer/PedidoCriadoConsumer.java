package edu.stock.messaging.consumer;

import edu.stock.messaging.events.PedidoCriadoEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PedidoCriadoConsumer {

    // Adicione o containerFactory apontando para o Bean que criamos!
    @RabbitListener(
            queues = "estoque.queue",
            containerFactory = "rabbitListenerContainerFactory"
    )
    public void estoqueQueue(PedidoCriadoEvent event){
        System.out.println("Recebido com sucesso em JSON: " + event);
    }
}
