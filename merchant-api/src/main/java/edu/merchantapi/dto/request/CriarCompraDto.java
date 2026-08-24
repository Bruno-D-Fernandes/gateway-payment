package edu.merchantapi.dto.request;

import edu.merchantapi.dto.ProdutoDto;

public record CriarCompraDto (ProdutoDto produto, int Quantidade){
}
