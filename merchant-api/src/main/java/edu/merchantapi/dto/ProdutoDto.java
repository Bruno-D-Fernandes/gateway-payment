package edu.contracts.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public record ProdutoDto(String name, BigDecimal valor) implements Serializable {
}
