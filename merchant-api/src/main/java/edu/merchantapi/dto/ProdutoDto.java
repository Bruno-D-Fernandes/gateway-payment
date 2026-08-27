package edu.merchantapi.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public record ProdutoDto(String name, BigDecimal valorUnidade) implements Serializable {
}
