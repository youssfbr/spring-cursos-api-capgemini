package com.github.youssfbr.cursosapi.entities;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_curso")
@EqualsAndHashCode(of = "id")
public class Curso {

    @Id
    @Column(name = "idCurso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeCurso", length = 30, nullable = false)
    private String name;

    @Column(name = "valorCurso")
    private BigDecimal price;
}
