package com.cognizant.CollegeRankingManagementSystem.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cognizant.CollegeRankingManagementSystem.firebase.CollegeAuthentication;
import com.cognizant.CollegeRankingManagementSystem.model.College;
import com.cognizant.CollegeRankingManagementSystem.repositories.CollegeRepository;
import com.cognizant.CollegeRankingManagementSystem.service.RankGenerator;
import com.cognizant.CollegeRankingManagementSystem.service.ScoreGenerator;


/*
 *  The controller class manages the transactions and connections.
 *  In this project JSP Pages are used in the front end design.
 *  "Model" is used to add or pass the instances onto the web page while using the Get Mapping.
 *  While using the Request Mapping, "ModelAndView" is used to send the attributes onto the web page.
 *  Autowired annotation is used to inject relevant class from the IOC Container.
 *  Application.properties file consists of the prefix and suffixes to maintain the project effectively.
 *  Firebase authentication of user is used in every page. Therefore we pass the values to every individual JSP page.
 */

@Controller
public class CollegeController {

	@Autowired
	CollegeAuthentication collegeAuthentication;

	@Autowired
	CollegeRepository collegeRepository;

	@Autowired
	RankGenerator rankGenerator;

	// Passing the College instance onto the JSP page to fetch the values to the @PostMapping.
	
	@GetMapping("addCollege")
	public String addCollege(Model model) {
		College college = new College();
		model.addAttribute("college", college);
		model.addAttribute("apiKey", collegeAuthentication.getApiKey());
		model.addAttribute("authDomain", collegeAuthentication.getAuthDomain());
		model.addAttribute("projectId", collegeAuthentication.getProjectId());
		model.addAttribute("storageBucket", collegeAuthentication.getStorageBucket());
		model.addAttribute("messagingSenderId", collegeAuthentication.getMessagingSenderId());
		model.addAttribute("appId", collegeAuthentication.getAppId());
		return "add_college";
	}
	
	// Getting the college instance added with values from the JSP page using ModelAttribute.
	// This method is used to add the college details as well as update the college details.
	@PostMapping("addCollege")
	public ModelAndView saveCollege(@ModelAttribute("college") College college) {
		ScoreGenerator scoreGenerator = new ScoreGenerator();

		// Calculating the scores using scoreGenerator. Functions are present in the service package.
		college.setOverallScore(scoreGenerator.generateOverallScore(college));
		college.setResearchScore(scoreGenerator.generateResearchScore(college));
		college.setEmploymentScore(scoreGenerator.generateEmploymentScore(college));

		// Saving the college model into the college repository.
		collegeRepository.save(college);

		// Calling an external function to refresh all the ranks after saving/updating the college details
		refreshRanks();

		// Sending the administrator to the front page after the specified process.
		// Setting and passing a new JSP page after saving the college.
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin_front_page");
		modelAndView.addObject("apiKey", collegeAuthentication.getApiKey());
		modelAndView.addObject("authDomain", collegeAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", collegeAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", collegeAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", collegeAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", collegeAuthentication.getAppId());

		return modelAndView;
	}

	// This method is used to update all the ranks after saving a college.
	// The  method is written separately as we don't have to update each and every college in case the formula for calculating the rank is changed.
	@RequestMapping("updateCollegeRanks")
	public void refreshRanks() {
		rankGenerator.refreshAllRanks();
	}

	// This method sends administrator to the front page after completing the login process.
	@RequestMapping("adminFrontPage")
	public ModelAndView toCollegeRegistration() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin_front_page");
		modelAndView.addObject("apiKey", collegeAuthentication.getApiKey());
		modelAndView.addObject("authDomain", collegeAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", collegeAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", collegeAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", collegeAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", collegeAuthentication.getAppId());
		return modelAndView;
	}

	// This link fetches the list of colleges from the database and presents it to the viewer sorted by overall rank.
	// This is used when a viewer clicks the "research based" results option on the student home page(after sign in) or the welcome page (without sign in).
	@RequestMapping("listAll")
	public ModelAndView listAllColleges() {
		
		// Fetching the details of the college sorted by overall rank. If both colleges have same rank, it is sorted by number of students per faculty.
		List<College> collegeList = collegeRepository.findAll(Sort.by("overallRank").and(Sort.by("numberOfStudentsPerFaculty")));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("collegeList", collegeList);
		modelAndView.setViewName("display_college");
		return modelAndView;
	}

	// This link fetches the list of colleges from the database and presents it to the viewer sorted by research rank.
	// This is used when a viewer clicks the "research based" results option on the student home page(after sign in) or the welcome page (without sign in).
	@RequestMapping("researchRanking")
	public ModelAndView researchRankingColleges() {
		
		// Fetching the details of the college sorted by research rank. If both colleges have same rank, it is sorted by overall rank.
		List<College> collegeList = collegeRepository.findAll(Sort.by("researchRank").and(Sort.by("overallRank")));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("collegeList", collegeList);
		modelAndView.setViewName("display_college");
		return modelAndView;
	}

	// This link fetches the list of colleges from the database and presents it to the viewer sorted by research rank.
	// This is used when a viewer clicks the "research based" results option on the student home page(after sign in) or the welcome page (without sign in).
	@RequestMapping("employmentRanking")
	public ModelAndView employmentRankingColleges() {
		
		// Fetching the details of the college sorted by employment rank. If both colleges have same rank, it is sorted by overall rank.
		List<College> collegeList = collegeRepository.findAll(Sort.by("employmentRank").and(Sort.by("overallRank")));
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("collegeList", collegeList);
		modelAndView.setViewName("display_college");
		return modelAndView;
	}

	// The below method is used where you can type the parameters directly on the URL.
	// We use this when viewver wants to see the list of colleges where a particular branch is present. We use it in student home page as well as welcome page.
	@RequestMapping("collegeByBranch/{q}")
	public ModelAndView listCollegesByBranch(@PathVariable String q) {
		
		// An external query is used in the college repository that gets the list of colleges when a particular branch is entered.
		List<College> collegeList = collegeRepository.findByBranchSorted(q);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("collegeList", collegeList);
		modelAndView.setViewName("display_college");
		return modelAndView;
	}

	// This is used for search process.
	// The String is received from the search box and sent to a created search query in college repository.
	@RequestMapping("Search")
	public ModelAndView Search(@Param("keyword") String keyword) {
		ModelAndView modelAndView = new ModelAndView();

		// Find all is the Search query in the college repository that returns the list of colleges that contain the keywords in pattern.
		List<College> collegeList = collegeRepository.findAll(keyword);
		modelAndView.addObject("collegeList", collegeList);
		modelAndView.setViewName("display_college");
		return modelAndView;
	}

	// This function is used to return the collegeView JSP page.
	@RequestMapping("collegeView")
	public ModelAndView returnCollegeView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("college-view");
		modelAndView.addObject("apiKey", collegeAuthentication.getApiKey());
		modelAndView.addObject("authDomain", collegeAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", collegeAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", collegeAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", collegeAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", collegeAuthentication.getAppId());
		return modelAndView;
	}

	// This method gets the college ID entered in the text box in JSP page and sends the respective college details to the update-college.jsp page.
	@RequestMapping("updateCollege")
	public ModelAndView updateCollege(@RequestParam int collegeId) {
		
		// Getting the college details using JPA Repository. If not found, will proceed to create a new college using that particular college ID.
		College college = collegeRepository.findById(collegeId).orElse(new College());
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("college", college);
		modelAndView.setViewName("update-college");

		modelAndView.addObject("apiKey", collegeAuthentication.getApiKey());
		modelAndView.addObject("authDomain", collegeAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", collegeAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", collegeAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", collegeAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", collegeAuthentication.getAppId());
		return modelAndView;
	}

	// This college redirects the administrator to the delete-college.jsp page where administrator can enter the college ID in order to delete the college.
	@RequestMapping("deleteCollegeView")
	public ModelAndView deleteCollegeView() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("delete_college");
		modelAndView.addObject("apiKey", collegeAuthentication.getApiKey());
		modelAndView.addObject("authDomain", collegeAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", collegeAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", collegeAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", collegeAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", collegeAuthentication.getAppId());
		return modelAndView;
	}

	// After entering the college ID, this command is used to delete the particular college from the database and redirect to the administrator front page.
	@RequestMapping("deleteCollege")
	public ModelAndView deleteCollege(@RequestParam int collegeId) {
		
		// The JPA Repository has this specific function to delete the college using college ID.
		collegeRepository.deleteById(collegeId);

		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("admin_front_page");
		modelAndView.addObject("apiKey", collegeAuthentication.getApiKey());
		modelAndView.addObject("authDomain", collegeAuthentication.getAuthDomain());
		modelAndView.addObject("projectId", collegeAuthentication.getProjectId());
		modelAndView.addObject("storageBucket", collegeAuthentication.getStorageBucket());
		modelAndView.addObject("messagingSenderId", collegeAuthentication.getMessagingSenderId());
		modelAndView.addObject("appId", collegeAuthentication.getAppId());
		return modelAndView;
	}
}