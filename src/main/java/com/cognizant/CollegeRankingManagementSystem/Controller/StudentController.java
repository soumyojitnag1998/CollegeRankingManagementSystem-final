package com.cognizant.CollegeRankingManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.CollegeRankingManagementSystem.firebase.StudentAuthentication;
import com.cognizant.CollegeRankingManagementSystem.model.College;
import com.cognizant.CollegeRankingManagementSystem.model.Student;
import com.cognizant.CollegeRankingManagementSystem.repositories.StudentRepository;
import com.cognizant.CollegeRankingManagementSystem.service.RecommendationGenerator;

/*
 * This controller is specific to student.
 * Contains all the student functions that needs to be processed.
 */

@Controller
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentAuthentication studentAuthentication;
	
	@Autowired
	RecommendationGenerator recommendationGenerator;
	
	// This fetches the userID and adds student details to the database after adding it to the firebase.
	// The get mapping adds the student model to the JSP page.
	@GetMapping("addStudent/{userId}")
	public String addStudent(Model model, @PathVariable String userId) {
		Student student = new Student();
		student.setStudentId(userId);
		model.addAttribute("student", student);

		model.addAttribute("apiKey", studentAuthentication.getApiKey());
		model.addAttribute("authDomain", studentAuthentication.getAuthDomain());
		model.addAttribute("projectId", studentAuthentication.getProjectId());
		model.addAttribute("storageBucket", studentAuthentication.getStorageBucket());
		model.addAttribute("messagingSenderId", studentAuthentication.getMessagingSenderId());
		model.addAttribute("appId", studentAuthentication.getAppId());
		return "add_student";
	}

	// This post mapping saves the user details to the database.
	@PostMapping("addStudent")
	public ModelAndView saveStudent(@ModelAttribute("student") Student student) {
		
		// Adding the student details into the student repository.
		studentRepository.save(student);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		modelAndView.addObject("apiKey", studentAuthentication.getApiKey());
		modelAndView.addObject("authDomain", studentAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", studentAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", studentAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", studentAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", studentAuthentication.getAppId());
		return modelAndView;
	}

	// Used to redirect to the student home page.
	@RequestMapping("studentHomepage")
	public ModelAndView toStudentHomepage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("student_homepage");
		modelAndView.addObject("apiKey", studentAuthentication.getApiKey());
		modelAndView.addObject("authDomain", studentAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", studentAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", studentAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", studentAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", studentAuthentication.getAppId());
		return modelAndView;
	}
	
	// Adds student model to the JSP page by fetching and displaying current values stored in the database.
	@GetMapping("updateStudent/{userId}")
	public String updateStudent(Model model, @PathVariable String userId) {
		
		// Getting the student details from the repository.
		// If no detail is found, we create a new field for the student.
		Student student = studentRepository.findById(userId).orElse(new Student());
		student.setStudentId(userId);
		model.addAttribute("student", student);
		
		model.addAttribute("apiKey", studentAuthentication.getApiKey());
		model.addAttribute("authDomain", studentAuthentication.getAuthDomain());
		model.addAttribute("projectId", studentAuthentication.getProjectId());
		model.addAttribute("storageBucket", studentAuthentication.getStorageBucket());
		model.addAttribute("messagingSenderId", studentAuthentication.getMessagingSenderId());
		model.addAttribute("appId", studentAuthentication.getAppId());
		return "update-student";
	}

	// This is used to update the details of the student after clicking on submit.
	@PostMapping("updateStudent")
	public ModelAndView updateStudent(@ModelAttribute("student") Student student) {
		
		// Adding the new details to the repository.
		studentRepository.save(student);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("student_homepage");
		modelAndView.addObject("apiKey", studentAuthentication.getApiKey());
		modelAndView.addObject("authDomain", studentAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", studentAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", studentAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", studentAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", studentAuthentication.getAppId());
		return modelAndView;
	}
	
	// This fetches list of colleges by recommendation generator and displays to the student.
	@RequestMapping("getRecommendations/{studentId}")
	public ModelAndView sendRecommendations(@PathVariable String studentId)
	{
		// recommendation generator is present in the service class.
		List<College> collegeList = recommendationGenerator.calculateForStudent(studentId);
		
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("display_college");
		modelAndView.addObject("collegeList", collegeList);
		modelAndView.addObject("apiKey", studentAuthentication.getApiKey());
		modelAndView.addObject("authDomain", studentAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", studentAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", studentAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", studentAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", studentAuthentication.getAppId());
		return modelAndView;
	}
}
