package edu.merchantapi.dto;

import edu.merchantapi.domain.entity.Produto;

import java.math.BigDecimal;

public record CompraQuantidadeDtoCONTRACT(ProdutoDto produto, int quantidade, BigDecimal total) {

    public CompraQuantidadeDtoCONTRACT(ProdutoDto produto, int quantidade) {
        this(produto, quantidade, produto.valorUnidade().multiply(BigDecimal.valueOf(quantidade)));
    }
}
