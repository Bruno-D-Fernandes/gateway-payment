package edu.merchantapi.service;

import edu.merchantapi.domain.repository.ProdutoRepository;
import edu.merchantapi.dto.CompraQuantidadeDtoCONTRACT;
import edu.merchantapi.messaging.eventsContract.PedidoCriadoEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ProdutoService {

    private ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public void criarPedido(List<CompraQuantidadeDtoCONTRACT> compras){
        new PedidoCriadoEvent(null, compras, LocalDateTime.now());
    }

}
