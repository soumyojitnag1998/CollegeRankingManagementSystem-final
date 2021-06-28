package com.cognizant.CollegeRankingManagementSystem;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.CollegeRankingManagementSystem.model.College;
import com.cognizant.CollegeRankingManagementSystem.service.ScoreGenerator;

@SpringBootTest
class ServiceTests {

	@Autowired
	ScoreGenerator scoreGenerator;
	
	@Test
	public void testGenerateOverallScore()
	{
		College college = new College();
		college.setCollegeId(100);
		college.setCollegeName("ABC College");
		college.setSupportEmail("contact@support.abc.com");
		college.setAdmissionEmail("admissions@abc.com");
		college.setCollegeWebsite("abc.com");
		college.setBranches("ECE, CSE, IT");
		college.setLocation("Hyderabad, Telangana");
		college.setMinimumMarks(80);
		college.setMinimumRank(4000);
		college.setBio("Decent College");
		college.setScholarships("None");
		college.setNoOfProfessors(150);
		college.setNumberOfStudentsPerFaculty(12.0);
		college.setPlacementPercentage(87);
		college.setAveragePackage(20);
		college.setTopPackage(40);
		college.setResearchPublished(3000);
		college.setNoOfScholarships(0);
		college.setPassPercentage(98);
		college.setNoOfPartnerCompanies(30);
		college.setFee(300000);
		
		assertEquals(scoreGenerator.generateOverallScore(college),986.333333, 1e-5);
	}
	
	@Test
	public void testGenerateResearchScore()
	{
		College college = new College();
		college.setCollegeId(100);
		college.setCollegeName("ABC College");
		college.setSupportEmail("contact@support.abc.com");
		college.setAdmissionEmail("admissions@abc.com");
		college.setCollegeWebsite("abc.com");
		college.setBranches("ECE, CSE, IT");
		college.setLocation("Hyderabad, Telangana");
		college.setMinimumMarks(80);
		college.setMinimumRank(4000);
		college.setBio("Decent College");
		college.setScholarships("None");
		college.setNoOfProfessors(150);
		college.setNumberOfStudentsPerFaculty(12.0);
		college.setPlacementPercentage(87);
		college.setAveragePackage(20);
		college.setTopPackage(40);
		college.setResearchPublished(3000);
		college.setNoOfScholarships(0);
		college.setPassPercentage(98);
		college.setNoOfPartnerCompanies(30);
		college.setFee(300000);
		
		college.setOverallScore(scoreGenerator.generateOverallScore(college));
		
		assertEquals(scoreGenerator.generateResearchScore(college), 18609.863333,1e-5);
	}
	
	@Test
	public void testGenerateEmploymentScore()
	{
		College college = new College();
		college.setCollegeId(100);
		college.setCollegeName("ABC College");
		college.setSupportEmail("contact@support.abc.com");
		college.setAdmissionEmail("admissions@abc.com");
		college.setCollegeWebsite("abc.com");
		college.setBranches("ECE, CSE, IT");
		college.setLocation("Hyderabad, Telangana");
		college.setMinimumMarks(80);
		college.setMinimumRank(4000);
		college.setBio("Decent College");
		college.setScholarships("None");
		college.setNoOfProfessors(150);
		college.setNumberOfStudentsPerFaculty(12.0);
		college.setPlacementPercentage(87);
		college.setAveragePackage(20);
		college.setTopPackage(40);
		college.setResearchPublished(3000);
		college.setNoOfScholarships(0);
		college.setPassPercentage(98);
		college.setNoOfPartnerCompanies(30);
		college.setFee(300000);
		
		college.setOverallScore(scoreGenerator.generateOverallScore(college));
		
		assertEquals(scoreGenerator.generateEmploymentScore(college), 517.8633333, 1e-5);
	}

}
