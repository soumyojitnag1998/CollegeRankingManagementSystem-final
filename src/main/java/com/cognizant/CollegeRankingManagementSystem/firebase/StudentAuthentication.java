package com.cognizant.CollegeRankingManagementSystem.firebase;

import org.springframework.stereotype.Component;

/*
 * This is a student Firebase project information.
 * This class contains the firebase project information to initialize the firebase in the JSP page.
 * The keys are fetched using the Controller class through this class and sent to the JSP file.
 * The Java Script is used for the firebase functions.
 */

@Component
public class StudentAuthentication {

	String apiKey = "AIzaSyCBM4KHudeNdRCWpor5MiJlk4kRxVwH6uc";
	String authDomain = "collegerankings-e2de4.firebaseapp.com";
	String projectId = "collegerankings-e2de4";
	String storageBucket = "collegerankings-e2de4.appspot.com";
	String messagingSenderId = "992043975044";
	String appId = "1:992043975044:web:29728840ed8f6470e3ddd1";

	public StudentAuthentication() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentAuthentication(String apiKey, String authDomain, String projectId, String storageBucket,
			String messagingSenderId, String appId) {
		super();
		this.apiKey = apiKey;
		this.authDomain = authDomain;
		this.projectId = projectId;
		this.storageBucket = storageBucket;
		this.messagingSenderId = messagingSenderId;
		this.appId = appId;
	}

	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	public String getAuthDomain() {
		return authDomain;
	}

	public void setAuthDomain(String authDomain) {
		this.authDomain = authDomain;
	}

	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getStorageBucket() {
		return storageBucket;
	}

	public void setStorageBucket(String storageBucket) {
		this.storageBucket = storageBucket;
	}

	public String getMessagingSenderId() {
		return messagingSenderId;
	}

	public void setMessagingSenderId(String messagingSenderId) {
		this.messagingSenderId = messagingSenderId;
	}

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	@Override
	public String toString() {
		return "StudentAuthentication [apiKey=" + apiKey + ", authDomain=" + authDomain + ", projectId=" + projectId
				+ ", storageBucket=" + storageBucket + ", messagingSenderId=" + messagingSenderId + ", appId=" + appId
				+ "]";
	}
}
