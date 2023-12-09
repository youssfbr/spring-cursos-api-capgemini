package com.github.youssfbr.cursosapi.controllers;

import com.github.youssfbr.cursosapi.dtos.CourseCreateRequestDTO;
import com.github.youssfbr.cursosapi.dtos.CourseResponseDTO;
import com.github.youssfbr.cursosapi.services.ICourseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@Tag(name = "Cursos")
@RequiredArgsConstructor
@RequestMapping("/api/courses")
public class CourseController {

    private final ICourseService courseService;

    @GetMapping
    @Operation(summary = "Listar", description = "Lista todos os cursos")
    public ResponseEntity<List<CourseResponseDTO>> findAllCourses() {
        return ResponseEntity.ok(courseService.findAllCourses());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Listar por ID", description = "Lista um curso pelo ID (Número)")
    public ResponseEntity<CourseResponseDTO> findUserById(@PathVariable Long id) {
        return ResponseEntity.ok(courseService.findCourse(id));
    }

    @PostMapping
    @Operation(summary = "Salvar", description = "Salva um curso")
    public ResponseEntity<CourseResponseDTO> courseCreate(@RequestBody CourseCreateRequestDTO courseCreateRequestDTO) {

        final CourseResponseDTO courseCreated = courseService.createCourse(courseCreateRequestDTO);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(courseCreated.id())
                .toUri();

        return ResponseEntity.created(location).body(courseCreated);
    }
}
