package com.cognizant.CollegeRankingManagementSystem.model;

/*
 * Spring repository is used in this project.
 * This is a model class for the College Information.
 */

import javax.persistence.Entity;
import javax.persistence.Id;

import org.springframework.stereotype.Component;

@Entity
@Component
public class College {

	@Id
	private int collegeId; // Primary key
	private String collegeName;
	private String supportEmail;
	private String admissionEmail;
	private String collegeWebsite; // Actual college web-site
	private String branches; // Comma separated values of branches in abbreviation form
	private String location;
	private int minimumMarks; // Minimum score required to apply for the college
	private int minimumRank; // Minimum national rank required to apply for college
	private String bio;
	private String scholarships; // Scholarships provided by the college

	// Ranking parameters
	private int noOfProfessors; // Positive parameter
	private double numberOfStudentsPerFaculty; // Positive parameter
	private double placementPercentage; // Positive parameter
	private double averagePackage; // Positive parameter
	private double topPackage; // Positive parameter
	private int researchPublished; // Positive parameter
	private double passPercentage; // Positive parameter
	private int noOfScholarships; // Positive parameter
	private int noOfPartnerCompanies; // Positive parameter
	private int fee; // Negative parameter

	// Score of each college
	private double overallScore;
	private double researchScore;
	private double employmentScore;

	// rank parameters
	private int overallRank;
	private int researchRank;
	private int employmentRank;

	public College() {
		super();
		// TODO Auto-generated constructor stub
	}

	public College(int collegeId, String collegeName, String supportEmail, String admissionEmail, String collegeWebsite,
			String branches, String location, int minimumMarks, int minimumRank, String bio, String scholarships,
			int noOfProfessors, double numberOfStudentsPerFaculty, double placementPercentage, double averagePackage,
			double topPackage, int researchPublished, double passPercentage, int noOfScholarships,
			int noOfPartnerCompanies, int fee, double overallScore, double researchScore, double employmentScore,
			int overallRank, int researchRank, int employmentRank) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
		this.supportEmail = supportEmail;
		this.admissionEmail = admissionEmail;
		this.collegeWebsite = collegeWebsite;
		this.branches = branches;
		this.location = location;
		this.minimumMarks = minimumMarks;
		this.minimumRank = minimumRank;
		this.bio = bio;
		this.scholarships = scholarships;
		this.noOfProfessors = noOfProfessors;
		this.numberOfStudentsPerFaculty = numberOfStudentsPerFaculty;
		this.placementPercentage = placementPercentage;
		this.averagePackage = averagePackage;
		this.topPackage = topPackage;
		this.researchPublished = researchPublished;
		this.passPercentage = passPercentage;
		this.noOfScholarships = noOfScholarships;
		this.noOfPartnerCompanies = noOfPartnerCompanies;
		this.fee = fee;
		this.overallScore = overallScore;
		this.researchScore = researchScore;
		this.employmentScore = employmentScore;
		this.overallRank = overallRank;
		this.researchRank = researchRank;
		this.employmentRank = employmentRank;
	}

	public int getCollegeId() {
		return collegeId;
	}

	public void setCollegeId(int collegeId) {
		this.collegeId = collegeId;
	}

	public String getCollegeName() {
		return collegeName;
	}

	public void setCollegeName(String collegeName) {
		this.collegeName = collegeName;
	}

	public String getSupportEmail() {
		return supportEmail;
	}

	public void setSupportEmail(String supportEmail) {
		this.supportEmail = supportEmail;
	}

	public String getAdmissionEmail() {
		return admissionEmail;
	}

	public void setAdmissionEmail(String admissionEmail) {
		this.admissionEmail = admissionEmail;
	}

	public String getCollegeWebsite() {
		return collegeWebsite;
	}

	public void setCollegeWebsite(String collegeWebsite) {
		this.collegeWebsite = collegeWebsite;
	}

	public String getBranches() {
		return branches;
	}

	public void setBranches(String branches) {
		this.branches = branches;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getMinimumMarks() {
		return minimumMarks;
	}

	public void setMinimumMarks(int minimumMarks) {
		this.minimumMarks = minimumMarks;
	}

	public int getMinimumRank() {
		return minimumRank;
	}

	public void setMinimumRank(int minimumRank) {
		this.minimumRank = minimumRank;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getScholarships() {
		return scholarships;
	}

	public void setScholarships(String scholarships) {
		this.scholarships = scholarships;
	}

	public int getNoOfProfessors() {
		return noOfProfessors;
	}

	public void setNoOfProfessors(int noOfProfessors) {
		this.noOfProfessors = noOfProfessors;
	}

	public double getNumberOfStudentsPerFaculty() {
		return numberOfStudentsPerFaculty;
	}

	public void setNumberOfStudentsPerFaculty(double numberOfStudentsPerFaculty) {
		this.numberOfStudentsPerFaculty = numberOfStudentsPerFaculty;
	}

	public double getPlacementPercentage() {
		return placementPercentage;
	}

	public void setPlacementPercentage(double placementPercentage) {
		this.placementPercentage = placementPercentage;
	}

	public double getAveragePackage() {
		return averagePackage;
	}

	public void setAveragePackage(double averagePackage) {
		this.averagePackage = averagePackage;
	}

	public double getTopPackage() {
		return topPackage;
	}

	public void setTopPackage(double topPackage) {
		this.topPackage = topPackage;
	}

	public int getResearchPublished() {
		return researchPublished;
	}

	public void setResearchPublished(int researchPublished) {
		this.researchPublished = researchPublished;
	}

	public double getPassPercentage() {
		return passPercentage;
	}

	public void setPassPercentage(double passPercentage) {
		this.passPercentage = passPercentage;
	}

	public int getNoOfScholarships() {
		return noOfScholarships;
	}

	public void setNoOfScholarships(int noOfScholarships) {
		this.noOfScholarships = noOfScholarships;
	}

	public int getNoOfPartnerCompanies() {
		return noOfPartnerCompanies;
	}

	public void setNoOfPartnerCompanies(int noOfPartnerCompanies) {
		this.noOfPartnerCompanies = noOfPartnerCompanies;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public double getOverallScore() {
		return overallScore;
	}

	public void setOverallScore(double overallScore) {
		this.overallScore = overallScore;
	}

	public double getResearchScore() {
		return researchScore;
	}

	public void setResearchScore(double researchScore) {
		this.researchScore = researchScore;
	}

	public double getEmploymentScore() {
		return employmentScore;
	}

	public void setEmploymentScore(double employmentScore) {
		this.employmentScore = employmentScore;
	}

	public int getOverallRank() {
		return overallRank;
	}

	public void setOverallRank(int overallRank) {
		this.overallRank = overallRank;
	}

	public int getResearchRank() {
		return researchRank;
	}

	public void setResearchRank(int researchRank) {
		this.researchRank = researchRank;
	}

	public int getEmploymentRank() {
		return employmentRank;
	}

	public void setEmploymentRank(int employmentRank) {
		this.employmentRank = employmentRank;
	}

	@Override
	public String toString() {
		return "College [collegeId=" + collegeId + ", collegeName=" + collegeName + ", supportEmail=" + supportEmail
				+ ", admissionEmail=" + admissionEmail + ", collegeWebsite=" + collegeWebsite + ", branches=" + branches
				+ ", location=" + location + ", minimumMarks=" + minimumMarks + ", minimumRank=" + minimumRank
				+ ", bio=" + bio + ", scholarships=" + scholarships + ", noOfProfessors=" + noOfProfessors
				+ ", numberOfStudentsPerFaculty=" + numberOfStudentsPerFaculty + ", placementPercentage="
				+ placementPercentage + ", averagePackage=" + averagePackage + ", topPackage=" + topPackage
				+ ", researchPublished=" + researchPublished + ", passPercentage=" + passPercentage
				+ ", noOfScholarships=" + noOfScholarships + ", noOfPartnerCompanies=" + noOfPartnerCompanies + ", fee="
				+ fee + ", overallScore=" + overallScore + ", researchScore=" + researchScore + ", employmentScore="
				+ employmentScore + ", overallRank=" + overallRank + ", researchRank=" + researchRank
				+ ", employmentRank=" + employmentRank + "]";
	}
}