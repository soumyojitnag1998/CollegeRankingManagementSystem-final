package com.cognizant.CollegeRankingManagementSystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.CollegeRankingManagementSystem.model.College;
import com.cognizant.CollegeRankingManagementSystem.model.Student;
import com.cognizant.CollegeRankingManagementSystem.repositories.CollegeRepository;
import com.cognizant.CollegeRankingManagementSystem.repositories.StudentRepository;

/*
 * This class generates the list of colleges as per the student requirement using Queries in the repository.
 */

@Service
public class RecommendationGenerator {

	@Autowired
	CollegeRepository collegeRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<College> normalStudent(Student student)
	{
		return collegeRepository.findForStudentSortByOverallRank(student.getScore(), student.getNationalExamRank(), student.getLocation(), student.getBranch());
	}
	
	public List<College> researchStudent(Student student)
	{
		return collegeRepository.findForStudentSortByResearchRank(student.getScore(), student.getNationalExamRank(), student.getLocation(), student.getBranch());
	}
	
	public List<College> placementStudent(Student student)
	{
		return collegeRepository.findForStudentSortByEmploymentRank(student.getScore(), student.getNationalExamRank(), student.getLocation(), student.getBranch());
	}
	
	// This method is called at first.
	// Checks the student interests and calls appropriate function.
	public List<College> calculateForStudent(String studentId)
	{
		Student student = studentRepository.findById(studentId).orElse(new Student());
		
		List<College> collegeList;
		if(student.getCatagory().equalsIgnoreCase("research"))
		{
			collegeList = researchStudent(student);
		}
		else if(student.getCatagory().equalsIgnoreCase("employment"))
		{
			collegeList = placementStudent(student);
		}
		else
		{
			collegeList = normalStudent(student);
		}
		return collegeList;
	}
}
