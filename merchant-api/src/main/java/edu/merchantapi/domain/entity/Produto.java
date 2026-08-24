package edu.merchantapi.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@AllArgsConstructor
@Getter
@Setter
@Table(name = "product_tb")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "uuid")
    private String uuid;

    @Column(name = "product_name")
    private String name;

    @Column(name = "product_name")
    private BigDecimal valorUnidade;

    // Não está no escopo do projeto
//    private List<String> uriImagens;


}
