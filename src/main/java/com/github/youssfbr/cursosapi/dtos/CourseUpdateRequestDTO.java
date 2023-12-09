package com.github.youssfbr.cursosapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CourseUpdateRequestDTO(
        @JsonProperty("idCurso")
        Long id ,
        @JsonProperty("nomeCurso")
        String name ,
        @JsonProperty("valorCurso")
        String price) {
}

