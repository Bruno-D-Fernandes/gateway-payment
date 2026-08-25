package edu.merchantapi.controller;

import edu.merchantapi.dto.request.PostCompraDto;
import edu.merchantapi.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("produtos")
public class ProdutoController {

    private ProdutoService produtoService;

    @Autowired
    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @PostMapping("comprar")
    public ResponseEntity postCompra(@RequestBody PostCompraDto compraDto){
        produtoService.criarPedido(compraDto);

        return ResponseEntity.ok().build();
    }

//    public ResponseEntity criarCompra(@RequestBody List<CompraQuantidadeDtoCONTRACT> CompraDto){
//        produtoService.criarPedido(CompraDto);
//
//
//        return ResponseEntity.ok().build();
//    }

}
