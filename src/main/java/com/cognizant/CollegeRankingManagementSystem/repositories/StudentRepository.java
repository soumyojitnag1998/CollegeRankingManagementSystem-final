package com.cognizant.CollegeRankingManagementSystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.CollegeRankingManagementSystem.model.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
