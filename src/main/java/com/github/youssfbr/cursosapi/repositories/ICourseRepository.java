package com.github.youssfbr.cursosapi.repositories;

import com.github.youssfbr.cursosapi.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ICourseRepository extends JpaRepository<Course, Long> {
    @Query(nativeQuery = true, value = """
            SELECT c.id_curso, c.nome_curso, c.valor_curso
            FROM tb_curso c;
            """)
    List<Course> findAllCourses();
}
