package edu.merchantapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Venda {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @JoinColumn(name = "id_produto")
    @ManyToOne
    private Produto produto;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "rapend_at")
    private LocalDateTime rapendAt;

    @Column(name = "total")
    private BigDecimal total;

}
