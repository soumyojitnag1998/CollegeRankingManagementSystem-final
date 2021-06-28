package com.cognizant.CollegeRankingManagementSystem.model;

import javax.persistence.Entity;
import javax.persistence.Id;

/*
 * Spring repository is used in this project.
 * This is a model class for the Student Information.
 */

@Entity
public class Student {

	@Id
	private String studentId;
	private String firstName;
	private String lastName;
	private String branch;
	private int score;
	private String location;
	
	// New parameters:
	private String catagory;
	private int nationalExamRank;

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Student(String studentId, String firstName, String lastName, String branch, int score, String location,
			String catagory, int nationalExamRank) {
		super();
		this.studentId = studentId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.branch = branch;
		this.score = score;
		this.location = location;
		this.catagory = catagory;
		this.nationalExamRank = nationalExamRank;
	}

	public String getStudentId() {
		return studentId;
	}

	public void setStudentId(String studentId) {
		this.studentId = studentId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getCatagory() {
		return catagory;
	}

	public void setCatagory(String catagory) {
		this.catagory = catagory;
	}

	public int getNationalExamRank() {
		return nationalExamRank;
	}

	public void setNationalExamRank(int nationalExamRank) {
		this.nationalExamRank = nationalExamRank;
	}

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", branch="
				+ branch + ", score=" + score + ", location=" + location + ", catagory=" + catagory
				+ ", nationalExamRank=" + nationalExamRank + "]";
	}
}