package com.bcp.transform1.teamdashboard.restapi.bearer.service.impl;

import com.bcp.transform1.teamdashboard.restapi.bearer.dto.GitHubActivityIn;
import com.bcp.transform1.teamdashboard.restapi.bearer.mapper.GitHubActivityMapper;
import com.bcp.transform1.teamdashboard.restapi.bearer.repository.GitHubBearerClient;
import com.bcp.transform1.teamdashboard.restapi.bearer.service.GitHubBearerService;
import com.bcp.transform1.teamdashboard.restapi.bearer.vo.GitHubActivityVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GitHubBearerServiceImpl implements GitHubBearerService {
    @Autowired
    private GitHubBearerClient gitHubBearerClient;

    @Autowired
    private GitHubActivityMapper gitHubActivityMapper;

    @Override
    public List<GitHubActivityVO> getRepoActivities(String user, String repo) {
        List<GitHubActivityIn> gitHubActivityInList;
        gitHubActivityInList =  gitHubBearerClient.getRepoActivities(user, repo);


        return gitHubActivityMapper.mapListInToListVO(gitHubActivityInList);
    }
}
