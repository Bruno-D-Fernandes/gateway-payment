package edu.merchantapi.service;

import edu.merchantapi.domain.entity.Venda;
import edu.merchantapi.domain.repository.ProdutoRepository;
import edu.merchantapi.domain.repository.VendaRepository;
import edu.merchantapi.dto.CompraQuantidadeDtoCONTRACT;
import edu.merchantapi.messaging.eventsContract.PedidoCriadoEvent;
import edu.merchantapi.messaging.producer.PedidoEventProducer;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;
    private final PedidoEventProducer pedidoEventProducer;
    private final VendaRepository vendaRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository, PedidoEventProducer pedidoEventProducer, VendaRepository vendaRepository) {
        this.produtoRepository = produtoRepository;
        this.pedidoEventProducer = pedidoEventProducer;
        this.vendaRepository = vendaRepository;
    }

    public void criarPedido(List<CompraQuantidadeDtoCONTRACT> compras){

//          Corrigir entidades banco de dados
//        Venda venda = new Venda(compras); // id ainda null aqui, se for @GeneratedValue
//        venda = vendaRepository.save(venda);

        PedidoCriadoEvent pedidoCriadoEvent = new PedidoCriadoEvent(null, compras, LocalDateTime.now());
        pedidoEventProducer.publicarEventoCriado(pedidoCriadoEvent);

    }

}
