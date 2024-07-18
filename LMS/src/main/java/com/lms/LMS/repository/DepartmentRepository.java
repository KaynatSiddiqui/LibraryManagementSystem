package com.lms.LMS.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.lms.LMS.model.Department;


@Repository
@EnableJpaRepositories
public interface DepartmentRepository extends JpaRepository<Department, Long>{

}
