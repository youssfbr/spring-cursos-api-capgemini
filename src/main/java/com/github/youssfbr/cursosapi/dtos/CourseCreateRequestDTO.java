package com.github.youssfbr.cursosapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CourseCreateRequestDTO(

        @JsonProperty("nomeCurso")
        String name ,

        @JsonProperty("valorCurso")
        String price) {
}

