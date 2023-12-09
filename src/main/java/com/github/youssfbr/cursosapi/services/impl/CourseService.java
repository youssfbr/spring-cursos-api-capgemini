package com.github.youssfbr.cursosapi.services.impl;

import com.github.youssfbr.cursosapi.entities.Course;
import com.github.youssfbr.cursosapi.repositories.ICourseRepository;
import com.github.youssfbr.cursosapi.services.ICourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService implements ICourseService {

    private final ICourseRepository courseRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Course> findAllCourses() {
        return courseRepository.findAllCourses();
    }
}
