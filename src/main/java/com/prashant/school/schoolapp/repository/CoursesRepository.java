package com.prashant.school.schoolapp.repository;

import com.prashant.school.schoolapp.model.Courses;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


@Repository
public interface CoursesRepository extends JpaRepository<Courses,Integer> {

    List<Courses> findByOrderByNameDesc();
    List<Courses> findByOrderByName();

}
