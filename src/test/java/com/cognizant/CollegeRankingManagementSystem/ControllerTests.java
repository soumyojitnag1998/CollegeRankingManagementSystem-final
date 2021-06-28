package com.cognizant.CollegeRankingManagementSystem;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.CollegeRankingManagementSystem.Controller.CollegeController;
import com.cognizant.CollegeRankingManagementSystem.Controller.SessionController;
import com.cognizant.CollegeRankingManagementSystem.Controller.StudentController;
import com.cognizant.CollegeRankingManagementSystem.firebase.CollegeAuthentication;
import com.cognizant.CollegeRankingManagementSystem.firebase.StudentAuthentication;
import com.cognizant.CollegeRankingManagementSystem.repositories.CollegeRepository;
import com.cognizant.CollegeRankingManagementSystem.repositories.StudentRepository;
import com.cognizant.CollegeRankingManagementSystem.service.RecommendationGenerator;
import com.cognizant.CollegeRankingManagementSystem.model.College;
import com.cognizant.CollegeRankingManagementSystem.model.Student;

@SpringBootTest
class ControllerTests {
	
	@Autowired
	StudentAuthentication studentAuthentication;
	
	@Autowired
	SessionController sessionController;
	
	@Autowired
	CollegeAuthentication collegeAuthentication;
	
	@Autowired
	CollegeController collegeController;
	
	@Autowired
	CollegeRepository collegeRepository;
	
	@Autowired
	StudentController studentController;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	RecommendationGenerator recommendationGenerator;
	
	
	
	
	
	
	
	
	//Session Controller Unit Test Cases are as follows:
	
	@Test
	public void testFirstUrl()
	{
		String resultUrl = "welcome";
		assertEquals(sessionController.firstUrl(), resultUrl);
	}
	
	@Test
	public void testToLoginPage()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("apiKey", studentAuthentication.getApiKey());
		modelAndView.addObject("authDomain", studentAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", studentAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", studentAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", studentAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", studentAuthentication.getAppId());
		assertEquals(sessionController.toLoginPage().toString(), modelAndView.toString());
	}
	
	@Test
	public void testToRegisterPage()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registration");
		modelAndView.addObject("apiKey", studentAuthentication.getApiKey());
		modelAndView.addObject("authDomain", studentAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", studentAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", studentAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", studentAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", studentAuthentication.getAppId());
		assertEquals(sessionController.toRegisterPage().toString(), modelAndView.toString());
	}
	
	@Test
	public void testToCollegeLogin()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("college_login");
		modelAndView.addObject("apiKey", collegeAuthentication.getApiKey());
		modelAndView.addObject("authDomain", collegeAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", collegeAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", collegeAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", collegeAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", collegeAuthentication.getAppId());
		assertEquals(sessionController.toCollegeLogin().toString(), modelAndView.toString());
	}
	
	
	
	@Test
	public void testForgotPassword()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forgot_password");
		modelAndView.addObject("apiKey", studentAuthentication.getApiKey());
		modelAndView.addObject("authDomain", studentAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", studentAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", studentAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", studentAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", studentAuthentication.getAppId());
		assertEquals(sessionController.forgotPassword().toString(), modelAndView.toString());
	}
	
	
	
	
	
	
	
	
	
	
	
	// Student Controller Unit Test Cases are as follow:
	
	@Test
	public void testSaveStudent()
	{
		Student student = new Student("123", "studentFN", "studentLN", "CSE", 99, "Chennai", "Research", 200);
		studentController.saveStudent(student);
		Student returnStudent = studentRepository.findById("123").orElse(new Student());
		
		assertEquals(student.toString(), returnStudent.toString());
	}
	
	@Test
	public void testStudentHomepage()
	{
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("student_homepage");
		modelAndView.addObject("apiKey", studentAuthentication.getApiKey());
		modelAndView.addObject("authDomain", studentAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", studentAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", studentAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", studentAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", studentAuthentication.getAppId());
		assertEquals(modelAndView.toString(), studentController.toStudentHomepage().toString());
	}
	
	@Test
	public void testUpdateStudent()
	{
		Student student = new Student("1234", "FNOfStudent", "LNOfStudent", "ECE", 80, "Chennai", "Employment", 2000);
		studentController.updateStudent(student);
		Student returnStudent = studentRepository.findById("1234").orElse(new Student());
		
		assertEquals(student.toString(), returnStudent.toString());
	}
	
	@Test
	public void testSendRecommendations()
	{
		List<College> collegeList = recommendationGenerator.calculateForStudent("1234");
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display_college");
		modelAndView.addObject("collegeList", collegeList);
		modelAndView.addObject("apiKey", studentAuthentication.getApiKey());
		modelAndView.addObject("authDomain", studentAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", studentAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", studentAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", studentAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", studentAuthentication.getAppId());
		
		assertEquals(modelAndView.getViewName(), studentController.sendRecommendations("1234").getViewName());
	}

	
	
	
	
	
	
	
	
	
	
	
	// College Controller Unit Test Cases are as follows:
	
	
		@Test
		public void testToCollegeRegistrationTest()
		{
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("admin_front_page");
			modelAndView.addObject("apiKey", collegeAuthentication.getApiKey());
			modelAndView.addObject("authDomain", collegeAuthentication.getAuthDomain());
			modelAndView.addObject("projectId", collegeAuthentication.getProjectId());
			modelAndView.addObject("storageBucket", collegeAuthentication.getStorageBucket());
			modelAndView.addObject("messagingSenderId", collegeAuthentication.getMessagingSenderId());
			modelAndView.addObject("appId", collegeAuthentication.getAppId());
			assertEquals(collegeController.toCollegeRegistration().toString(), modelAndView.toString());
		}
		
		@Test
		public void testListAllColleges()
		{
			List<College> collegeList = collegeRepository.findAll(Sort.by("overallRank").and(Sort.by("numberOfStudentsPerFaculty")));
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("collegeList", collegeList);
			modelAndView.setViewName("display_college");
			assertEquals(modelAndView.getViewName(), collegeController.listAllColleges().getViewName());
		}
		
		@Test
		public void testResearchRankingColleges()
		{
			List<College> collegeList = collegeRepository.findAll(Sort.by("researchRank").and(Sort.by("overallRank")));
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("collegeList", collegeList);
			modelAndView.setViewName("display_college");
			assertEquals(modelAndView.getViewName(), collegeController.researchRankingColleges().getViewName());
		}
		
		@Test
		public void testEmploymentRankingColleges()
		{
			List<College> collegeList = collegeRepository.findAll(Sort.by("employmentRank").and(Sort.by("overallRank")));
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("collegeList", collegeList);
			modelAndView.setViewName("display_college");
			assertEquals(modelAndView.getViewName(), collegeController.employmentRankingColleges().getViewName());
		}
		
		@Test
		public void testListCollegesByBranch()
		{
			List<College> collegeList = collegeRepository.findByBranchSorted("ECE");
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("collegeList", collegeList);
			modelAndView.setViewName("display_college");
			assertEquals(modelAndView.getViewName(), collegeController.listCollegesByBranch("ECE").getViewName());
		}
		
		@Test
		public void testSearch()
		{
			ModelAndView modelAndView = new ModelAndView();
			List<College>collegeList=collegeRepository.findAll("K");
			modelAndView.addObject("collegeList",collegeList);
			modelAndView.setViewName("display_college");
			assertEquals(modelAndView.getViewName(), collegeController.Search("K").getViewName());
		}
		
		@Test
		public void testUpdateCollege()
		{
			College college = collegeRepository.findById(1001).orElse(new College());
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.addObject("college", college);
			modelAndView.setViewName("update-college");
			modelAndView.addObject("apiKey", collegeAuthentication.getApiKey());
			modelAndView.addObject("authDomain", collegeAuthentication.getAuthDomain());
			modelAndView.addObject("projectId", collegeAuthentication.getProjectId());
			modelAndView.addObject("storageBucket", collegeAuthentication.getStorageBucket());
			modelAndView.addObject("messagingSenderId", collegeAuthentication.getMessagingSenderId());
			modelAndView.addObject("appId", collegeAuthentication.getAppId());
			
			assertEquals(modelAndView.getViewName(), collegeController.updateCollege(1001).getViewName());
		}
		
		@Test
		public void testDeleteCollegeView()
		{
			ModelAndView modelAndView = new ModelAndView();
			modelAndView.setViewName("delete_college");
			modelAndView.addObject("apiKey", collegeAuthentication.getApiKey());
			modelAndView.addObject("authDomain", collegeAuthentication.getAuthDomain());
			modelAndView.addObject("projectId", collegeAuthentication.getProjectId());
			modelAndView.addObject("storageBucket", collegeAuthentication.getStorageBucket());
			modelAndView.addObject("messagingSenderId", collegeAuthentication.getMessagingSenderId());
			modelAndView.addObject("appId", collegeAuthentication.getAppId());
			
			assertEquals(modelAndView.getViewName(), collegeController.deleteCollegeView().getViewName());
		}
		
		/*
		 * @Test public void testDeleteCollege() { collegeRepository.deleteById(000);
		 * ModelAndView modelAndView = new ModelAndView();
		 * modelAndView.setViewName("admin_front_page");
		 * modelAndView.addObject("apiKey", collegeAuthentication.getApiKey());
		 * modelAndView.addObject("authDomain", collegeAuthentication.getAuthDomain());
		 * modelAndView.addObject("projectId", collegeAuthentication.getProjectId());
		 * modelAndView.addObject("storageBucket",
		 * collegeAuthentication.getStorageBucket());
		 * modelAndView.addObject("messagingSenderId",
		 * collegeAuthentication.getMessagingSenderId());
		 * modelAndView.addObject("appId", collegeAuthentication.getAppId());
		 * 
		 * assertEquals(modelAndView.getViewName(),
		 * collegeController.deleteCollege(000).getViewName()); }
		 */
		
}
