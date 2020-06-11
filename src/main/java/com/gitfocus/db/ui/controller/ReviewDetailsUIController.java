package com.gitfocus.db.ui.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gitfocus.db.ui.model.ReviewDetailsForTeamMembers;
import com.gitfocus.db.ui.service.IReviewDetailUIService;

/**
 * @author Tech Mahindra 
 * Controller class for review_details service from database to GUI
 */

@RestController
public class ReviewDetailsUIController {

	private static final Logger logger = LoggerFactory.getLogger(ReviewDetailsUIController.class);

	public ReviewDetailsUIController() {
		super();
		logger.info("ReviewDetailsUIController init");
	}

	@Autowired
	IReviewDetailUIService reviewService;

	/**
	 * 
	 * @param teamName
	 * @param repoName
	 * @param timeperiod
	 * @return dateBasedCommitDetailsForTeamMembers
	 */
	@GetMapping("/gitfocus/getDateBasedReviewDetailsForTeamMembers/{teamName}/{repoName}/{timeperiod}/{endDate}")
	public List<ReviewDetailsForTeamMembers> getDateBasedReviewDetailsForTeamMembers(
			@PathVariable("teamName") String teamName, @PathVariable("repoName") String repoName,
			@PathVariable("timeperiod") String timeperiod, @PathVariable("endDate") String endDate)
					throws JsonProcessingException {

		logger.info("getDateBasedReviewDetailsForTeamMembers", teamName, repoName, timeperiod, endDate);
		List<ReviewDetailsForTeamMembers> commitDetailsJson = null;
		commitDetailsJson = reviewService.dateBasedReviewDetailsForTeamMembers(teamName, repoName, timeperiod, endDate);
		logger.info("getDateBasedReviewDetailsForTeamMembers Records", commitDetailsJson);
		return commitDetailsJson;
	}

}
