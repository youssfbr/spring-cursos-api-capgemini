package com.github.youssfbr.cursosapi.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.github.youssfbr.cursosapi.entities.Course;

public record CourseResponseDTO(
        @JsonProperty("idCurso")
        String id ,

        @JsonProperty("nomeCurso")
        String name ,

        @JsonProperty("valorCurso")
        String price) {

    public CourseResponseDTO(Course entity) {
        this(
                entity.getId().toString() ,
                entity.getName() ,
                entity.getPrice().toString());
    }
}

