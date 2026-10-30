package edu.merchantapi.messaging.events;

import edu.merchantapi.dto.ProdutoDto;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PedidoCriadoEvent implements Serializable {
    String idVenda;
    ProdutoDto produto;
    LocalDateTime createdAt;
}
