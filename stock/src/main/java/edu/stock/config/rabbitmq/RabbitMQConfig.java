package edu.stock.config.rabbitmq;

import edu.stock.messaging.events.PedidoCriadoEvent;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.support.converter.DefaultClassMapper;
import org.springframework.amqp.support.converter.JacksonJsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class RabbitMQConfig {

    private static final String EXCHANGE = "item.exchange";

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange(EXCHANGE);
    }

    // here i will receive the messages

    @Bean
    public Queue estoqueQueue(){
        return new Queue("estoque.queue");
    }

    @Bean
    public Binding estoqueBinding(){
        return BindingBuilder.bind(estoqueQueue()).to(exchange()).with("venda.*");
    }


    // From here to merchant-api
    @Bean
    public Queue merchantQueue(){
        return new Queue("merchant.queue");
    }

    @Bean
    public Binding merchantBinding(){
        return BindingBuilder.bind(merchantQueue()).to(exchange()).with("estoque.atualizado");
    }

    // From here to merchant-api
    @Bean
    public Queue merchantUpdateEstoqueQueue(){
        return new Queue("merchant.estoque.update");
    }

    @Bean
    public Binding merchantUpdateEstoqueBinding(){
        return BindingBuilder.bind(merchantUpdateEstoqueQueue()).to(exchange()).with("estoque.reposicao");
    }




}
