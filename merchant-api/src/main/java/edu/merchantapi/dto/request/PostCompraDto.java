package edu.merchantapi.dto.request;

import edu.merchantapi.dto.ProdutoDto;

public record PostCompraDto(ProdutoDto produto, int quantidade){
}
