package edu.merchantapi.messaging.events;

import edu.merchantapi.dto.ProdutoDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
public class PedidoCriadoEvent implements Serializable {
    String idVenda;
    ProdutoDto produto;
    LocalDateTime createdAt;
}
