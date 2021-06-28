package com.cognizant.CollegeRankingManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.CollegeRankingManagementSystem.firebase.CollegeAuthentication;
import com.cognizant.CollegeRankingManagementSystem.firebase.StudentAuthentication;
import com.cognizant.CollegeRankingManagementSystem.repositories.CollegeRepository;
import com.cognizant.CollegeRankingManagementSystem.repositories.StudentRepository;

/*
 * All the login and student registration is done through this page.
 * Firebase is used to manage the authentication of the users and store the credentials.
 */

@Controller
public class SessionController {

	@Autowired
	CollegeAuthentication collegeAuthentication;

	@Autowired
	StudentAuthentication studentAuthentication;

	@Autowired
	StudentRepository studentRepository;

	@Autowired
	CollegeRepository collegeRepository;

	// This redirects to the welcome page when opened a web site.
	@RequestMapping("/")
	public String firstUrl() {
		return "welcome";
	}

	// This is used to proceed to the student login page.
	@RequestMapping("login")
	public ModelAndView toLoginPage() {
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

	// This is used to proceed to the student registration page.
	@RequestMapping("registration")
	public ModelAndView toRegisterPage() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("registration");
		modelAndView.addObject("apiKey", studentAuthentication.getApiKey());
		modelAndView.addObject("authDomain", studentAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", studentAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", studentAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", studentAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", studentAuthentication.getAppId());
		return modelAndView;
	}

	// This is used to proceed to the administrator login.
	@RequestMapping("collegeLogin")
	public ModelAndView toCollegeLogin() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("college_login");
		modelAndView.addObject("apiKey", collegeAuthentication.getApiKey());
		modelAndView.addObject("authDomain", collegeAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", collegeAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", collegeAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", collegeAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", collegeAuthentication.getAppId());
		return modelAndView;
	}

	// This is forgot password link. Used to enter the email address and Firebase sends a mail to change password.
	@RequestMapping("forgotPassword")
	public ModelAndView forgotPassword() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("forgot_password");
		modelAndView.addObject("apiKey", studentAuthentication.getApiKey());
		modelAndView.addObject("authDomain", studentAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", studentAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", studentAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", studentAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", studentAuthentication.getAppId());
		return modelAndView;
	}
}
