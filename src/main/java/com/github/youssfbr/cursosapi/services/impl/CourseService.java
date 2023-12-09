package com.github.youssfbr.cursosapi.services.impl;

import com.github.youssfbr.cursosapi.dtos.CourseCreateRequestDTO;
import com.github.youssfbr.cursosapi.dtos.CourseResponseDTO;
import com.github.youssfbr.cursosapi.dtos.CourseUpdateRequestDTO;
import com.github.youssfbr.cursosapi.entities.Course;
import com.github.youssfbr.cursosapi.repositories.ICourseRepository;
import com.github.youssfbr.cursosapi.services.ICourseService;
import com.github.youssfbr.cursosapi.services.exceptions.ResourceNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final ICourseRepository courseRepository;
    private static final String NOT_FOUND_MESSAGE = "Resource not found with id ";

    @Override
    @Transactional(readOnly = true)
    public List<CourseResponseDTO> findAllCourses() {
        return courseRepository.findAllCourses()
                .stream()
                .map(CourseResponseDTO::new)
                .toList();
    }

    @Override
    @Transactional(readOnly = true)
    public CourseResponseDTO findCourse(Long id) {
        return courseRepository.findById(id)
                .map(CourseResponseDTO::new)
                .orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_MESSAGE + id));
    }

    @Override
    @Transactional
    public CourseResponseDTO createCourse(CourseCreateRequestDTO courseCreateRequestDTO) {

        final Course courseToSave = new Course(courseCreateRequestDTO);

        final Course courseSaved = courseRepository.save(courseToSave);

        return new CourseResponseDTO(courseSaved);
    }

    @Override
    @Transactional
    public CourseResponseDTO updateCourse(CourseUpdateRequestDTO courseUpdateRequestDTO) {

        final Course courseToUpdate = checkExistsCourse(courseUpdateRequestDTO.id());
        BeanUtils.copyProperties(courseUpdateRequestDTO, courseToUpdate);

        final Course courseUpdated = courseRepository.save(courseToUpdate);

        return new CourseResponseDTO(courseUpdated);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        checkExistsCourse(id);
        courseRepository.deleteById(id);

    }

    private Course checkExistsCourse(Long id) {
        return courseRepository.findById(id).
                orElseThrow(() -> new ResourceNotFoundException(NOT_FOUND_MESSAGE + id));
    }

}
