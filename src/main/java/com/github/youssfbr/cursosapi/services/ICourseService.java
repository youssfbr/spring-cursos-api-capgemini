package com.github.youssfbr.cursosapi.services;

import com.github.youssfbr.cursosapi.dtos.CourseCreateRequestDTO;
import com.github.youssfbr.cursosapi.dtos.CourseResponseDTO;

import java.util.List;

public interface ICourseService {
    List<CourseResponseDTO> findAllCourses();
    CourseResponseDTO findCourse(Long id);
    CourseResponseDTO createCourse(CourseCreateRequestDTO courseCreateRequestDTO);
}
