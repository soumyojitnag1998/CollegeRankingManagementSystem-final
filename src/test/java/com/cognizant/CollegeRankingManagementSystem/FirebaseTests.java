package com.cognizant.CollegeRankingManagementSystem;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.cognizant.CollegeRankingManagementSystem.firebase.CollegeAuthentication;
import com.cognizant.CollegeRankingManagementSystem.firebase.StudentAuthentication;

@SpringBootTest
class FirebaseTests {

	@Autowired
	CollegeAuthentication collegeAuthentication;
	
	@Autowired
	StudentAuthentication studentAuthentication;
	
	
	
	
	
	// The below are College Authentication class tests:
	
	@Test
	public void testCollegeAuthentication()
	{
		CollegeAuthentication newCollegeAuthentication = new CollegeAuthentication("AIzaSyBdEdftRcsKKikySNTf131WC9khUBB67zU", "college-ranking-system.firebaseapp.com", "college-ranking-system", "college-ranking-system.appspot.com", "494464462526", "1:494464462526:web:9fac42a7b48eae31e278ef");
		assertEquals(collegeAuthentication.toString(), newCollegeAuthentication.toString());
	}
	
	@Test
	public void testCollegeAuthenticationSetters()
	{
		CollegeAuthentication newCollegeAuthentication = new CollegeAuthentication();
		newCollegeAuthentication.setApiKey("AIzaSyBdEdftRcsKKikySNTf131WC9khUBB67zU");
		newCollegeAuthentication.setAppId("1:494464462526:web:9fac42a7b48eae31e278ef");
		newCollegeAuthentication.setAuthDomain("college-ranking-system.firebaseapp.com");
		newCollegeAuthentication.setMessagingSenderId("494464462526");
		newCollegeAuthentication.setProjectId("college-ranking-system");
		newCollegeAuthentication.setStorageBucket("college-ranking-system.appspot.com");
		assertEquals(collegeAuthentication.toString(), newCollegeAuthentication.toString());
	}
	
	
	
	
	
	// The below are Student Authentication class tests:
	@Test
	public void testStudentAuthentication()
	{
		StudentAuthentication newStudentAuthentication = new StudentAuthentication("AIzaSyCBM4KHudeNdRCWpor5MiJlk4kRxVwH6uc", "collegerankings-e2de4.firebaseapp.com", "collegerankings-e2de4", "collegerankings-e2de4.appspot.com", "992043975044", "1:992043975044:web:29728840ed8f6470e3ddd1");
		assertEquals(studentAuthentication.toString(), newStudentAuthentication.toString());
	}
	
	@Test
	public void testStudentAuthenticationSetters()
	{
		StudentAuthentication newStudentAuthentication = new StudentAuthentication();
		newStudentAuthentication.setApiKey("AIzaSyCBM4KHudeNdRCWpor5MiJlk4kRxVwH6uc");
		newStudentAuthentication.setAppId("1:992043975044:web:29728840ed8f6470e3ddd1");
		newStudentAuthentication.setAuthDomain("collegerankings-e2de4.firebaseapp.com");
		newStudentAuthentication.setMessagingSenderId("992043975044");
		newStudentAuthentication.setProjectId("collegerankings-e2de4");
		newStudentAuthentication.setStorageBucket("collegerankings-e2de4.appspot.com");
		assertEquals(studentAuthentication.toString(), newStudentAuthentication.toString());
	}
}
