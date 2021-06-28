package com.cognizant.CollegeRankingManagementSystem;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.CollegeRankingManagementSystem.Controller.SessionController;
import com.cognizant.CollegeRankingManagementSystem.firebase.CollegeAuthentication;
import com.cognizant.CollegeRankingManagementSystem.firebase.StudentAuthentication;

@SpringBootTest
class CollegeRankingManagementSystemFinalApplicationTests {

	@Autowired
	StudentAuthentication studentAuthentication;
	
	@Autowired
	SessionController sessionController;
	
	@Autowired
	CollegeAuthentication collegeAuthentication;
	
	@Test
	public void testCollegeAuthentication()
	{
		assertEquals(collegeAuthentication.getApiKey(), "AIzaSyBdEdftRcsKKikySNTf131WC9khUBB67zU");
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

}
