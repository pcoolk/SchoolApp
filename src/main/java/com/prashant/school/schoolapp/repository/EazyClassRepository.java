package com.prashant.school.schoolapp.repository;

import com.prashant.school.schoolapp.model.EazyClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EazyClassRepository extends JpaRepository<EazyClass, Integer> {
}
