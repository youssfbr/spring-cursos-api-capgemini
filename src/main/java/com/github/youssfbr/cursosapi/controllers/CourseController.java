package com.github.youssfbr.cursosapi.controllers;

import com.github.youssfbr.cursosapi.dtos.CourseResponseDTO;
import com.github.youssfbr.cursosapi.services.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
