package edu.merchantapi.messaging.eventsContract;

import edu.merchantapi.domain.entity.Produto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class PedidoCriadoEvent implements Serializable {
    String idVenda;
    List<Produto> itens;
    LocalDateTime createdAt;
}
