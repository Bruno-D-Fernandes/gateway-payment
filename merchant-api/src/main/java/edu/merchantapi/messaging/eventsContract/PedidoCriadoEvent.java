package edu.merchantapi.messaging.eventsContract;

import edu.merchantapi.dto.CompraQuantidadeDtoCONTRACT;
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
    List<CompraQuantidadeDtoCONTRACT> itens;
    LocalDateTime createdAt;
}
