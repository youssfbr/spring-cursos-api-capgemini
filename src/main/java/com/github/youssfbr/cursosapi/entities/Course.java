package com.github.youssfbr.cursosapi.entities;

import com.github.youssfbr.cursosapi.dtos.CourseCreateRequestDTO;
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
public class Course {

    @Id
    @Column(name = "idCurso")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nomeCurso", length = 30, nullable = false)
    private String name;

    @Column(name = "valorCurso", precision = 12, scale = 2)
    private BigDecimal price;

    public Course(CourseCreateRequestDTO courseCreateRequestDTO) {
        this.name = courseCreateRequestDTO.name();
        this.price = new BigDecimal(courseCreateRequestDTO.price());
    }
}
