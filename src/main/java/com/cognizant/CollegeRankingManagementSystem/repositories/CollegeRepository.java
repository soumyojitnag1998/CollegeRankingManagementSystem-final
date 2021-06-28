package com.cognizant.CollegeRankingManagementSystem.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cognizant.CollegeRankingManagementSystem.model.College;

public interface CollegeRepository extends JpaRepository<College, Integer> {

	@Query("FROM College WHERE branches LIKE %?1% ORDER BY overall_rank")
	List<College> findByBranchSorted(String branch);
	
	@Query("FROM College WHERE minimum_marks <= ?1 AND minimum_rank >= ?2 AND location LIKE %?3% AND branches LIKE %?4% ORDER BY overall_rank")
	List<College> findForStudentSortByOverallRank(int score, int nationalExamRank, String location, String branch);
	
	@Query("FROM College WHERE minimum_marks <= ?1 AND minimum_rank >= ?2 AND location LIKE %?3% AND branches LIKE %?4% ORDER BY employment_rank")
	List<College> findForStudentSortByEmploymentRank(int score, int nationalExamRank, String location, String branch);
	
	@Query("FROM College WHERE minimum_marks <= ?1 AND minimum_rank >= ?2 AND location LIKE %?3% AND branches LIKE %?4% ORDER BY research_rank")
	List<College> findForStudentSortByResearchRank(int score, int nationalExamRank, String location, String branch);
	
	@Query(value = "SELECT RANK() OVER(ORDER BY overall_score DESC) AS overallRankFromScore FROM College", nativeQuery = true)
	List<Integer> overallRankQuery();
	
	@Query(value = "SELECT RANK() OVER(ORDER BY research_score DESC) AS researchRankFromScore FROM College", nativeQuery = true)
	List<Integer> researchRankQuery();
	
	@Query(value = "SELECT RANK() OVER(ORDER BY employment_score DESC) AS employmentRankFromScore FROM College", nativeQuery = true)
	List<Integer> employmentRankQuery();
	
	@Query("FROM College ORDER BY overall_score DESC")
	List<College> overallScoreDescList();
	
	@Query("FROM College ORDER BY research_score DESC")
	List<College> researchScoreDescList();
	
	@Query("FROM College ORDER BY employment_score DESC")
	List<College> employmentScoreDescList();
	
	@Query("FROM College WHERE location LIKE %?1%"
			+ "OR college_name LIKE %?1%"
			+ "OR branches LIKE %?1%"
			+ "ORDER BY overall_rank ASC")
	List<College> findAll(String keyword);
}