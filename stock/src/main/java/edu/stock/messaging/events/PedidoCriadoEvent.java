package edu.stock.messaging.events;

import edu.stock.dto.ProdutoDto;
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
