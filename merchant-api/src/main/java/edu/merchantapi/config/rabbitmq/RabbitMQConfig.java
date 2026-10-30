package edu.merchantapi.config.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String EXCHANGE = "item.exchange";

    // =========================================================
    // CONFIGURAÇÃO DO CONVERSOR JSON
    // =========================================================

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, MessageConverter messageConverter) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(messageConverter);
        return template;
    }

    // =========================================================
    // EXCHANGES, FILAS E BINDINGS (Seu código original mantido)
    // =========================================================

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    @Bean
    public Queue estoqueQueue(){
        return new Queue("estoque.queue");
    }

    @Bean
    public Binding estoqueBinding(){
        return BindingBuilder.bind(estoqueQueue()).to(exchange()).with("venda.*");
    }

    @Bean
    public Queue merchantQueue(){
        return new Queue("merchant.queue");
    }

    @Bean
    public Binding merchantBinding(){
        return BindingBuilder.bind(merchantQueue()).to(exchange()).with("estoque.atualizado");
    }

    @Bean
    public Queue merchantUpdateEstoqueQueue(){
        return new Queue("merchant.estoque.update");
    }

    @Bean
    public Binding merchantUpdateEstoqueBinding(){
        return BindingBuilder.bind(merchantUpdateEstoqueQueue()).to(exchange()).with("estoque.reposicao");
    }

}