package edu.merchantapi.messaging.eventsContract;

import edu.merchantapi.domain.entity.Produto;
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
    Produto produto;
    LocalDateTime createdAt;
}
