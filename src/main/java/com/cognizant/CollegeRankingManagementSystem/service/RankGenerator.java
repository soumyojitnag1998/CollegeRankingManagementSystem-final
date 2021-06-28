package com.cognizant.CollegeRankingManagementSystem.service;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.CollegeRankingManagementSystem.model.College;
import com.cognizant.CollegeRankingManagementSystem.repositories.CollegeRepository;

/*
 * This class generates ranks for the colleges using the college score.
 */

@Service
public class RankGenerator {
	
	@Autowired
	CollegeRepository collegeRepository;
	
	
	// This method is used to generate ranks for all the colleges at once using the individual college scores calculated.
	public void refreshAllRanks()
	{
		// List of college ranks are generated using RANK() function in SQL.
		List<Integer> overallRankList = collegeRepository.overallRankQuery();
		List<Integer> researchRankList = collegeRepository.researchRankQuery();
		List<Integer> employmentRankList = collegeRepository.employmentRankQuery();
		
		Iterator<Integer> overallIterator = overallRankList.listIterator();
		Iterator<Integer> researchIterator = researchRankList.listIterator();
		Iterator<Integer> employementIterator = employmentRankList.listIterator();

		// List of colleges are generated sorted in the same way as the ranks.
		List<College> collegeList = collegeRepository.overallScoreDescList();
		for(College c : collegeList)
		{
			// Rank is replaced/set to the ranks in the colleges.
			c.setOverallRank(overallIterator.next());
			collegeRepository.save(c);
		}
		
		// List of colleges are generated sorted in the same way as the ranks.
		collegeList = collegeRepository.researchScoreDescList();
		for(College c : collegeList)
		{
			// Rank is replaced/set to the ranks in the colleges.
			c.setResearchRank(researchIterator.next());
			collegeRepository.save(c);
		}

		// List of colleges are generated sorted in the same way as the ranks.
		collegeList = collegeRepository.employmentScoreDescList();
		for(College c : collegeList)
		{
			// Rank is replaced/set to the ranks in the colleges.
			c.setEmploymentRank(employementIterator.next());
			collegeRepository.save(c);
		}
	}
}
