package edu.contracts.dto;

import java.math.BigDecimal;

public record CompraQuantidadeDtoCONTRACT(ProdutoDto produto, int quantidade, BigDecimal total) {

    public CompraQuantidadeDtoCONTRACT(ProdutoDto produto, int quantidade) {
        this(produto, quantidade, produto.valor().multiply(BigDecimal.valueOf(quantidade)));
    }
}
