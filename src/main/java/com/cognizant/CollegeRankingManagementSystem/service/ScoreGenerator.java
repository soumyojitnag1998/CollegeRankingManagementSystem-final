package com.cognizant.CollegeRankingManagementSystem.service;

import org.springframework.stereotype.Service;

import com.cognizant.CollegeRankingManagementSystem.model.College;

/*
 * This class generates the score using parameters of of the college.
 * Uses weights to distribute the amounts equally.
 */

@Service
public class ScoreGenerator {

	public double generateOverallScore(College college)
	{
		return (college.getNoOfProfessors()) + (100*(1/college.getNumberOfStudentsPerFaculty())) + (2 * college.getPlacementPercentage()) + (4 * (college.getAveragePackage() + college.getTopPackage())) + (college.getResearchPublished()/25) + (3 * college.getPassPercentage()) + (5 * college.getNoOfScholarships()) + (10 * college.getNoOfPartnerCompanies()) - (0.001 * college.getFee());
	}
	
	public double generateResearchScore(College college)
	{
		return (0.01 * college.getOverallScore()) + ((double) college.getResearchPublished() * 6) + ((double) college.getNoOfProfessors() * 4);
	}
	
	public double generateEmploymentScore(College college)
	{
		return (0.01 * college.getOverallScore()) + ((double) college.getPlacementPercentage() * 4) + ((double) college.getTopPackage() * 2) + ((double) college.getAveragePackage() * 4);
	}
}
