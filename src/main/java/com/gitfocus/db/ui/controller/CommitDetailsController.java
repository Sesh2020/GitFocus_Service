package com.gitfocus.db.ui.controller;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.gitfocus.db.ui.model.TeamMembersCommitDetail;
import com.gitfocus.db.ui.model.TeamMembersCommitDetailOnDate;
import com.gitfocus.db.ui.model.TeamRepositoryCommitDetails;
import com.gitfocus.db.ui.service.ICommitDetailService;

/**
 * @author Tech Mahindra 
 * Controller class for commit_details service from database to GUI
 */

@RestController
public class CommitDetailsController {

    private static final Logger logger = LoggerFactory.getLogger(CommitDetailsController.class);

    public CommitDetailsController() {
        super();
        logger.info("CommitDetailsController init");
    }

    @Autowired
    ICommitDetailService commitService;

    /**
     * 
     * @param teamName
     * @param repoName
     * @param timeperiod
     * @return dateBasedCommitDetailsForTeamMembers
     */
    @GetMapping("/gitfocus/getDateBasedCommitDetailsForTeamMembers/{teamName}/{repoName}/{timeperiod}/{endDate}")
    public List<TeamMembersCommitDetail> getDateBasedCommitDetailsForTeamMembers(
            @PathVariable("teamName") String teamName, @PathVariable("repoName") String repoName,
            @PathVariable("timeperiod") String timeperiod, @PathVariable("endDate") String endDate)
            throws JsonProcessingException {

        logger.info("getDateBasedCommitDetailsForTeamMembers", teamName, repoName, timeperiod, endDate);
        List<TeamMembersCommitDetail> commitDetailsJson = null;
        commitDetailsJson = commitService.dateBasedCommitDetailsForTeamMembers(teamName, repoName, timeperiod, endDate);
        logger.info("getRepoCommitCountWeek Records", commitDetailsJson);
        return commitDetailsJson;
    }

    /**
     * 
     * @param repoName
     * @param userId
     * @param commitDate
     * @return
     * @throws ParseException
     */
    @GetMapping("/gitfocus/getCommitDetailOnDateForMemebers/{repoName}/{userId}/{commitDate}")
    public List<TeamMembersCommitDetailOnDate> getCommitDetailOnDateForMemebers(
            @PathVariable("repoName") String repoName, @PathVariable("userId") String userId,
            @PathVariable("commitDate") String commitDate) throws ParseException {
        logger.info("getCommitDetailOnDateForMemebers", userId, commitDate);
        List<TeamMembersCommitDetailOnDate> commitDetailsOnDateJson = null;
        commitDetailsOnDateJson = commitService.commitDetailOnDateForMemebers(userId, repoName, commitDate);
        logger.info("getCommitDetailOnDateForMemebers Records", commitDetailsOnDateJson);
        return commitDetailsOnDateJson;
    }

    /**
     * 
     * @param teamName, Repository
     * @return commitDetailsByTeamAndRepos
     */
    @GetMapping("/gitfocus/getRepoNames/{teamName}/{repoName}")
    public TeamRepositoryCommitDetails commitDetailsByTeamAndRepos(@PathVariable("teamName") String teamName,
            @PathVariable("repoName") String repoName) {
        logger.info("commitDetailsByTeamAndRepos", teamName, repoName);
        TeamRepositoryCommitDetails commitDetailsByTeamAndRepos = commitService.getCommitDetailsTeamAndRepos(teamName,
                repoName);
        logger.info("commitDetailsByTeamAndRepos Records", commitDetailsByTeamAndRepos);
        return commitDetailsByTeamAndRepos;
    }
}
