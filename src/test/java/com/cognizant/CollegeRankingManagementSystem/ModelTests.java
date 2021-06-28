package com.cognizant.CollegeRankingManagementSystem;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.CollegeRankingManagementSystem.model.College;
import com.cognizant.CollegeRankingManagementSystem.model.Student;

@SpringBootTest
class ModelTests {
	
	// This is College class

	@Test
	public void testCollege()
	{
		College college = new College(100, "ABC College", "contact@support.abc.com", "admissions@abc.com", "abc.com", "ECE, CSE, IT", "Hyderabad, Telangana", 80, 4000, "Decent College", "None", 150, 12.0, 87, 20, 40, 3000, 98, 0, 30, 300000, 4000, 3000, 2000, 4, 3, 2);
		assertEquals(college.getCollegeId() + college.getCollegeName() + college.getSupportEmail() + college.getAdmissionEmail() + college.getCollegeWebsite() + college.getBranches() + college.getLocation() + college.getMinimumMarks() + college.getMinimumRank() + college.getBio() + college.getScholarships() + college.getNoOfProfessors() + college.getNumberOfStudentsPerFaculty() + college.getPlacementPercentage() + college.getAveragePackage() + college.getTopPackage() + college.getResearchPublished() + college.getPassPercentage() + college.getNoOfScholarships() + college.getNoOfPartnerCompanies() + college.getFee() + college.getOverallScore() + college.getResearchScore() + college.getEmploymentScore() + college.getOverallRank() + college.getResearchRank() + college.getEmploymentRank(), 100 + "ABC College" + "contact@support.abc.com" + "admissions@abc.com" + "abc.com" + "ECE, CSE, IT" + "Hyderabad, Telangana" + 80 + 4000 + "Decent College" + "None" + 150 + 12.0 + 87.0 + 20.0 + 40.0 + 3000 + 98.0 + 0 + 30 + 300000 + 4000.0 + 3000.0 + 2000.0 + 4 + 3 + 2);
	}
	
	@Test
	public void testCollegeSetters()
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
		college.setOverallScore(4000);
		college.setResearchScore(3000);
		college.setEmploymentScore(2000);
		college.setOverallRank(4);
		college.setResearchRank(3);
		college.setEmploymentRank(2);
		assertEquals(college.getCollegeId() + college.getCollegeName() + college.getSupportEmail() + college.getAdmissionEmail() + college.getCollegeWebsite() + college.getBranches() + college.getLocation() + college.getMinimumMarks() + college.getMinimumRank() + college.getBio() + college.getScholarships() + college.getNoOfProfessors() + college.getNumberOfStudentsPerFaculty() + college.getPlacementPercentage() + college.getAveragePackage() + college.getTopPackage() + college.getResearchPublished() + college.getPassPercentage() + college.getNoOfScholarships() + college.getNoOfPartnerCompanies() + college.getFee() + college.getOverallScore() + college.getResearchScore() + college.getEmploymentScore() + college.getOverallRank() + college.getResearchRank() + college.getEmploymentRank(), 100 + "ABC College" + "contact@support.abc.com" + "admissions@abc.com" + "abc.com" + "ECE, CSE, IT" + "Hyderabad, Telangana" + 80 + 4000 + "Decent College" + "None" + 150 + 12.0 + 87.0 + 20.0 + 40.0 + 3000 + 98.0 + 0 + 30 + 300000 + 4000.0 + 3000.0 + 2000.0 + 4 + 3 + 2);
	}
	
	@Test
	public void testCollegeSettersAndConstructors()
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
		college.setOverallScore(4000);
		college.setResearchScore(3000);
		college.setEmploymentScore(2000);
		college.setOverallRank(4);
		college.setResearchRank(3);
		college.setEmploymentRank(2);
		
		College college1 = new College(100, "ABC College", "contact@support.abc.com", "admissions@abc.com", "abc.com", "ECE, CSE, IT", "Hyderabad, Telangana", 80, 4000, "Decent College", "None", 150, 12.0, 87, 20, 40, 3000, 98, 0, 30, 300000, 4000, 3000, 2000, 4, 3, 2);
		
		assertEquals(college.toString(), college1.toString());
	}
	
	
	
	
	
	
	
	// This is Student class
	
	
	@Test
	public void testStudent()
	{
		Student student = new Student("ABCDEF123", "ABC", "DEF", "CSE", 89, "Hyderabad", "Research", 2000);
		assertEquals(student.getStudentId() + student.getFirstName() + student.getLastName() + student.getBranch() + student.getScore() + student.getLocation() + student.getCatagory() + student.getNationalExamRank(), "ABCDEF123" + "ABC" + "DEF" + "CSE" + 89 + "Hyderabad" + "Research" + 2000);
	}
	
	@Test
	public void testStudentSetters()
	{
		Student student = new Student();
		student.setStudentId("ABCDEF123");
		student.setFirstName("ABC");
		student.setLastName("DEF");
		student.setBranch("CSE");
		student.setScore(89);
		student.setLocation("Hyderabad");
		student.setCatagory("Research");
		student.setNationalExamRank(2000);
		
		assertEquals(student.getStudentId() + student.getFirstName() + student.getLastName() + student.getBranch() + student.getScore() + student.getLocation() + student.getCatagory() + student.getNationalExamRank(), "ABCDEF123" + "ABC" + "DEF" + "CSE" + 89 + "Hyderabad" + "Research" + 2000);
	}
	
	@Test
	public void testStudentSettersAndConstructors()
	{
		Student student = new Student();
		student.setStudentId("ABCDEF123");
		student.setFirstName("ABC");
		student.setLastName("DEF");
		student.setBranch("CSE");
		student.setScore(89);
		student.setLocation("Hyderabad");
		student.setCatagory("Research");
		student.setNationalExamRank(2000);
		
		Student student1 = new Student("ABCDEF123", "ABC", "DEF", "CSE", 89, "Hyderabad", "Research", 2000);
		
		assertEquals(student.toString(), student1.toString());
	}

}
