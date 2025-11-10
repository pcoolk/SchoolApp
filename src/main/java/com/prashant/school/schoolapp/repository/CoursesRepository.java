package com.prashant.school.schoolapp.repository;

import com.prashant.school.schoolapp.model.Courses;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


@Repository
public interface CoursesRepository extends JpaRepository<Courses,Integer> {

}
