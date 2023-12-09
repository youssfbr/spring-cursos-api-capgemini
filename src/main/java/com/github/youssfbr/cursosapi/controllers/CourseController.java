package com.github.youssfbr.cursosapi.controllers;

import com.github.youssfbr.cursosapi.dtos.CourseCreateRequestDTO;
import com.github.youssfbr.cursosapi.dtos.CourseResponseDTO;
import com.github.youssfbr.cursosapi.services.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final ICourseService courseService;

    @GetMapping
    public ResponseEntity<List<CourseResponseDTO>> findAllCourses() {
        return ResponseEntity.ok(courseService.findAllCourses());
    }

    @PostMapping
    public ResponseEntity<CourseResponseDTO> courseCreate(@RequestBody CourseCreateRequestDTO courseCreateRequestDTO) {

        final CourseResponseDTO courseCreated = courseService.createCourse(courseCreateRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(courseCreated.id())
                .toUri();

        return ResponseEntity.created(location).body(courseCreated);
    }
}
