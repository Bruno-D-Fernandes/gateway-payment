package edu.merchantapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sales_tb")
public class Venda {

    @Id
    @GeneratedValue(strategy =  GenerationType.UUID)
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "quantity")
    private Integer quantity;

    @Column(name = "rapend_at")
    private LocalDateTime rapendAt;

    @Column(name = "total_value")
    private BigDecimal totalValue;

    @JoinColumn(name = "id_produto")
    @ManyToOne
    private Produto product;
}
