package edu.merchantapi.config.rabbitmq;

import edu.merchantapi.messaging.events.PedidoCriadoEvent;
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

    public static final String EXCHANGE = "item.exchange";

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

    // todo understand how it works
    @Bean
    public JacksonJsonMessageConverter jsonMessageConverter() {
        JacksonJsonMessageConverter converter = new JacksonJsonMessageConverter();

        DefaultClassMapper classMapper = new DefaultClassMapper();
        Map<String, Class<?>> idClassMapping = new HashMap<>();
        idClassMapping.put("PedidoCriadoEvent", PedidoCriadoEvent.class);
        classMapper.setIdClassMapping(idClassMapping);

        converter.setClassMapper(classMapper);
        return converter;
    }
}