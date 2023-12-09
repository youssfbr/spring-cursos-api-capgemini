package com.github.youssfbr.cursosapi.services;

import com.github.youssfbr.cursosapi.entities.Course;

import java.util.List;

public interface ICourseService {
    List<Course> findAllCourses();
}
